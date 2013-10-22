package src.iic2113.gameworks.network;

import static org.junit.Assert.*;

import org.junit.Test;

public class NetworkMessageTest {

	@Test
	public void test() {
		NetworkMessage nm = new NetworkMessage(0,"conversation", "content");
		assertNotNull(nm);
		assertEquals(nm.parse(nm.getString()).getString(),nm.getString() );
	}

}
