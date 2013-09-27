package search;

public enum Direction
{
	left 		(-1, 0),
	upLeft		(-1, 1),
	up 			(0, 1),
	upRight		(1, 1),
	right		(1, 0),
	downRight	(1, -1),
	down		(0, -1),
	downLeft	(-1, -1);
	
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
		else if(x == -1 && y == 1) return upLeft;
		else if(x == 0 && y == 1) return up;
		else if(x == 1 && y == 1) return upRight;
		else if(x == 1 && y == 0) return right;
		else if(x == 1 && y == -1) return downRight;
		else if(x == 0 && y == -1) return down;
		else return downLeft;
	}
	
	public Direction getInverse()
	{
		switch (this)
		{
		case left: return right;
		case upLeft: return downRight;
		case up: return down;
		case upRight: return downLeft;
		case right: return left;
		case downRight: return upLeft;
		case down: return up;
		default: return upRight;
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
