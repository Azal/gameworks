package iic2113.gameworks.scenery;

import java.util.List;

import javax.swing.JLabel;

/**
Here reside all methods to create scenery
 	-Reference to external code-
 *
 *	@version  0.1
 *  @created_by @group5/gevalenz,javicabello,ngbravo,vibaseta
 *  @update_log
	26/09/2013 - @group5/ngbravo,gevalenz,javicabello,vibaseta     
 */

public abstract class SceneryFactory {

	protected static Map map;
	protected static int nextId;

	/**
	 * Method to create a default map
	 */
	public static void createMap(){
		nextId = 0;
		map = new Map();
	}

	/**
	 * Method to create a map
	 * @param xDim dimension of the X coordinate of the map
	 * @param yDim dimension of the Y coordinate of the map
	 */
	public static void createMap(int xDim, int yDim){
		map = new Map(xDim,yDim);
	}


	/**
	 * Save the current map
	 * @return true if the map was saved correctly
	 */
	public static boolean saveMap(String path){
		//PERSISTENCIA SAVE MAPs
		return true;
	}


	/**
	 * Get a saved map
	 * @param string path to the map
	 */
	public static void useSavedMap(String path){
		//PERSISTENCIA GET MAP
		//map = 
	}
	
	/**
	 * Method to delete the current map
	 */
	public static void deleteCurrentMap(){
		map = null;
	}
	
	/**
	 * Method to delete a saved map
	 * @param String path of the map to delete
	 */
	public static void deleteSavedMap(String path){
		Map aux = map;
		useSavedMap(path);
		deleteCurrentMap();
		map = aux;
	}

	/**
	 * Set sprite of the current map
	 * @param JLabel mapSprite
	 */
	public static void setMapSprite(String path){
		//PEDIR A ALGUIEN
		//JLabel x = persistencia
		//map.setSpritePath(x);
	}

	/**
	 * Get sprite of the current map
	 * @return JLabel mapSprite
	 */
	public static JLabel getMapSprite(){
		return map.getSpritePath();
	}

	/**
	 * Get size of the current map
	 * @return int[] with x dimension and y dimension of the map
	 */
	public static int[] getMapSize(){
		//return map.getSize();
		int i[] = new int[2]; 
		return i;
	}

	/**
	 * Get map objects of the current map
	 * @return List of map objects as ISprites
	 */
//	public static List<ISprite> getMapObjects(){
//		return map.getObjects()
//	}
	
	/**
	 * Method to create a default map object
	 * @return the map object as ISprite
	 */
	public static ISprite createMapObject(){
		MapObject o = new MapObject(getNextId());
		map.addMapObject(o);
		return (ISprite)o;
	}
	
	/**
	 * Method to create a default map character
	 * @return the character as ISprite
	 */
	public static ISprite createMapCharacter(){
		return (ISprite)new MapCharacter(getNextId());
	}
	
	/**
	 * Method to add or update a boolean parameter to a character
	 * @param int character id
	 * @param String parameter name to add
	 * @param String value of the new parameter
	 */
	public static void setParameter(int id, String paramName, boolean value){
//		MapObject tmp = map.getMapObjectsById(id);
//		tmp.addParameter(paramName, value);
	}
	
	/**
	 * Method to add or update a double parameter to a character
	 * @param int character id
	 * @param String parameter name to add
	 * @param String value of the new parameter
	 */
	public static void setParameter(int id, String paramName, double  value){
//		MapObject tmp = map.getMapObjectsById(id);
//		tmp.addParameter(paramName, value);
	}
	
	/**
	 * Method to add or update a int parameter to a character
	 * @param int character id
	 * @param String parameter name to add
	 * @param String value of the new parameter
	 */
	public static void setParameter(int id, String paramName, int value){
//		MapObject tmp = map.getMapObjectsById(id);
//		tmp.addParameter(paramName, value);
	}
	
	/**
	 * Method to add or update a string parameter to a character
	 * @param int character id
	 * @param String parameter name to add
	 * @param String value of the new parameter
	 */
	public static void setParameter(int id, String paramName, String  value){
//		MapObject tmp = map.getMapObjectsById(id);
//		tmp.addParameter(paramName, value);
	}
	
	/**
	 * Method to delete a parameter from a character
	 * @param int character id
	 * @param String parameter name to delete
	 */
	public static void deleteParameter(int id, String paramName){
//		MapObject tmp = map.getMapObjectsById(id);
//		tmp.deleteParameter(paramName);
	}
	
	protected static int getNextId(){
		return nextId++;
	}
}
