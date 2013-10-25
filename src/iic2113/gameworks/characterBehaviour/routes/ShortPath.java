package src.iic2113.gameworks.characterBehaviour.routes;

import java.util.List;

import src.iic2113.gameworks.characterBehaviour.search.AState;
import src.iic2113.gameworks.characterBehaviour.search.BoardGenerator;
import src.iic2113.gameworks.characterBehaviour.search.SearcherAgent;
import src.iic2113.gameworks.characterBehaviour.search.heuristics.ThirdHeuristic;
import src.iic2113.gameworks.characterBehaviour.search.tieBreakers.MayorHTieBreaker;

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
