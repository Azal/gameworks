package src.iic2113.gameworks.network.tests;


import static org.junit.Assert.*;

import java.net.Inet4Address;

import org.junit.Test;

import src.iic2113.gameworks.network.Network;

public class NetworkTest {

	@Test
	public void test() throws Exception {
		Network net = new Network();
		assertNotNull(net);
		assertFalse(net.checkPort(1));
		assertTrue(net.checkPort(8080));
		//assertEquals((Inet4Address)Inet4Address.getLocalHost(), Network.getLocalAddress());
		
		
		
	}
	


}
