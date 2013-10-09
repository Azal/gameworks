package Persistence.tests;

import static org.junit.Assert.*;
import Persistence.src.FileManager;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
-Class description goes here.-
	-Reference to external code-
 *
 *	@version  0.1
    @author @group7/slakat
    @since 26/09/2013 - @group7/slakat
    @update_log
       
 */



public class fileTest {
	FileManager file;

	@Before
	public void setUp() throws Exception {
		file = new FileManager();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void isTest() {
		assertFalse(file.isFile("test"));
	}
	
	@Test
	public void findTest() {
		assertNotNull("test");
	}
	
	
	@Test
	public void newTest() {
		fail("Not yet implemented");
	}


	
	/**class bottom**/	

}
