/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package routes;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import CharacterBehaviour.routes.ShortPath;

/**
 *
 * @author Giorgio
 */
public class ShortPathsTest {
    
    public ShortPathsTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getPath method, of class ShortPaths.
     */
    @Test
    public void testGetPath() {
        System.out.println("Test to get shortest path");
        char[][] map = new char[8][];
		map[0] = new char[] {'o', 'o', 'o', 'o', 's', 'o', 'x', 'o'};
		map[1] = new char[] {'o', 'o', 'o', 'o', 'x', 'o', 'o', 'o'};
		map[2] = new char[] {'o', 'o', 'x', 'x', 'o', 'o', 'o', 'o'};
		map[3] = new char[] {'o', 'x', 'x', 'o', 'o', 'o', 'o', 'o'};
		map[4] = new char[] {'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o'};
		map[5] = new char[] {'o', 'o', 'x', 'x', 'x', 'x', 'x', 'x'};
		map[6] = new char[] {'o', 'o', 'o', 'o', 'o', 'x', 'g', 'o'};
		map[7] = new char[] {'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o'};
        int[][] expResult = {{4,0},{5,0},{5,1},{5,2},{5,3},{5,4},{4,4},{3,4},
            {2,4},{1,4},{1,5},{1,6},{2,6},{3,6},{4,6},{4,7},{5,7},{6,7},{6,6}};
        int[][] result = ShortPath.getPath(map);
        assertNotNull(result);
        assertArrayEquals(expResult, result);
    }
}