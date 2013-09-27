package Resources.Tests;

import static org.junit.Assert.*;

import java.awt.image.PixelGrabber;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import Resources.src.IImage;
import Resources.src.ImageFactory;

public class IImageTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testFilterGreyScale() {
		ImageFactory imageFactory = new ImageFactory();
		IImage iim = imageFactory.createImage("assets/images/megaman.gif");
		iim.FilterGreyScale(1);
		try{
			PixelGrabber grab1 = new PixelGrabber(iim.getImageObject(), 0, 0, -1, -1, true);
			grab1.grabPixels();
			int[] data = (int[])grab1.getPixels();
			for(int i =0; i<data.length;i++){
				int red = (data[i]>>16)&0x0ff;
				int green=(data[i]>>8) &0x0ff;
				int blue= (data[i])    &0x0ff;
				if(red!=green||green!=blue){
					fail("testGreyScale");
					return;
				}
			}
		}
		catch(Exception e){fail("testGreyScale");}
		
		
		
	}

}
