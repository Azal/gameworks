package CharacterBehaviour.src.search.tieBreakers;

import CharacterBehaviour.src.search.AState;

public class MinorGTieBreaker implements TieBreaker
{
	@Override
	public AState breakTie(AState state1, AState state2)
	{
		if(state1.getG() < state2.getG())
			return state1;
		else
			return state2;
	}
	
	@Override
	public String toString()
	{
		return "TieBreaker by less G";
	}
}
