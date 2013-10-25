package iic2113.gameworks.characterBehaviour.search;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.*;
import org.junit.Test;

public class BoardGeneratorTest
{
	
	@Test
	public void testGenerateFromCharArray()
	{
		char[][] map = new char[8][];
		map[0] = new char[] {'o', 'o', 'o', 'o', 's', 'o', 'x', 'o'};
		map[1] = new char[] {'o', 'o', 'o', 'o', 'x', 'o', 'o', 'o'};
		map[2] = new char[] {'o', 'o', 'x', 'x', 'o', 'o', 'o', 'o'};
		map[3] = new char[] {'o', 'x', 'x', 'o', 'o', 'o', 'o', 'o'};
		map[4] = new char[] {'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o'};
		map[5] = new char[] {'o', 'o', 'x', 'x', 'x', 'x', 'x', 'x'};
		map[6] = new char[] {'o', 'o', 'o', 'o', 'o', 'x', 'g', 'o'};
		map[7] = new char[] {'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o'};
		
		Board board = BoardGenerator.getInstance().generateFromCharArray(map);
		

		assertNotNull(board);

		// Check correct map size
		assertEquals(map.length, board.rowsCount());
		assertEquals(map[0].length, board.columnsCount());

		// Check correct Astate conversion
		assertTrue(!board.getState(0, 0).isClosed() &&
				!board.getState(0, 0).isStart() &&
				!board.getState(0, 0).isGoal() &&
				!board.getState(0, 0).isBlock());
		assertTrue(board.getState(2, 2).isBlock());
		assertTrue(board.getState(4, 0).isStart());
		assertTrue(board.getState(6, 6).isGoal());
		
	}
}
