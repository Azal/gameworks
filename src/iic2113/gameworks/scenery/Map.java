package iic2113.gameworks.scenery;

import iic2113.gameworks.scenery.MapCharacter;

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


public class Map {
	
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
		return characters.add(c);
	}
	
	/**
	 * Method to add MapObject to the map
	 * @param o MapObject to add
	 * @return true if the MapObject was added to the List and false if it wasn't added.
	 */
	public boolean addMapObject( MapObject o){
		return objects.add(o);
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
	 * @return true if the MapObject was deleted and false if the grid position is empty
	 */
	public boolean deleteMapObject( int x, int y){
		MapObject o = checkPosition(x,y);
		if(o == null)
			return false;
		return deleteMapObject(o);
	}
	
	/**
	 * Gets the size of the Map
	 * @return A int array of length 2. In [0] you will find the length in the x-axis, 
	 * and in [1] the length in the y-axis
	 */
	public int[] getSize(){
		int[] size = new int[2];
		size [0] = grid.length;
		size [1] = grid[0].length;
		return size;
	}
	
	/**
	 * Places a MapCharacter of a given id, in the grid in (x,y)
	 * @param id The ID of the MapCharacter
	 * @param x The new x-axis coordinate
	 * @param y The new y-axis coordinate
	 * @return true if the placement was successful, false otherwise
	 */
	public boolean setPositionCharacter(int id, int x, int y){
		if (grid[x][y]==null){
			for(MapCharacter c : characters){
				if(c.getId() == id){
					if (c.getX()!=-1 && c.getY()!=-1)
						grid[c.getX()][c.getY()]=null;
					c.setPosition(x, y);
					grid[x][y]=c;
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * Places a MapObject of a given id, in the grid in (x,y)
	 * @param id The ID of the MapObject
	 * @param x The new x-axis coordinate
	 * @param y The new y-axis coordinate
	 * @return true if the placement was successful, false otherwise
	 */
	public boolean setPositionObject(int id, int x, int y){
		if (grid[x][y] == null){
			for(MapObject o : objects){
				if(o.getId() == id){
					if (o.getX() != -1 && o.getY() != -1)
						grid[o.getX()][o.getY()] = null;
					o.setPosition(x, y);
					grid[x][y] = o;
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * Gets a MapObject with it's id
	 * @param id The id of the MapObject
	 * @return The MapObject
	 */
	public MapObject getObjectById(int id){
		for(MapObject o : objects){
			if(o.getId() == id){
				return o;
			}
		}
		
		for(MapCharacter c : characters){
			if(c.getId() == id){
				return (MapObject)c;
			}
		}
		return null;
	}

	/**
	 * Sets the JLabel Sprite for the Map
	 * @param JLableSprite The JLable for the new Sprite
	 */
	public void setSprite(JLabel JLableSprite){
		mapSprite = JLableSprite;
	}

	/**
	 * Gets all objects and characters
	 * @return A list of all Object's and Character's Sprites
	 */
	public List<ISprite> getObjects(){
		List<ISprite> mapObjects = new ArrayList<ISprite>();
		for(MapObject o : objects){
			mapObjects.add((ISprite)o);
		}
		
		for(MapCharacter c : characters){
			mapObjects.add((ISprite)c);
		}
		return mapObjects;
	}
}


