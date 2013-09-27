package Resources.src;

/**
 * @Version 0.1
 * @created_by @group2/Ignacio Carmach
 *
 */

public class SpriteFactory {

	public SpriteFactory() {
		
	}
	
	public ISprite createSprite(String path) {
		
		return new Sprite(path);
		
	}

}
