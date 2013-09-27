package Resources.src;


public class ImageJPG implements IImage{


    private String filename;

	public ImageJPG(String path) {
		filename = path;
	}
	
	public boolean Rotate() {
		//rotate
		return true;
	}
}
