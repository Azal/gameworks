package iic2113.gameworks.resources;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class ImageXTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testLoadImageGif() {
		ImageX imagen = new ImageX("/images/megaman.gif");
		assertNotNull(imagen);
		assertNotNull(imagen.getImageObject());
	}

}
