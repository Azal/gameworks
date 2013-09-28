package Resources.src;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class ImageFactoryTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testGreyScale() {
		ImageFactory imageFactory = new ImageFactory();
		IImage imagen = imageFactory.createImage("foto");
		fail("testGreyScale");
	}

}
