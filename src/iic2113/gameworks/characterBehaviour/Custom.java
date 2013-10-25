package iic2113.gameworks.characterBehaviour;
import java.util.LinkedList;

public class Custom extends Behaviour {

	public void setMap(char[][]map) {
		//throw new IllegalArgumentException("Custom Behaviour doesn't support a map. Try setSteps(LinkedList<Integer[]> steps) instead or setSteps(int[][])");
		this.map=map;
		this.lastStep=0;
		return;
	}
	//Set a path of Steps (as arrays [x,y])
	//We have to let the user do the things he wants. It's Custom
	public void setSteps(LinkedList<Integer[]> stepsList)
	{
		lastStep=0;
		steps=(int[][])stepsList.toArray();
	}
	public void setSteps(int[][] stepsList)
	{
		lastStep=0;
		steps=stepsList.clone();
	}

	public int[] move() {
		if(steps!=null&&lastStep<steps.length)
			return steps[lastStep++];
		else 
			return new int[]{-1,-1};
	}
	
}
	/*
	/*** THIS METHOD WAS DEPRECATED because was confusing to follow the real orientation of a path
	//This methods let you to set some custom points as steps from a map
	//0:start g:goal number#: #step of path to follow
	//returns -1 -1 if there wasn't a start
	public int[][] generateStepsFromCharArray(char[][] map)
	{	
		LinkedList<Integer[]> stepsList=new LinkedList<Integer[]>();
		int[] start=new int[2];
		boolean thereIsPath=false;
		//First we look for the start
		for(int rowNum = 0; rowNum < map.length; rowNum++)
		{
			for(int colNum = 0; colNum < map[rowNum].length; colNum++)
			{
				if(map[rowNum][colNum] == 's')
				 {
					start=new int[]{ rowNum, colNum};
					thereIsPath=true;
					Integer[] temp=new Integer[]{rowNum,colNum};
					stepsList.add(temp);
				 }
			}
		}
		
		//After that we start to trace the path
		int x=start[0];
		int y=start[1];
		int numberStep=0;
		while(thereIsPath){
			if(x-1>=0&&(map[(x-1)][y]=='c'||map[(x-1)][y]=='g'))
			{
				Integer[] temp=new Integer[]{x-1,y};
				stepsList.add(temp);
				if(map[(x-1)][y]=='g')
				{
					thereIsPath=false;
					break;
				}
			}
			else if(y-1>=0&&(map[(x)][y-1]=='c'||map[(x)][y-1]=='g'))
			{
				Integer[] temp=new Integer[]{x,y-1};
				stepsList.add(temp);
				if(map[x][y-1]=='g')
				{
					thereIsPath=false;
					break;
				}
			}
			else if(x+1<map.length&&(map[(x+1)][y]=='c'||map[(x+1)][y]=='g'))
			{
				Integer[] temp=new Integer[]{x+1,y};
				stepsList.add(temp);
				if(map[x+1][y]=='g')
				{
					thereIsPath=false;
					break;
				}
			}
			else if(y+1<map[x].length&&(map[(x)][y+1]=='c'||map[(x)][y+1]=='g'))
			{
				Integer[] temp=new Integer[]{x,y+1};
				stepsList.add(temp);
				if(map[x][y+1]=='g')
				{
					thereIsPath=false;
					break;
				}
			}
		}
		if(stepsList.size()==0)
			return new int[][]{{-1,-1}};
		return (int[][]) stepsList.toArray();
	*/
