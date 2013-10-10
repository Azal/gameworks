
//package src;

import java.awt.Dimension;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.image.BufferStrategy;

import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

/**
-Class description goes here.-
	-Reference to external code-
*
*	@version  0.1
@created_by @group6/timartin
@update_log
	27/09/2013 - @group6/timartin, nggomez        
*/

/**  
 * Game
 */


public class Game {

	private static Game game;

	private JFrame container;
	private JPanel panel;
	private BufferStrategy strategy;

	private long startedAt;
	
	private boolean paused = false;
	private long pausedTime = 0;
	private long pausedAt = 0;

	private Game(String name, int width, int height)
	{
		container = new JFrame(name);
		container.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		container.setResizable(false);

		panel = (JPanel) container.getContentPane();
		panel.setPreferredSize(new Dimension(width,height));
		panel.setLayout(null);

		panel.setBounds(0,0,800,600);

		container.pack();
		container.setResizable(false);
		//container.setVisible(true);

		container.createBufferStrategy(2);

		strategy = container.getBufferStrategy();

		startedAt = System.currentTimeMillis();

	}

	/**
	 * Public constructor for Game
	 * @param name this name will appears in the window
	 * @param width of the Game Window
	 * @param height of the Game Window
	 * @return Game Object
	 * @throws Exception if the game already exists
	 * @author timartin
	 */
	public static Game Create(String name, int width, int height) throws Exception
	{
		if(game == null)
		{
			game = new Game(name, width, height);
		}
		else
		{
			throw new Exception();
		}

		return game;
	}


	/**
	 * Returns the unique instance of Game class (Singleton)
	 * @return Game
	 * @throws Exception
	 */
	public static Game GetGame() throws Exception
	{
		if(game == null)
		{
			throw new Exception();
		}
		return game;
	}

	/**
	 * Shows the Game windows
	 * @author timartin
	 * @throws Exception
	 */
	public void Init() throws Exception
	{
		container.setVisible(true);
		
		onInit();

		GameThread gt = new GameThread(game);
		gt.run();

	}
	
	/**
	 * This method is called when game.Init()
	 * @author nggomez
	 */
	private void onInit(){
		// here it should load all events (key, mouse, etc) and initial map state
	}

	public BufferStrategy GetStrategy()
	{
		return strategy;
	}

	public long getGameTime(){
		return System.currentTimeMillis()-startedAt-pausedTime;
	}


	/**
	 * Register an action callback to a Keyboard key press.
	 * @param key is the keyboard key, for example: "SPACE", "ENTER", etc
	 * @param action Instance of a class that is derived from AbstractAction
	 */
	public void onKeyPress(String key, Action action){
		KeyStroke keyStroke = KeyStroke.getKeyStroke(key);
		panel.getInputMap().put(keyStroke, key);
		panel.getActionMap().put(key, action);
	}
	
	/**
	 * @return mouse position relative to the game windows
	 * @author panchotron
	 */
	public Point getMousePosition(){
		Point p = MouseInfo.getPointerInfo().getLocation();
		SwingUtilities.convertPointFromScreen(p, container);
		return p;
	}
	
	/**
	 * @return mouse position coordinate X relative to the game windows
	 * @author panchotron
	 */
	public double getMousePositionX()
	{
		return getMousePosition().getX();
	}
	
	/**
	 * @return mouse position coordinate Y relative to the game windows
	 * @author panchotron
	 */
	public double getMousePositionY()
	{
		return getMousePosition().getY();
	}
	
	/**
	 * Closes the entire program (not only the game windows)
	 * @author nggomez
	 */
	public void Close(){
		System.exit(0);
	}
	
	/**
	 * Pauses the game. Note: Remember MULTIPLAYER...
	 * @author nggomez
	 */
	public void Pause(){
		paused = true;
		pausedAt = System.currentTimeMillis();
	}
	
	/**
	 * Resumes the game. Note: Remember MULTIPLAYER...
	 * @author nggomez
	 */
	public void Resume(){
		paused = false;
		pausedTime = System.currentTimeMillis() - pausedAt;
	}
	
	/**
	 * @return true if the game is paused, false if not.
	 * @author nggomez
	 */
	public boolean isPaused(){
		return paused;
	}
}