package search.heuristics;

public class PitagorasHeuristic implements Heuristic
{
	@Override
	public double getHeuricticValue(int x, int y, int goalX, int goalY)
	{
		int value = (goalX - x) * (goalX - x) + (goalY - y) * (goalY - y);
		return Math.sqrt(value);
	}
	
	@Override
	public String toString()
	{
		return "Pitagoras Heuristic";
	}
}
