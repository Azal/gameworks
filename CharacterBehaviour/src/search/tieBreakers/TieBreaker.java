package search.tieBreakers;

import search.AState;

public interface TieBreaker
{
	AState breakTie(AState state1, AState state2);
}
