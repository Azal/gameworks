package iic2113.gameworks.network.tests;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import iic2113.gameworks.network.Connection;

public class ConnectionTest {
	
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	
	@Before
	public void setUpStreams() {
	    System.setOut(new PrintStream(outContent));
	    System.setErr(new PrintStream(errContent));
	}

	@After
	public void cleanUpStreams() {
	    System.setOut(null);
	    System.setErr(null);
	}


	@Test
	public void test() {
		//assertEquals("-","Connection not yet implemented");
		Connection c = new Connection();
		assertNotNull(c);
		assertNotNull(c.getNetwork());
		//assertEquals(true, c.newUser("192.168.1.1:6740"));
		
		
	}

}
