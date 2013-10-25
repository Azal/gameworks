package iic2113.gameworks.scenery;

/**
Here reside all methods to create scenery
 	-Reference to external code-
*
*	@version  0.1
@created_by @group5/gevalenz,javicabello,ngbravo
@update_log
	26/09/2013 - @group5/ngbravo,gevalenz,javicabello       
*/

public abstract class SceneryFactory {
	
	
	/**
	 * Method to create a defaut map
	 * @return the map
	 */
	public static Map createMap(){
		return new Map();
	}
	
	/**
	 * Method to create a map
	 * @param xDim dimension of the X coordinate of the map
	 * @param yDim dimension of the Y coordinate of the map
	 * @return the map
	 */
	public static Map createMap(int xDim, int yDim){
		return new Map(xDim,yDim);
	}
	
	/**
	 * Method to create a default map object
	 * @return the map object
	 */
	public static MapObject createMapObject(){
		return new MapObject();
	}
	
	/**
	 * Method to create a default map character
	 * @return the character
	 */
	public static MapCharacter createMapCharacter(){
		return new MapCharacter();
	}



}
