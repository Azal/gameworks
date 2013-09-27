package CharacterBehaviour.src.search;

import java.util.ArrayList;
import java.util.List;

public class Board
{
	/**
	 * Remember the first param represent the rows (Y) and the second represent the colums (X)
	 */
	private AState [][] map;
	private AState startState;
	private AState goalState;
	
	public Board (int size)
	{
		this.map = new AState[size][size];
		for(int i = 0; i < size; i++)
		{
			for(int j = 0; j < size; j++)
				this.map[i][j] = new AState(i,j);
		}
	}
	
	public Board (AState [][] map)
	{
		this.map = map;
	}
	
	public int rowsCount()
	{
		return this.map.length;
	}
	
	public int columnsCount()
	{
		if(this.map[0] != null)
			return this.map[0].length;
		else
			return 0;
	}
	
	/**
	 * Only use when the states are neightbor
	 * @param state1
	 * @param state2
	 * @return
	 */
	public double getCost(AState state1, AState state2)
	{
		int x = Math.abs(state2.getX() - state1.getX());
		int y = Math.abs(state2.getY() - state1.getY());
		
		if(x > 1 || y > 1) return -1;
		else if(x == 1 && y == 1) return Math.sqrt(2);
		else if(x == 1 || y == 1) return 1;
		else return 0;
	}
	
	/**
	 * Get the AState in the position
	 * @param x Column number
	 * @param y Row number
	 * @return
	 */
	public AState getState(int x, int y)
	{
		return this.map[y][x];
	}
	
	public AState getStartState()
	{
		if(this.startState == null)
		{
			for(int i = 0; i < this.map.length; i++)
			{
				for(int j = 0; j < this.map[0].length; j++)
				{
					if(this.map[i][j].isStart())
					{
						this.startState = this.map[i][j];
						return this.startState;
					}
				}
			}
		}
		
		return this.startState;
	}
	
	public AState getGoalState()
	{
		if(this.goalState == null)
		{
			for(int i = 0; i < this.map.length; i++)
			{
				for(int j = 0; j < this.map[0].length; j++)
				{
					if(this.map[i][j].isGoal())
					{
						this.goalState = this.map[i][j];
						return this.goalState;
					}
				}
			}
		}
		
		return this.goalState;
	}
	
	public AState getNeighbor(AState state, Direction dir)
	{
		int x = state.getX() + dir.X();
		int y = state.getY() + dir.Y();
		
		if(x < 0 || x >= this.columnsCount() || y < 0 || y >= this.rowsCount())
			return null;
		
		return this.map[y][x];
	}
	
	public List < AState > getAllNeighbors(AState state)
	{
		List < AState > neighbors = new ArrayList < AState >();
		for(Direction dir : Direction.values())
		{
			AState neighbor = this.getNeighbor(state, dir);
			if(neighbor != null && !neighbor.isBlock())
				neighbors.add(neighbor);
		}
		return neighbors;
	}
}
