package popVoterStrategies;

import State.USState;

public interface IPopVoteStrategy 
{
	public long[] getDemVote();
	public long[] getGOPVote();
	public void setVotes(USState[] state);
}
