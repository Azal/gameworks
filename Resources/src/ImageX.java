package Resources.src;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;
import java.io.*;
import javax.imageio.*;

public class ImageX implements IImage{

	private BufferedImage img;
	 
    private String filename;

	public ImageX(String path) {
		filename = path;
		LoadImage();

	}
	public boolean LoadImage() {
	       try {
	           img = ImageIO.read(new File(filename));
	       } 
	       catch (IOException e) {
	    	   img = null;
	    	   return false;
	       }
	       return true;

	}
	public void FilterGreyScale(int option){
		if (img == null) return;
		if (option==1){
			ColorSpace cs = ColorSpace.getInstance(ColorSpace.CS_LINEAR_RGB);
			ColorConvertOp op = new ColorConvertOp(cs, null);
			img = op.filter(img, new BufferedImage(img.getWidth(), img.getHeight(),  
				    BufferedImage.TYPE_BYTE_GRAY));
		}
		else{
			ColorSpace cs = ColorSpace.getInstance(ColorSpace.CS_GRAY);
			ColorConvertOp op = new ColorConvertOp(cs, null);
			img = op.filter(img, new BufferedImage(img.getWidth(), img.getHeight(),  
				    BufferedImage.TYPE_BYTE_INDEXED));
		}
	}
	
	public boolean Rotate() {
		//rotate
		return true;
	}
	@Override
	public Image getImageObject() {
		// TODO Auto-generated method stub
		return img;
	}
	@Override
	public boolean reloadImage() {
		return LoadImage();
		
	}
}
