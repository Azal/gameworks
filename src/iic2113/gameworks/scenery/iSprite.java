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

	public void addStringParameter(String name, String value);
	
	public void addIntParameter(String name, int value);
	
	public void addBoolParameter(String name, boolean value);
	
	public void addDoubleParameter(String name, double value);
	
	public String getStringParameter(String name);
	
	public int getIntParameter(String name);
	
	public boolean getBoolParameter(String name);
	
	public double getDoubleParameter(String name);
	
	
}
