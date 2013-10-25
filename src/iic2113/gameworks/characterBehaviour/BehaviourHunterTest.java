package iic2113.gameworks.characterBehaviour;

import static org.junit.Assert.*;
import iic2113.gameworks.characterBehaviour.routes.ShortPath;

import org.junit.Test;

public class BehaviourHunterTest {

	@Test
	public void testHunter() {
		Behaviour behaviour=new Hunter();
		
		char[][] map = new char[8][];
		map[0] = new char[] {'o', 'o', 'o', 'o', 's', 'o', 'x', 'o'};
		map[1] = new char[] {'o', 'o', 'o', 'o', 'x', 'o', 'o', 'o'};
		map[2] = new char[] {'o', 'o', 'x', 'x', 'o', 'o', 'o', 'o'};
		map[3] = new char[] {'o', 'x', 'x', 'o', 'o', 'o', 'o', 'o'};
		map[4] = new char[] {'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o'};
		map[5] = new char[] {'o', 'o', 'x', 'x', 'x', 'x', 'x', 'x'};
		map[6] = new char[] {'o', 'o', 'o', 'o', 'o', 'x', 'g', 'o'};
		map[7] = new char[] {'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o'};
		
		behaviour.setMap(map);
		
		int steps=19;
		int[][] givenSteps=new int[steps][];
		//Load the steps saved
		for(int i=0;i<steps;i++){
			int[] temp=behaviour.move();
			givenSteps[i]=new int[]{temp[0],temp[1]};
		}
		
		int[][] expectedSteps={{4,0},{5,0},{5,1},{5,2},{5,3},{5,4},{4,4},{3,4},
	            {2,4},{1,4},{1,5},{1,6},{2,6},{3,6},{4,6},{4,7},{5,7},{6,7},{6,6}};
		assertNotSame(0, givenSteps.length);
        assertArrayEquals(expectedSteps, givenSteps);

	}

}
