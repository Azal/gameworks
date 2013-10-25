package iic2113.gameworks.characterBehaviour;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Test;

public class BehaviourCustomTest {

	@Test
	public void testCustom() {
		Custom customBehaviour=new Custom();
		int [][] path=new int[][]{{0,0},{0,1},{1,1},{2,1}};
		customBehaviour.setSteps(path);
		
		Behaviour behaviour=(Behaviour)customBehaviour;
		int[][] givenSteps=new int[path.length+1][];
		//Load the steps saved
		for(int i=0;i<path.length+1;i++){
			int[] temp=behaviour.move();
			givenSteps[i]=new int[]{temp[0],temp[1]};
		}
		
		int[][] expectedSteps=new int[][]{{0,0},{0,1},{1,1},{2,1},{-1,-1}};
		assertNotSame(0, givenSteps.length);
        assertArrayEquals(expectedSteps, givenSteps);
	}

}
