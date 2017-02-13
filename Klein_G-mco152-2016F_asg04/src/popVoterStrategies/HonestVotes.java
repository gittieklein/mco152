package popVoterStrategies;

import State.USState;

public class HonestVotes implements IPopVoteStrategy
{
	private long[] GOPVotes;
	private long[] demVotes;
	private USState[] states;
	
	public HonestVotes(USState[] state)
	{
		this.states = new USState[state.length];
		for(int i = 0; i < states.length; i++)
		{
			states[i] = new USState(state[i]);
		}
		GOPVotes = new long[state.length];
		demVotes = new long[state.length];
		for(int i = 0; i < state.length; i++)
		{
			GOPVotes[i] = state[i].getGOPVotes();
			demVotes[i] = state[i].getDemVotes();
		}
	}

	public long[] getDemVote() 
	{
		return demVotes;
	}

	public long[] getGOPVote() 
	{
		return GOPVotes;
	}

	public void setVotes(USState[] state) 
	{
		for(int i = 0; i < state.length; i++)
		{
			GOPVotes[i] = state[i].getGOPVotes();
			demVotes[i] = state[i].getDemVotes();
		}
	}
	
	
}
