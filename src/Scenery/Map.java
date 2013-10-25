package src.Scenery;

/**
Here reside all objects and characters that compose the Map
 	-Reference to external code-
*
*	@version  0.1
@created_by @group5/,gevalenz,javicabello,ngbravo
@update_log
	26/09/2013 - @group5/ngbravo,gevalenz,javicabello       
*/

public class Map {
	
	
	/**
	 * mapObjectGrid: Grid that will contain all mapObjects in their current positions
	 */
	protected MapObject mapObjectGrid[][];
	/**
	 * characterGrid: Grid that will contain all characters in their current positions
	 */
	protected Character characterGrid[][];
	/**
	 * Path to the sprite for the map
	 */
	protected String spritePath;
	
	/**
	 * Constructor by default
	 */
	public Map(){
		int xDim = 20;
		int yDim = 20;
		mapObjectGrid = new MapObject[xDim][yDim];
		characterGrid = new Character[xDim][yDim];
		spritePath = null;
	}
	/**
	 * Constructor
	 * @param xDim dimension of the X coordinate of the map
	 * @param yDim dimension of the Y coordinate of the map
	 */
	public Map(int xDim, int yDim){
		mapObjectGrid = new MapObject[xDim][yDim];
		characterGrid = new Character[xDim][yDim];
		spritePath = null;
	}
		
	/**
	 * Returns the object type (MapObject, Character or Null) that is in the given coordinates
	 * @param positionX coordinate X in the grid
	 * @param positionY coordinate Y in the grid
	 * @return What is in the given coordinates
	 */
	public MapObjectType getObjectType(int positionX, int positionY){
		if(mapObjectGrid[positionX][positionY] != null)
			return MapObjectType.Object;

		if(characterGrid[positionX][positionY] != null)
			return MapObjectType.Character;

		return MapObjectType.Null;
	}
	
	/**
	 * Method to get a specific character knowing it's position
	 * @param positionX coordinate X in the grid
	 * @param positionY coordinate Y in the grid
	 * @return the character
	 */
	public Character getCharacter(int positionX, int positionY){
		Character aux = characterGrid[positionX][positionY];
		return aux;
	}
	
	/**
	 * Method to get a specific MapObject knowing it's position
	 * @param positionX coordinate X in the grid
	 * @param positionY coordinate Y in the grid
	 * @return the object
	 */
	public MapObject getMapObject(int positionX, int positionY){
		MapObject aux=mapObjectGrid[positionX][positionY];
		return aux;
	}
	
	/**
	 * Method to add a character to the grid
	 * @param character the already created character to be added
	 * @return true if the character was added and false if it wasn't added because there is another 
	 * object in the same position
	 */
	public boolean addCharacter(Character character){
		int positionX=character.getXPosition();
		int positionY=character.getYPosition();
		
		if (mapObjectGrid[positionX][positionY]==null && characterGrid[positionX][positionY]==null){
			characterGrid[positionX][positionY]=character;
			return true;
		}
		else
			return false;
		
	}
	
	/**
	 * Method to add a MapObject to the grid
	 * @param mapObject The MapObject to be added
	 * @return true if the mapObject was added and false if it wasn't added because there is another 
	 * object in the same position
	 */
	public boolean addMapObject(MapObject mapObject){
		int positionX=mapObject.getPositionX();
		int positionY=mapObject.getPositionY();
		
		if (mapObjectGrid[positionX][positionY]==null && characterGrid[positionX][positionY]==null){
			mapObjectGrid[positionX][positionY]=mapObject;
			return true;
		}		
		else
			return false;
	}
	
	/**
	 * Setter for spritePath
	 * @param path the new path
	 */
	public void setSpritePath(String path){
		spritePath=path;
	}
	
	/**
	 * Getter for spritePath
	 * @return the path for the sprite
	 */
	public String getSpritePath(){
		return spritePath;
	}
}
