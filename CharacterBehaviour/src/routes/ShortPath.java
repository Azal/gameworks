package routes;

import java.util.List;

import search.AState;
import search.BoardGenerator;
import search.SearcherAgent;
import search.heuristics.ThirdHeuristic;
import search.tieBreakers.MayorHTieBreaker;

public class ShortPath
{
	public static int[][] getPath(char[][] map)
	{
		SearcherAgent agent = new SearcherAgent(BoardGenerator.getInstance().generateFromCharArray(map));
		agent.setHeuristic(new ThirdHeuristic());
		agent.setTieBreaker(new MayorHTieBreaker());
		
		List<AState> result = agent.search();
		int[][] road = new int[result.size()][2];
		for(int i = 0; i < result.size(); i++)
		{
			road[i][0] = result.get(i).getX();
			road[i][1] = result.get(i).getY();
		}
		
		return road;
	}
}
