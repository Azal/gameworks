package search.heuristics;

public class ZeroHeuristic implements Heuristic
{
	@Override
	public double getHeuricticValue(int x, int y, int goalX, int goalY)
	{
		return 0;
	}
	
	@Override
	public String toString()
	{
		return "Zero Heuristic";
	}
}
