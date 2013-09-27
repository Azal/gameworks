package scenery;

/**
-Here reside all objects and characters that compose the Map-
 	-Reference to external code-
*
*	@version  0.1
@created_by @group5/,,,ngbravo
@update_log
	26/09/2013 - @group5/ngbravo
	dd/mm/yyyy - @groupX/author[,author2,...]          
*/

/**  
main documentation comment */

public class Map {
	protected MapObject mapObjectGrid[][];
	protected Character characterGrid[][];
	protected String spritePath;
	
	public MapObjectType getObjectType(int positionX, int positionY){
		return null;
	}
	
	public Character getCharacter(int positionX, int positionY){
		return null;
	}
	
	public MapObject getMapObject(int positionX, int positionY){
		return null;
	}
	
	public void addCharacter(Character character){
		
	}
	
	public void addMapObject(MapObject mapObject){
		
	}
	
	public void setSpritePath(String path){
		
	}
	
	public String getSpritePath(){
		return null;
	}
}
