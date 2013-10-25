package iic2113.gameworks.characterBehaviour;

import java.util.LinkedList;

public abstract class Behaviour {
	
	protected int[][] steps;
	protected int lastStep;
	protected char[][] map;
	
	//Set a Map to use for calculate paths
	//For Custom Behaviour just saves the map
	public abstract void setMap(char[][] map);
	
	
	//Returns the next position as array [x,y] if returns -1,-1
	//so there weren't more steps to follow
	public abstract int[] move();
	

}
