package CharacterBehaviour.src.search;

public class AState
{
	private int x;
	private int y;
	
	private boolean closed;
	private boolean block;
	private boolean goal;
	private boolean start;
	
	private double g;
	private double h;
	private int w;
	
	private AState father;
	
	/**
	 * 
	 * @param x Column number
	 * @param y Row number
	 */
	public AState(int x, int y)
	{
		this.x = x;
		this.y = y;
		this.closed = false;
		this.block = false;
		this.goal = false;
		
		this.g = 2000000;
		this.h = 2000000;
		this.w = 1;
	}
	
	/**
	 * 
	 * @param x Column number
	 * @param y Row number
	 * @param block if is a block
	 * @param goal if is the goal
	 */
	public AState(int x, int y, boolean block, boolean start, boolean goal)
	{
		this.x = x;
		this.y = y;
		this.closed = false;
		this.block = block;
		this.start = start;
		this.goal = goal;
		
		this.g = 2000000;
		if(this.start) this.g = 0;
		this.h = 2000000;
		this.w = 1;
	}
	
	public boolean equals(AState state)
	{
		if(this.getX() == state.getX() && this.getY() == state.getY())
			return true;
		
		return false;
	}

	public int getX()
	{
		return x;
	}

	public int getY()
	{
		return y;
	}

	public boolean isClosed()
	{
		return closed;
	}

	public boolean isBlock()
	{
		return block;
	}

	public boolean isGoal()
	{
		return goal;
	}
	
	public boolean isStart()
	{
		return this.start;
	}
	
	public double getF()
	{
		return g + w * h;
	}

	public double getG()
	{
		return g;
	}

	public double getH()
	{
		return h;
	}

	public int getW()
	{
		return w;
	}

	public AState getFather()
	{
		return father;
	}

	public void setClosed(boolean closed)
	{
		this.closed = closed;
	}

	public void setBlock(boolean block)
	{
		this.block = block;
	}

	public void setGoal(boolean goal)
	{
		this.goal = goal;
	}
	
	public void setStart(boolean start)
	{
		this.start = start;
		
		if(this.start)
			this.g = 0;
	}

	public void setG(double g)
	{
		this.g = g;
	}

	public void setH(double h)
	{
		this.h = h;
	}

	public void setW(int w)
	{
		this.w = w;
	}

	public void setFather(AState father)
	{
		this.father = father;
	}
}
