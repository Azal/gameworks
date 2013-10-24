package src.iic2113.gameworks.characterBehaviour.search.heuristics;

public interface Heuristic
{
	double getHeuricticValue(int x, int y, int goalX, int goalY);
}
