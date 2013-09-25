package persistenceModule;

import static org.junit.Assert.*;

import org.junit.Test;


import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class mainTest {

	  @BeforeClass
	  public static void testSetup() {
	  }

	  @AfterClass
	  public static void testCleanup() {
	    // Teardown for data used by the unit tests
	  }

//	  @Test(expected = IllegalArgumentException.class)
//	  public void testExceptionIsThrown() {
//		  main.main("1 + 1");
//	  }

	  @Test
	  public void testMultiply() {
	    assertEquals("1 + 1 must be 2", 2, main.main("1 + 1"));
	  }
}
