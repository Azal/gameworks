package game;

import java.awt.Graphics;
import java.awt.Toolkit;
import javax.swing.JPanel;

/**
	GameBoard is the JPanel (generic lightweight container) for our GameWindows class.
	@version  1.0  
	@created_by @group6/muZk
	@update_log
                26/09/2013 * @group6/muZk - Created the class.         
*
*/

public class GameBoard extends JPanel {

	/**
	 * Object with Drag() method which will drag elements 
	 * in GameBoard panel
	 */
	GameWindows windows = null;
	
    public GameBoard() {
        setFocusable(true);
        setDoubleBuffered(true);
    }

    /**
     * Calls Draw() method of GameWindows Object
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if(windows != null){
        	windows.Draw(g);	
        }
        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }
    
    /**
     * Setter for drawable object
     * @param IDraw object
     */
    public void setWindows(GameWindows gw){
    	windows = gw;
    }
}