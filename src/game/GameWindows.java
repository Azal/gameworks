package game;

import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
	This the main game windows. Game windows should extends this class in
	order to create a game. It also has usefull methods to make the 
	game developer life easier.
	
	@version  2.0
	@created_by @group6/timartin
	@update_log
				27/09/2013 - @group6/timartin, nggomez  
	            22/10/2013 - @group6/muZk,timartin,panchotron - Refactor and new methods.
*/
public abstract class GameWindows extends JFrame {

	private String name;
	private int width;
	private int height;
	private GameBoard board;
	private GameThread thread;
	private GameKeyboard keyboard;
	private GameTime gametime;
	private boolean paused;
	private boolean closed;
	
	/**
     * Public constructor for Game
     * @param name this name will appears in the window
     * @param width of the Game Window
     * @param height of the Game Window
     * @return Game Object
     * @author timartin
     */
	public GameWindows(String name, int width, int height){
		closed = false;
		this.name = name;
		this.width = width;
		this.height = height;
		keyboard = GameKeyboard.Create();
		gametime = GameTime.Create();
		InitUI();
	}
	
	/**
	 * Initializes the UI and KeyBoard listeners
	 */
	private void InitUI(){
		board = new GameBoard();
		board.setWindows(this);
		add(board);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(width,height);
        setLocationRelativeTo(null);
        setTitle(name);
        setResizable(false);
        setFocusable(true); // keyAdapter
        addKeyListener(keyboard);
	}
	
	/**
	 * Updates the elements in the window. This method
	 * is called on every game tick by the GameThread.
	 */
	public void Update(){
		// Every repaint method calls internally to paint()
		// So, calling Update() does the following:
		// this.repaint() -> this.paint()
		// this.paint() -> board.repaint() [see GameWindows.paint]
		// board.paint() -> board.paint()
		// board.paint() -> this.drag() [see GameBoard class]
		this.repaint();
	}
	
    /**
     * Shows the Game windows
     * @author timartin
     */
	public void Init(){
		setVisible(true);
		thread = new GameThread(this);
		thread.run();
	}
	
	/**
	 * Method to draw elements in the game windows.
	 * It is called only by gameboard on its paint() call.
	 * @author muZk
	 */
	public void Draw(Graphics g) {
		// TODO Auto-generated method stub
	}
	
	/**
	 * Internally calls board's paint() method
	 * @author muZk
	 */
	public void paint(){
		board.repaint();
	}
	
	/**
	 * Returns true if the @key is pressed
	 * @param key code
	 * @author muZk
	 * @return
	 */
	public boolean IsKeyPressed(int key){
		return keyboard.isPressed(key);
	}
	
	/**
     * Pauses the game. Note: Remember MULTIPLAYER...
     * @author muZk
     */
	public void Pause(){
		paused = true;
		gametime.Pause();
	}
	
    /**
     * Resumes the game. Note: Remember MULTIPLAYER...
     * @author muZk
     */
	public void Resume(){
		paused = false;
		gametime.Resume();
	}

	/**
     * @return true if the game is paused, false if not.
     * @author muZk
     * @return boolean
     */
	public boolean isPaused() {
		return paused;
	}
	
	/**
	 * Returns the internal GameTime object
	 * @author muZk
	 * @return GameTime object
	 */
	public GameTime getGameTime(){
		return gametime;
	}
	
	 /**
     * @return mouse position relative to the game windows
     * @author panchotron
     */
    public Point getMousePosition(){
        Point p = MouseInfo.getPointerInfo().getLocation();
        SwingUtilities.convertPointFromScreen(p, this);
        return p;
    }
    
    /**
     * @return mouse position coordinate X relative to the game windows
     * @author panchotron
     */
    public double getMousePositionX(){
    	return getMousePosition().getX();
    }
    
    /**
     * @return mouse position coordinate Y relative to the game windows
     * @author panchotron
     */
    public double getMousePositionY()    {
    	return getMousePosition().getY();
    }
	
    /**
     * Closes the game windows
     * @author muZk
     */
    public void Close(){
    	closed = true;
    	// http://stackoverflow.com/questions/1234912/how-to-programmatically-close-a-jframe/4640574#4640574
    	dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }
    
    /**
     * Return true if the game windows is closed.
     * (NOTE: it is used in the GameThread, but I'm not sure if it is necessary...)
     * @author muZk
     * @return boolean
     */
    public boolean isClosed(){
    	return closed;
    }
    
}