package Resources.src;


public class ImageFactory {

	public ImageFactory() {
		
	}
	
	public IImage createImage(String path) {
		if(GetExtension(path).equals("jpg")) {
			return new ImageX(path);
		}
		else if(GetExtension(path).equals("gif")) {
			return new ImageX(path);
		}
		else if(GetExtension(path).equals("png")) {
			return new ImageX(path);
		}
		else if(GetExtension(path).equals("bmp")) {
			return new ImageX(path);
		}
		else {
			return null;
		}
	}
	
	private String GetExtension(String s) {
		return "jpg";
	}
}
