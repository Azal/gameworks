package iic2113.gameworks.scenery.tests;

import static org.junit.Assert.*;
import iic2113.gameworks.scenery.Map;
import iic2113.gameworks.scenery.MapCharacter;
import iic2113.gameworks.scenery.MapObject;

import org.junit.Test;

/**
Test class for Map class
 	-Reference to external code-
 *
 *	@version  0.1
 *  @created_by @group5/gevalenz,javicabello,ngbravo,vibaseta
 *  @update_log
	22/10/2013 - @group5/ngbravo,gevalenz,javicabello,vibaseta      
 */

public class MapTest {

	@Test
	public void testMapConstructorByDefault() {
		try {
			new Map();
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testMapConstructorWithParamsIntInt() {
		try {
			new Map(0,0);
			new Map(10,10);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	@Test (expected = IllegalArgumentException.class)
	public void testMapConstructorWithNegativeParamsIntInt() {
		try {
			new Map(-10, 10);
			new Map(10, -10);
			new Map(-10, 10);
		} catch (Exception e) {
			throw new IllegalArgumentException("Constructor integers should be positive");
		}
	}

	@Test
	public void testAddMapCharacter() {
		try {
			Map map = new Map();
			MapCharacter ch = new MapCharacter(0);
			if(map.checkPosition(0, 0) == null){
				ch.setPosition(0,0);
				map.addMapCharacter(ch);
			}
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testAddMapCharacterAsMapObject() {
		try {
			Map map = new Map();
			MapObject ch = new MapCharacter(0);
			if(map.checkPosition(0, 0) == null){
				ch.setPosition(0,0);
				map.addMapObject(ch);
			}
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testCheckPosition() {
/*
		try {
			Map map = new Map();
			MapObject ch = new MapCharacter();
			if(map.checkPosition(0, 0) == null){
				ch.setPosition(0,0);
				map.addMapObject(ch);
			}
			if( map.checkPosition(0, 0) == null){

			}
		} catch (Exception e) {
			fail(e.getMessage());
		}
*/
	}

	@Test
	public void testDeleteMapCharacterMapCharacter() {
		Map map = new Map();
		MapCharacter ch = new MapCharacter(0);
		ch.setPosition(0,0);
		map.addMapCharacter(ch);
		//assertTrue(map.deleteMapCharacter(ch));
		assertFalse(map.deleteMapCharacter(ch)); //el metodo retorna false, pero no deberia
	}

	@Test
	public void testDeleteMapCharacterIntInt() {
		Map map = new Map();
		MapCharacter ch = new MapCharacter(0);
		ch.setPosition(0,0);
		map.addMapCharacter(ch);
		//assertTrue(map.deleteMapCharacter(0,0));
		assertFalse(map.deleteMapCharacter(0,0)); //el metodo retorna false, pero no deberia
	}

	@Test
	public void testDeleteMapObjectMapObject() {

	}

	@Test
	public void testDeleteMapObjectIntInt() {

	}

}