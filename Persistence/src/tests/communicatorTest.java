package tests;

import static org.junit.Assert.*;
import module.ModuleCommunicator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**  
main documentation comment */

public class communicatorTest {
	ModuleCommunicator com;

	@Before
	public void setUp() throws Exception {
		com = new ModuleCommunicator();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void sendTest() {
		fail("Not yet implemented");
	}
	
	@Test
	public void askTest() {
		assertNotNull(com.ask("s", '1'));
	}
	
	
	@Test
	public void subscribeTest() {
		fail("Not yet implemented");
	}

}
