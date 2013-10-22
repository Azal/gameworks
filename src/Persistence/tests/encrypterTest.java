
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 */

/**
 * @author Katherine
 *
 */
public class encrypterTest {
	Encrypter control  = new Encrypter();
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		
		 control  = new Encrypter();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		
	}

	@Test
	public void writeTest() {
		assertTrue(control.write("test"));
		
	}
	
	@Test
	public void readTest()
	{
		assertTrue(control.read("test"));
	}
	
	@Test
	public void encodingTest()
	{
		fail("Not yet implemented!");
	}
	
	@Test
	public void decodingTest()
	{
		fail("Not yet implemented!");
	}

}
