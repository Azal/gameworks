package CharacterBehaviour.search.heuristics;

public class ThirdHeuristic implements Heuristic
{
	@Override
	public double getHeuricticValue(int x, int y, int goalX, int goalY)
	{
		int minor = Math.min(Math.abs(goalX - x), Math.abs(goalY - y));
		int mayor = Math.max(Math.abs(goalX - x), Math.abs(goalY - y));
		return Math.sqrt(2) * minor + mayor;
	}
	
	@Override
	public String toString()
	{
		return "Third Heuristic";
	}
}
