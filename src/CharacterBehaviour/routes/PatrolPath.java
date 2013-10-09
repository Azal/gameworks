package CharacterBehaviour.routes;

import java.util.List;

import CharacterBehaviour.search.AState;
import CharacterBehaviour.search.BoardGenerator;
import CharacterBehaviour.search.SearcherAgent;
import CharacterBehaviour.search.heuristics.ThirdHeuristic;
import CharacterBehaviour.search.tieBreakers.MayorHTieBreaker;

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
