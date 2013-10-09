package CharacterBehaviour.search.tieBreakers;

import CharacterBehaviour.search.AState;

public class MayorGTieBreaker implements TieBreaker
{
	@Override
	public AState breakTie(AState state1, AState state2)
	{
		if(state1.getG() > state2.getG())
			return state1;
		else
			return state2;
	}
	
	@Override
	public String toString()
	{
		return "TieBreaker by greater G";
	}
}
