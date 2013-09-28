package src.Scenery;

public abstract class MapObject {
	protected int height;
	protected int width;
	protected int positionX;
	protected int positionY;
	protected String spritePath;
	
	public void activate(){
		
	}
	
	public int getPositionX(){
		return 0;
	}
	
	public int getPositionY(){
		return 0;
	}
	
	public int getHeight(){
		return 0;
	}
	
	public int getWidth(){
		return 0;
	}
	
	public void destroy(){
		
	}
	
	public void setSpritePath(String path){
		
	}
	
	public String getSpritePath(){
		return null;
	}
}
