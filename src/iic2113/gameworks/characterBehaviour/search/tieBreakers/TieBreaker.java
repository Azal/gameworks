package src.iic2113.gameworks.characterBehaviour.search.tieBreakers;

import src.iic2113.gameworks.characterBehaviour.search.AState;

public interface TieBreaker
{
	AState breakTie(AState state1, AState state2);
}
