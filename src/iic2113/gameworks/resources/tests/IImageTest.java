package src.iic2113.gameworks.resources.tests;

/**
 * @Version 0.1
 * @created_by @group2/Mauricio Vera
 *
 */

import static org.junit.Assert.*;

import java.awt.image.PixelGrabber;
import java.awt.image.BufferedImage;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import src.iic2113.gameworks.resources.IImage;
import src.iic2113.gameworks.resources.ImageFactory;
import src.iic2113.gameworks.resources.ResourceMaker;


public class IImageTest {
	
	private ResourceMaker rm = new ResourceMaker();
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testFilterGreyScale() {
		IImage iim = rm.createImage("assets/images/megaman.gif");
		iim.filterGreyScale(1);
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
	@Test
	public void testReloadImage() {
		ImageFactory imageFactory = new ImageFactory();
		assertNotNull(imageFactory);
		IImage iim = imageFactory.createImage("assets/images/megaman.gif");
		assertNotNull(iim);
		iim.filterGreyScale(1);
		assertTrue(iim.reloadImage());
	}
}
