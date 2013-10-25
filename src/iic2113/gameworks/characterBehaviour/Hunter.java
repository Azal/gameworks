package iic2113.gameworks.characterBehaviour;

import iic2113.gameworks.characterBehaviour.routes.ShortPath;

import java.util.LinkedList;

public class Hunter extends Behaviour {

	public void setMap(char[][]map) {
		this.lastStep=0;
		this.map=map;
		steps=ShortPath.getPath(this.map);
		return;
	}

	public int[] move() {
		if(steps!=null&&lastStep<steps.length)
			return steps[lastStep++];
		else
			return new int[]{-1,-1};
	}
	
}
