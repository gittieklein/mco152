package popVoterStrategies;

import State.*;

public class GOPPopFavor implements IPopVoteStrategy
{
	private long[] GOPVotes;
	private long[] demVotes;
	private USState[] states;
	
	public GOPPopFavor(USState[] state)
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
		for(int i = 0; i < demVotes.length; i++)
		{
			demVotes[i] = (long) (demVotes[i] - demVotes[i] * .05);
		}
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
