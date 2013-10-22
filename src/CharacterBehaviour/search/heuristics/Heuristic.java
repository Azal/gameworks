package src.CharacterBehaviour.search.heuristics;

public interface Heuristic
{
	double getHeuricticValue(int x, int y, int goalX, int goalY);
}
