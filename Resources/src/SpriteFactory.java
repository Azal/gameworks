package Resources.src;


public class SpriteFactory {

	public SpriteFactory() {
		
	}
	
	public ISprite createImage(String path) {
		
		return new Sprite(path);
		
	}

}
