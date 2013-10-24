package iic2113.gameworks.resources;

import java.awt.Image;

/**
 * @Version 0.1
 * @created_by @group2/Mauricio Vera
 *
 */

public class ImageJPG implements IImage{


    private String filename;

	public ImageJPG(String path) {
		filename = path;
	}
	
	public boolean rotate() {
		//rotate
		return true;
	}

	@Override
	public Image getImageObject() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void filterGreyScale(int option) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean reloadImage() {
		return false;
		
	}
}
