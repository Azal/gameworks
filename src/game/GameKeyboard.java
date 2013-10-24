package game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

/**
	GameKeyboard is the representation of the Player's Keyboard.
	It has methods to know what keys are pressed.
	@version  1.0  
	@created_by @group6/muZk
	@update_log
	            22/10/2013 * @group6/muZk - Created the class.         
**/

public class GameKeyboard extends KeyAdapter  {
	
	/**
	 * Singleton instance
	 * @author muZk
	 */
	private static GameKeyboard instance;
	
	/**
	 * Array of keys pressed (key codes)
	 * @author muZk
	 */
	private ArrayList<Integer> pressed = new ArrayList<Integer>();
	
	private GameKeyboard(){
	}
	
	/**
	 * Singlethon constructor
	 * @author muZk
	 * @return
	 */
	public static GameKeyboard Create(){
		if(instance == null)
			instance = new GameKeyboard();
		return instance;
	}
	
	/**
	 * Called when the User clicks a Keyboard key
	 * It saves the keycode inside the array of pressed keys
	 * @author muZk
	 */
    public void keyPressed(KeyEvent e) {
    	int key = e.getKeyCode();
    	if(!pressed.contains(key)){
    		pressed.add(key);
    	}
    }
	
    /**
     * Called when the user releases a Keyboard key.
     * It removes the keycode from the array of pressed keys
     * @author muZk
     */
    public void keyReleased(KeyEvent e) {
    	int key = e.getKeyCode();
    	pressed.remove(pressed.indexOf(key));
    }
    
    /**
     * Returns true if @keyCode is pressed, false if not.
     * @param keyCode KeyCode of the key to query
     * @return Boolean
     */
    public boolean isPressed(int keyCode){
    	return pressed.contains(keyCode);
    }
}