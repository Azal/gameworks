package iic2113.gameworks.scenery.tests;

import static org.junit.Assert.*;
import iic2113.gameworks.scenery.MapObject;

import org.junit.Test;

/**
Test class for MapObject class
 	-Reference to external code-
 *
 *	@version  0.1
 *  @created_by @group5/gevalenz,javicabello,ngbravo,vibaseta
 *  @update_log
	25/10/2013 - @group5/ngbravo,gevalenz,javicabello,vibaseta      
 */

public class MapObjectTest {

	@Test
	public void testMapObject() {
		try {
			new MapObject(-1);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testAddParameterStringString() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddParameterStringInt() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddParameterStringBoolean() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddParameterStringDouble() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteParameter() {
		fail("Not yet implemented");
	}

}
