package iic2113.gameworks.scenery;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;

/**
Here reside all MapObjects and MapCharacters that compose the Map
 	-Reference to external code-
*
*	@version  0.1
@created_by @group5/gevalenz,javicabello,ngbravo,vibaseta
@update_log
	26/09/2013 - @group5/ngbravo,gevalenz,javicabello,vibaseta      
*/


class Map {
	
	/**
	 * List for all MapCharacters
	 */
	protected List<MapCharacter> characters; 
	/**
	 * List for all non-character MapObjects
	 */
	protected List<MapObject> objects; 
	/**
	 * Grid that represents the map. It has every object in the map, 
	 * where it's position in the matrix is the same as it's position in the map
	 */
	protected MapObject grid[][];
	/**
	 * JLabel for the Sprite of this Map.
	 */
	protected JLabel mapSprite;
	
	
	/**
	 * Constructor by default dimensions 20 x 20
	 */
	public Map(){
		characters = new ArrayList<MapCharacter>();
		objects = new ArrayList<MapObject>();
		grid = new MapObject[20][20];
		//recursos ver path de imagen del mapa
	}
	
	/**
	 * Constructor
	 * @param n dimension of the X coordinate of the map
	 * @param m dimension of the Y coordinate of the map
	 */
	public Map( int n, int m){
		characters = new ArrayList<MapCharacter>();
		objects = new ArrayList<MapObject>();
		grid = new MapObject[n][m];
		//recursos ver path de imagen del mapa
	}

	/**
	 * Get the sprite path
	 * @return JLabel mapSprite
	 */
	public JLabel getSpritePath(){
		return mapSprite;
	}

	/**
	 * Set the sprite path
	 * @param JLabel mapSprite
	 */
	public void setSpritePath(JLabel mapSprite){
		this.mapSprite=mapSprite;
	}

	/**
	 * Method to add MapCharacter to the map
	 * @param c MapCharacter to add
	 * @return true if the MapCharacter was added and false if it wasn't added because there is another 
	 * mapObject in the same position
	 */
	public boolean addMapCharacter( MapCharacter c){
		if(grid[c.getX()] == null && grid[c.getY()] == null){
			characters.add(c);
			grid[c.getX()][c.getY()] = c;
			return true;
		}
		return false;
	}
	
	/**
	 * Method to add MapObject to the map
	 * @param o MapObject to add
	 * @return true if the MapObject was added and false if it wasn't added because there is another 
	 * mapObject in the same position
	 */
	public boolean addMapObject( MapObject o){
		if(grid[o.getX()] == null && grid[o.getY()] == null){
			objects.add(o);
			grid[o.getX()][o.getY()] = o;
			return true;
		}
		return false;
	}
	
	/**
	 * Method to check if a position in the map is occupied
	 * @param x position in the map
	 * @param y position in the map
	 * @return the mapObject in the given position
	 */
	public MapObject checkPosition(int x, int y){
		return grid[x][y];		
	}
	
	/**
	 * Method to delete MapCharacter to the map
	 * @param c MapCharacter to delete
	 * @return true if the MapCharacter was deleted and false if the MapCharacter doesnt exist
	 */
	public boolean deleteMapCharacter( MapCharacter c){
		grid[c.getX()][c.getY()] = null;
		return characters.remove(c);
	}
	
	/**
	 * Method to delete MapCharacter to the map
	 * @param x position in the map
	 * @param y position in the map
	 * @return true if the MapCharacter was deleted and false if the position is empty
	 */
	public boolean deleteMapCharacter( int x, int y){
		MapCharacter c = (MapCharacter)checkPosition(x,y);
		if(c == null)
			return false;
		return deleteMapCharacter(c);
	}
	
	/**
	 * Method to delete MapObject to the map
	 * @param o MapObject to delete
	 * @return true if the MapObject was deleted and false if the MapObject doesnt exist
	 */
	public boolean deleteMapObject( MapObject o){
		grid[o.getX()][o.getY()] = null;
		return objects.remove(o);
	}
	
	/**
	 * Method to delete MapObject to the map
	 * @param x position in the map
	 * @param y position in the map
	 * @return true if the MapObject was deleted and false if the position is empty
	 */
	public boolean deleteMapObject( int x, int y){
		MapObject o = checkPosition(x,y);
		if(o == null)
			return false;
		return deleteMapObject(o);
	}
	
}


