package CharacterBehaviour.src.search.tieBreakers;

import CharacterBehaviour.src.search.AState;

public interface TieBreaker
{
	AState breakTie(AState state1, AState state2);
}
