package iic2113.gameworks.persistence.tests;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.json.simple.JSONObject;

import src.iic2113.gameworks.persistence.Encrypter;

/**
 * 
 */

/**
 * @author Katherine
 *
 */
public class encrypterTest {
	JSONObject o = new JSONObject(); 
	//control  = new Encrypter();
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		
		 //control  = new Encrypter();
		JSONObject o = new JSONObject();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		
	}

	@Test
	public void writeTest() {
		
		assertTrue(true);
		
	}
	
	@Test
	public void readTest()
	{
		assertTrue(true);
	}
	
	@Test
	public void encodingTest()
	{
		assertTrue(true);
	}
	
	@Test
	public void decodingTest()
	{
		assertTrue(true);
	}

}
