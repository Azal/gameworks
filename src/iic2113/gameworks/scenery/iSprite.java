package iic2113.gameworks.scenery;

import javax.swing.JLabel;

interface iSprite {

	/**
	 * 
	 * @return
	 */
	JLabel getSpritePath();

	/**
	 * 
	 * @param spritePath
	 */
	void setSpritePath(JLabel spritePath);

	/**
	 * Method to move the Sprite in a given direction and distance
	 * @param direction Direction of the movement. Can be UP, DOWN, LEFT, RIGHT
	 * @param distance How many grid spaces will it move in the given direction
	 */
	void move(Direction direction, int distance);

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

	
	
	
}
