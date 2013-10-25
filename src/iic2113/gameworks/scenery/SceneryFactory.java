package iic2113.gameworks.scenery;

import java.util.List;

import javax.swing.JLabel;

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
	 */
	public static void createMap(){
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
	 * Method to create a default map object
	 * @return the map object
	 */
	public static MapObject createMapObject(){
		MapObject o = new MapObject();
		map.addMapObject(o);
		return o; //RETURN QUE?
	}

	/**
	 * Get map objects of the current map
	 * @return List of map objects as ISprites
	 */
//	public static List<iSprite> getMapObjects(){
//		return map.getObjects()
//	}
	
	/**
	 * Method to create a default map character
	 * @return the character
	 */
	public static MapCharacter createMapCharacter(){
		return new MapCharacter(); //RETURN SPRITE O QUE?
	}
	
	/**
	 * Method to add a new parameter to a character
	 * @param int character id
	 * @param String parameter name to add
	 * @param String value of the new parameter (if double, as 9.56, if boolean, as 0/1)
	 * @param Enum parameter type
	 */
	public static void setParameter(int id, String paramName, String value, VarType type){
//		MapObject tmp = map.getMapObjectsById(id);
//		if(type == VarType.BOOL){
//			boolean val;
//			if(value == "0")
//				val = false;
//			else
//				val = true;
//			tmp.addBoolParameter(paramName, val);
//		}
//		else if(type == VarType.DOUBLE){
//			tmp.addDoubleParameter(paramName, Double.parseDouble(value));
//		}
//		else if(type == VarType.INT){
//			tmp.addIntParameter(paramName, Integer.parseInt(value));
//		}
//		else {
//			tmp.addStringParameter(paramName, value);
//		}
	}
	
	
	/**
	 * Method to change a value parameter of a character
	 * @param int character id
	 * @param String parameter name to change
	 * @param String new value of the parameter
	 * @param Enum parameter type
	 */
	public static void editParameter(int id, String paramName, String value, VarType type){
//		MapObject tmp = map.getMapObjectsById(id);
//		if(type == VarType.BOOL){
//			boolean val;
//			if(value == "0")
//				val = false;
//			else
//				val = true;
//			tmp.setBoolParameter(paramName, val);
//		}
//		if(type == VarType.DOUBLE){
//			tmp.setDoubleParameter(paramName, Double.parseDouble(value));
//		}
//		if(type == VarType.INT){
//			tmp.setIntParameter(paramName, Integer.parseInt(value));
//		}
//		if(type == VarType.STRING){
//			tmp.setStringParameter(paramName, value);
//		}
	}

	/**
	 * Method to delete a parameter from a character
	 * @param int character id
	 * @param String parameter name to delete
	 */
	public static void deleteParameter(int id, String paramName){
//		MapObject tmp = map.getMapObjectsById(id);
//		if(type == VarType.BOOL)
//			tmp.deleteBoolParameter(paramName);
//		if(type == VarType.DOUBLE)
//			tmp.deleteDoubleParameter(paramName);
//		if(type == VarType.INT)
//			tmp.deleteIntParameter(paramName);
//		if(type == VarType.STRING)
//			tmp.deleteStringParameter(paramName);
	}


}
