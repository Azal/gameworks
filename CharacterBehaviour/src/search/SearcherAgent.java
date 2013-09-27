package search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import search.heuristics.Heuristic;
import search.tieBreakers.TieBreaker;

public class SearcherAgent
{
	private Board map;
	private boolean calculated;
	private boolean resolved;
	private List < AState > road;
	
	private TieBreaker tieBreaker;
	private Heuristic heuristic;
	
	private int stateOpened;
	
	public SearcherAgent()
	{
		this.calculated = false;
		this.resolved = false;
		this.stateOpened = 0;
	}
	
	public SearcherAgent(Board map)
	{
		this.calculated = false;
		this.resolved = false;
		this.map = map;
		this.road = new ArrayList < AState >();
		this.stateOpened = 0;
	}
	
	public Board getMap()
	{
		return this.map;
	}
	
	public List < AState > getRoad()
	{
		return this.road;
	}
	
	public boolean isCalculated()
	{
		return this.calculated;
	}
	
	public List < AState > search()
	{
		if(!this.calculated)
		{
			this.stateOpened = 0;
			
			List < AState > opened = new LinkedList < AState >();
			AState current = this.map.getStartState();
			
			long start = System.currentTimeMillis();
			
			while(!current.isGoal())
			{
				current.setClosed(true);
				List < AState > neighbors = this.map.getAllNeighbors(current);
				for(AState state : neighbors)
				{
					double cost = this.map.getCost(current, state);
					if(state.getG() <= current.getG() + cost)
						continue;
					
					state.setG(current.getG() + cost);
					state.setFather(current);
					state.setClosed(false);
					
					this.insertInOpened(opened, state);
				}
				
				if(opened.isEmpty()) break;
				
				current = opened.get(0);
				opened.remove(current);
				this.stateOpened++;
				
				if(System.currentTimeMillis() - start > 10000)
					break;
			}
			
			if(current.isGoal())
			{
				this.resolved = true;
				
				this.road.add(current);
				while(!current.equals(this.map.getStartState()))
				{
					current = current.getFather();
					this.road.add(0, current);
				}
			}
			
			this.calculated = true;
		}
		
		return this.road;
	}
	
	public int getStateOpened()
	{
		return stateOpened;
	}

	public void setMap(Board map)
	{
		this.map = map;
		this.calculated = false;
		this.resolved = false;
		this.road = new ArrayList < AState >();
		this.stateOpened = 0;
		
		this.setHeuristicValue();
	}
	
	private void insertInOpened(List < AState > opened, AState state)
	{
		if(!opened.isEmpty())
		{
			for(int i = 0; i < opened.size(); i++)
			{
				if(opened.get(i).getF() > state.getF())
				{
					opened.add(i, state);
					return;
				}
				else if (opened.get(i).getF() == state.getF())
				{
					if(state == this.tieBreaker.breakTie(opened.get(i), state))
					{
						opened.add(i, state);
						return;
					}
				}
			}
		}
		
		opened.add(state);
	}
	
	public boolean isResolved()
	{
		return this.resolved;
	}
	
	public TieBreaker getTieBreaker()
	{
		return this.tieBreaker;
	}
	
	public void setTieBreaker(TieBreaker tieBreaker)
	{
		this.tieBreaker = tieBreaker;
	}
	
	public Heuristic getHeuristic()
	{
		return this.heuristic;
	}
	
	public void setHeuristic(Heuristic heuristic)
	{
		this.heuristic = heuristic;
		
		this.setHeuristicValue();
	}
	
	private void setHeuristicValue()
	{
		if(this.map == null || this.heuristic == null)
			return;
		
		for(int i = 0; i < this.map.columnsCount(); i++)
		{
			for(int j = 0; j < this.map.rowsCount(); j++)
			{
				this.map.getState(i, j).setH(this.heuristic.getHeuricticValue(i, j,
						this.map.getGoalState().getX(), this.map.getGoalState().getY()));
			}
		}
	}
}
