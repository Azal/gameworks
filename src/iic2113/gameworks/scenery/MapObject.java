package iic2113.gameworks.scenery;

import java.util.HashMap;

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

class MapObject implements iSprite{
	
	protected int id;
	protected JLabel spritePath;
	protected int posX;
	protected int posY;
	protected HashMap<String,String> stringParameters;
	protected HashMap<String,Integer> intParameters;
	protected HashMap<String,Boolean> boolParameters;
	protected HashMap<String,Double> doubleParameters;
	
	public void addStringParameter(String name, String value){
		if(!stringParameters.containsKey(name))
			stringParameters.put(name, value);
	}
	
	public void addIntParameter(String name, int value){
		if(!intParameters.containsKey(name))
			intParameters.put(name, value);
	}
	
	public void addBoolParameter(String name, boolean value){
		if(!boolParameters.containsKey(name))
			boolParameters.put(name, value);
	}
	
	public void addDoubleParameter(String name, double value){
		if(!doubleParameters.containsKey(name))
			doubleParameters.put(name, value);
	}
	
	public String getStringParameter(String name){
		return stringParameters.get(name);
	}
	
	public int getIntParameter(String name){
		return intParameters.get(name);
	}
	
	public boolean getBoolParameter(String name){
		return boolParameters.get(name);
	}
	
	public double getDoubleParameter(String name){
		return doubleParameters.get(name);
	}
	
	
	/**
	 * Get the sprite path
	 * @return JLabel spirtePath
	 */
	public JLabel getSpritePath(){
		return spritePath;
	}

	/**
	 * Set the sprite path
	 * @param JLabel spritePath
	 */
	public void setSpritePath(JLabel spritePath){
		this.spritePath=spritePath;
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
