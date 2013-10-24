package iic2113.gameworks.characterBehaviour.routes;

import java.util.List;

import iic2113.gameworks.characterBehaviour.search.AState;
import iic2113.gameworks.characterBehaviour.search.BoardGenerator;
import iic2113.gameworks.characterBehaviour.search.SearcherAgent;
import iic2113.gameworks.characterBehaviour.search.heuristics.ThirdHeuristic;
import iic2113.gameworks.characterBehaviour.search.tieBreakers.MayorHTieBreaker;

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
