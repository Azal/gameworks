package src.iic2113.gameworks.characterBehaviour.routes;

import java.util.List;

import src.iic2113.gameworks.characterBehaviour.search.AState;
import src.iic2113.gameworks.characterBehaviour.search.BoardGenerator;
import src.iic2113.gameworks.characterBehaviour.search.SearcherAgent;
import src.iic2113.gameworks.characterBehaviour.search.heuristics.ThirdHeuristic;
import src.iic2113.gameworks.characterBehaviour.search.tieBreakers.MayorHTieBreaker;

public class PatrolPath
{
	public static int[][] getPath(char[][] map)
	{
		SearcherAgent agent = new SearcherAgent(BoardGenerator.getInstance().generateFromCharArray(map));
		agent.setHeuristic(new ThirdHeuristic());
		agent.setTieBreaker(new MayorHTieBreaker());
		
		List<AState> result = agent.search();
		int roadSize = result.size() * 2 - 1;
		int[][] road = new int[roadSize][2];
		for(int i = 0; i < result.size(); i++)
		{
			road[i][0] = result.get(i).getX();
			road[i][1] = result.get(i).getY();
		}
		
		for(int i = result.size(), j = result.size() - 2; i < roadSize; i++, j--)
		{
			road[i][0] = result.get(j).getX();
			road[i][1] = result.get(j).getY();
		}
		
		return road;
	}
}
