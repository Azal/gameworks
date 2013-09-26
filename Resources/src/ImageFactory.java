
public class ImageFactory {

	public ImageFactory() {
		
	}
	
	public IImage createImage(String path) {
		if(GetExtension(path).equals("jpg")) {
			return new ImageJPG(path);
		}
		
		else {
			return null;
		}
	}
	
	private String GetExtension(String s) {
		return "jpg";
	}
}
