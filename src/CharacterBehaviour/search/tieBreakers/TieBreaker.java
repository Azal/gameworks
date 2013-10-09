package CharacterBehaviour.search.tieBreakers;

import CharacterBehaviour.search.AState;

public interface TieBreaker
{
	AState breakTie(AState state1, AState state2);
}
