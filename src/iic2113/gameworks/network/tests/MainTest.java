package iic2113.gameworks.network.tests;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import iic2113.gameworks.network.Connection;
import iic2113.gameworks.network.Network;

import org.junit.Test;

public class MainTest {

	@Test
	public void test() throws IOException {
		Connection server=new Connection();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Connection client=new Connection();
		client.newUser(Network.getFullIP());
		assertNotNull(server);
		assertNotNull(client);
		assertNotNull(br.readLine());
	}

}
