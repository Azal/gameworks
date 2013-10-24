package src.iic2113.gameworks.characterBehaviour.search.tieBreakers;

import src.iic2113.gameworks.characterBehaviour.search.AState;

public class MinorHTieBreaker implements TieBreaker 
{
	@Override
	public AState breakTie(AState state1, AState state2)
	{
		if(state1.getH() < state2.getH())
			return state1;
		else
			return state2;
	}
	
	@Override
	public String toString()
	{
		return "TieBreaker by less h";
	}
}
