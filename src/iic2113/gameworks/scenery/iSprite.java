package iic2113.gameworks.scenery;

import java.util.HashMap;

import javax.swing.JLabel;

/**
Interface for all Sprite classes
 	-Reference to external code-
 *
 *	@version  0.1
 *  @created_by @group5/gevalenz,javicabello,ngbravo,vibaseta
 *  @update_log
	24/10/2013 - @group5/ngbravo,gevalenz,javicabello,vibaseta      
 */

public interface ISprite {

	/**
	 * Getter for the Sprite JLabel
	 * @return The Sprite JLabel
	 */
	JLabel getSpriteJLabel();

	/**
	 * Setter for the Sprite JLabel
	 * @param spriteJLabel the new Sprite
	 */
	void setSpriteJLabel(JLabel spriteJLabel);

	/**
	 * Get the position of the Sprite
	 * @return Returns a int array of length=2. The position X will be in [0] and position Y will be in [1].
	 */
	int[] getPosition();

	/**
	 * Get the x position of the MapObject
	 * @return int position x
	 */
	int getX();

	/**
	 * Get the y position of the MapObject
	 * @return int position y
	 */
	int getY();


	/**
	 * Setter for positions
	 * @param positionX new position X
	 * @param positionY new position Y
	 */
	void setPosition(int positionX, int positionY);

	/**
	 * Getter for the Sprite ID
	 * @return The Sprite ID
	 */
	int getId();
	
	/**
	 * Getter for all String parameters
	 * @return The HashMap with all String parameters
	 */
	HashMap<String, String> getStringParameters();
	
	/**
	 * Getter for all Integer parameters
	 * @return The HashMap with all Integer parameters
	 */
	HashMap<String, Integer> getIntegerParameters();
	
	/**
	 * Getter for all Double parameters
	 * @return The HashMap with all Double parameters
	 */
	HashMap<String, Double> getDoubleParameters();
	
	/**
	 * Getter for all Boolean parameters
	 * @return The HashMap with all Boolean parameters
	 */
	HashMap<String, Boolean> getBooleanParameters();
}
