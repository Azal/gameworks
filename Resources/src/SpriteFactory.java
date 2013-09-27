package Resources.src;


public class SpriteFactory {

	public SpriteFactory() {
		
	}
	
	public ISprite createSprite(String path) {
		
		return new Sprite(path);
		
	}

}
