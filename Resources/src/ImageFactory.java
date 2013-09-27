package Resources.src;

/**
 * @Version 0.1
 * @created_by @group2/Ignacio Carmach
 *
 */

public class ImageFactory extends Factory {

	public ImageFactory() {
		
	}
	
	public IImage createImage(String path) {
		if(getExtension(path).equals("jpg")) {
			return new ImageX(path);
		}
		else if(getExtension(path).equals("gif")) {
			return new ImageX(path);
		}
		else if(getExtension(path).equals("png")) {
			return new ImageX(path);
		}
		else if(getExtension(path).equals("bmp")) {
			return new ImageX(path);
		}
		else {
			return null;
		}
	}

}
