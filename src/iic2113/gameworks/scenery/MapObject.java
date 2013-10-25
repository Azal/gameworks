package iic2113.gameworks.scenery;

import java.util.HashMap;
import javax.swing.JLabel;

/**
All characters and object inherit from this class
 	-Reference to external code: java.util.HashMap, javax.swing.JLabel-
 *
 *	@version  0.1
 *  @created_by @group5/gevalenz,javicabello,ngbravo,vibaseta
 *  @update_log
	22/10/2013 - @group5/ngbravo,gevalenz,javicabello,vibaseta      
 */

class MapObject implements ISprite{

	/**
	 * ID for the MapObject
	 */
	protected int id;
	/**
	 * JLabel for this MapObject's Sprite
	 */
	protected JLabel spriteJLabel;
	/**
	 * Position of this MapObject in the X-Axis
	 */
	protected int posX;
	/**
	 * Position of this MapObject in the Y-Axis
	 */
	protected int posY;
	/**
	 * HashMap/Dictionary for all String type parameters for this MapObject
	 */
	protected HashMap<String,String> stringParameters;
	/**
	 * HashMap/Dictionary for all Integer type parameters for this MapObject
	 */
	protected HashMap<String,Integer> intParameters;
	/**
	 * HashMap/Dictionary for all Boolean type parameters for this MapObject
	 */
	protected HashMap<String,Boolean> booleanParameters;
	/**
	 * HashMap/Dictionary for all Double type parameters for this MapObject
	 */
	protected HashMap<String,Double> doubleParameters;

	/**
	 * Adds a new String parameter of given name and value
	 * @param name Name (key) for the new String parameter
	 * @param value The String value
	 */
	public void addStringParameter(String name, String value){
		if(!stringParameters.containsKey(name))
			stringParameters.put(name, value);
	}

	/**
	 * Adds a new Integer parameter of given name and value
	 * @param name Name (key) for the new Integer parameter
	 * @param value The Integer value
	 */
	public void addIntParameter(String name, int value){
		if(!intParameters.containsKey(name))
			intParameters.put(name, value);
	}

	/**
	 * Adds a new Boolean parameter of given name and value
	 * @param name Name (key) for the new Boolean parameter
	 * @param value The Boolean value
	 */
	public void addBooleanParameter(String name, boolean value){
		if(!booleanParameters.containsKey(name))
			booleanParameters.put(name, value);
	}

	/**
	 * Adds a new Double parameter of given name and value
	 * @param name Name (key) for the new Double parameter
	 * @param value The Double value
	 */
	public void addDoubleParameter(String name, double value){
		if(!doubleParameters.containsKey(name))
			doubleParameters.put(name, value);
	}

	/**
	 * Get the value of a String parameter with a given name (key).
	 * @param name Name (key) of the String parameter
	 * @return The value of the String parameter
	 */
	public String getStringParameter(String name){
		return stringParameters.get(name);
	}

	/**
	 * Get the value of a Integer parameter with a given name (key).
	 * @param name Name (key) of the Integer parameter
	 * @return The value of the Integer parameter
	 */
	public int getIntegerParameter(String name){
		return intParameters.get(name);
	}

	/**
	 * Get the value of a Boolean parameter with a given name (key).
	 * @param name Name (key) of the Boolean parameter
	 * @return The value of the Boolean parameter
	 */
	public boolean getBooleanParameter(String name){
		return booleanParameters.get(name);
	}

	/**
	 * Get the value of a Double parameter with a given name (key).
	 * @param name Name (key) of the Double parameter
	 * @return The value of the Double parameter
	 */
	public double getDoubleParameter(String name){
		return doubleParameters.get(name);
	}


	/**
	 * Get the sprite path
	 * @return JLabel spirtePath
	 */
	public JLabel getSpriteJLabel(){
		return spriteJLabel;
	}

	/**
	 * Set the sprite path
	 * @param JLabel spritePath
	 */
	public void setSpriteJLabel(JLabel spritePath){
		this.spriteJLabel=spritePath;
	}

	/**
	 * Get the map object id
	 * @return id
	 */
	public int getId(){
		return id;
	}


	/**
	 * Get the position of the Sprite
	 * @return Returns a int array of length=2. The position X will be in [0] and position Y will be in [1].
	 */
	public int[] getPosition(){
		int[] position=new int[2];
		position[0]=posX;
		position[1]=posY;
		return position;
	}

	/**
	 * Get the x position of the MapObject
	 * @return int position x
	 */
	public int getX(){
		return posX;
	}

	/**
	 * Get the y position of the MapObject
	 * @return int position y
	 */
	public int getY(){
		return posY;
	}


	/**
	 * Setter for positions
	 * @param positionX new position X
	 * @param positionY new position Y
	 */
	public void setPosition(int positionX, int positionY){
		posX=positionX;
		posY=positionY;
	}


}
