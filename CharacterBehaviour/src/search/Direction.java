package search;

public enum Direction
{
	left 		(-1, 0),
	up 			(0, 1),
	right		(1, 0),
	down		(0, -1);
	
	private int x;
	private int y;
	
	Direction(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	public static Direction getDirection(int x, int y)
	{
		if (x == -1 && y == 0) return left;
		else if(x == 0 && y == 1) return up;
		else if(x == 1 && y == 0) return right;
		else return down;
	}
	
	public Direction getInverse()
	{
		switch (this)
		{
		case left: return right;
		case up: return down;
		case right: return left;
		case down: return up;
		default: return up;
		}
	}
	
	int X()
	{
		return x;
	}
	
	int Y()
	{
		return y;
	}
}
