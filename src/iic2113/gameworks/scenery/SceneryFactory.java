package iic2113.gameworks.scenery;

/**
Here reside all methods to create scenery
 	-Reference to external code-
 *
 *	@version  0.1
 *  @created_by @group5/gevalenz,javicabello,ngbravo
 *  @update_log
	26/09/2013 - @group5/ngbravo,gevalenz,javicabello       
 */

public abstract class SceneryFactory {

	protected static Map map;

	/**
	 * Method to create a default map
	 * @return the map
	 */
	public static Map createMap(){
		map = new Map();
		return map;
	}

	/**
	 * Method to create a map
	 * @param xDim dimension of the X coordinate of the map
	 * @param yDim dimension of the Y coordinate of the map
	 * @return the map
	 */
	public static Map createMap(int xDim, int yDim){
		map = new Map(xDim,yDim);
		return map;
	}

	/**
	 * Get the current map
	 * @return the map
	 */
	public static Map getCurrentMap(){
		return map;
	}


	/**
	 * Save the current map
	 * @return true if the map was saved correctly
	 */
	public static boolean saveMap(){
		//PERSISTENCIA SAVE MAP
		return true;
	}


	/**
	 * Get a saved map
	 * @param int id of the map
	 * @return the map
	 */
	public static Map getMap(int id){
		//PERSISTENCIA GET MAP
		return map;
	}

	/**
	 * Method to create a default map object
	 * @return the map object
	 */
	public static MapObject createMapObject(){
		MapObject o = new MapObject();
		o.setPosition(-1,-1);
		map.addMapObject(o);
		return o;
	}

	/**
	 * Method to create a default map character
	 * @return the character
	 */
	public static MapCharacter createMapCharacter(){
		return new MapCharacter();
	}



}
