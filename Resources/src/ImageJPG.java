package Resources.src;

import java.awt.Image;


public class ImageJPG implements IImage{


    private String filename;

	public ImageJPG(String path) {
		filename = path;
	}
	
	public boolean Rotate() {
		//rotate
		return true;
	}

	@Override
	public Image getImageObject() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void FilterGreyScale(int option) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean reloadImage() {
		return false;
		
	}
}
