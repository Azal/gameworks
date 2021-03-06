/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package iic2113.gameworks.characterBehaviour.test.routes;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import iic2113.gameworks.characterBehaviour.routes.PatrolPath;

/**
 *
 * @author Giorgio
 */
public class PatrolPathTest {
    
    public PatrolPathTest() {
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
     * Test of getPath method, of class PatrolPath.
     */
    @Test
    public void testGetPath() {
        System.out.println("Test to get patrol path");
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
            {2,4},{1,4},{1,5},{1,6},{2,6},{3,6},{4,6},{4,7},{5,7},{6,7},{6,6},
            {6,7},{5,7},{4,7},{4,6},{3,6},{2,6},{1,6},{1,5},{1,4},{2,4},{3,4},
            {4,4},{5,4},{5,3},{5,2},{5,1},{5,0},{4,0}};
        int[][] result = PatrolPath.getPath(map);
        assertNotNull(result);
        assertArrayEquals(expResult, result);
    }
}