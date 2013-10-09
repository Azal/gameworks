package src.CharacterBehaviour.search.tieBreakers;

import src.CharacterBehaviour.search.AState;

public interface TieBreaker
{
	AState breakTie(AState state1, AState state2);
}
