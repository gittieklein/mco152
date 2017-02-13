package popVoterStrategies;

import State.USState;

public class DemPopFavor implements IPopVoteStrategy
{
	private long[] GOPVotes;
	private long[] demVotes;
	private USState[] states;
	
	public DemPopFavor(USState[] state)
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
		//i assumed to ignore the state with the most republican votes meant to assume that it has 0 votes
		//for republican
		long max = states[0].getGOPVotes();
		int index = 0;
		for(int i = 1; i < states.length; i++)
		{
			if(states[i].getGOPVotes() > max)
			{
				max = states[i].getGOPVotes();
				index = i;
			}
		}
		GOPVotes[index] = 0;
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
