package iic2113.gameworks.scenery;

import javax.swing.JLabel;

/**
All characters and object inherit from this class
 	-Reference to external code-
 *
 *	@version  0.1
@created_by @group5/gevalenz,javicabello,ngbravo,vibaseta
@update_log
	22/10/2013 - @group5/ngbravo,gevalenz,javicabello,vibaseta      
 */

abstract class MapObject {

	protected JLabel spritePath;
	protected int posX;
	protected int posY;
	/**
	 * 
	 * @return
	 */
	JLabel getSpritePath(){
		return spritePath;
	}

	/**
	 * 
	 * @param spritePath
	 */
	void setSpritePath(JLabel spritePath){
		this.spritePath=spritePath;
	}

	/**
	 * Method to move the Sprite in a given direction and distance
	 * @param direction Direction of the movement. Can be UP, DOWN, LEFT, RIGHT
	 * @param distance How many grid spaces will it move in the given direction
	 */
	void move(Direction direction, int distance){
		switch (direction) {
		case UP:
			posY+=distance;
			break;

		case DOWN:
			posY-=distance;
			break;	

		case LEFT:
			posX-=distance;
			break;	

		case RIGHT:
			posX+=distance;
			break;
		}
	}

	/**
	 * Get the position of the Sprite
	 * @return Returns a int array of length=2. The position X will be in [0] and position Y will be in [1].
	 */
	int[] getPosition(){
		int[] position=new int[2];
		position[0]=posX;
		position[1]=posY;
		return position;
	}
	
	/**
	 * Get the x position of the MapObject
	 * @return int position x
	 */
	int getX(){
		return posX;
	}
	
	/**
	 * Get the y position of the MapObject
	 * @return int position y
	 */
	int getY(){
		return posY;
	}


	/**
	 * Setter for positions
	 * @param positionX new position X
	 * @param positionY new position Y
	 */
	void setPosition(int positionX, int positionY){
		posX=positionX;
		posY=positionY;
	}

}
