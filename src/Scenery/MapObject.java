package src.Scenery;

/**
Abstract class for all objects. They may be triggered or not. Ex: treasure chets, rocks, bushes, walls, etc.
 	-Reference to external code-
*
*	@version  0.1
@created_by @group5/,gevalenz,javicabello,ngbravo
@update_log
	26/09/2013 - @group5/ngbravo,gevalenz,javicabello
*/

public class MapObject {
	
	/**
	 * name: name of the object 
	 */
	protected String name;
	
	/**
	 * height: amount of grid spaces down of the MapObject
	 */
	protected int height;
	/**
	 * width: amount of grid spaces right of the MapObject
	 */
	protected int width;
	/**
	 * positionX: X coordinate of the top-left corner of the MapObject
	 */
	protected int positionX;
	/**
	 * positionY: Y coordinate of the top-left corner of the MapObject
	 */
	protected int positionY;
	/**
	 * spritePath: path to the sprite of the MapObject
	 */
	protected String spritePath;
	
	/**
	 * Constructor
	 */
	public MapObject(){
		height = 1;
		width = 1;
		positionX = 0;
		positionY = 0;
		spritePath = null;
		name = "Default Name";
	}
	
	/**
	 * Method run when the object is activated. It is subscribed to an Event.
	 */
	public void activate(){
		
	}
	
	/**
	 * Getter for positionX
	 * @return value of positionX
	 */
	public int getPositionX(){
		return positionX;
	}
	
	/**
	 * Getter for positionY
	 * @return value of positionY
	 */
	public int getPositionY(){
		return positionY;
	}
	
	/**
	 * Getter for height
	 * @return value of height
	 */
	public int getHeight(){
		return height;
	}
	
	/**
	 * Getter for width
	 * @return value of width
	 */
	public int getWidth(){
		return width;
	}
	
	/**
	 * Method run to destroy this object. It is subsribed to an Event.
	 */
	public void destroy(){
		
	}
	
	/**
	 * Setter for spritePath
	 * @param path the new spritePath
	 */
	public void setSpritePath(String path){
		spritePath=path;
	}
	
	/**
	 * Getter for spritePath
	 * @return spritePath
	 */
	public String getSpritePath(){
		return spritePath;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
