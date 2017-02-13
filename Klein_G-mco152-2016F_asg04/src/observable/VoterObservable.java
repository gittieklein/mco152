package observable;
import java.util.Observable;

import State.USState;
import electStrategy.IElectStrategy;
import popVoterStrategies.IPopVoteStrategy;

public class VoterObservable extends Observable
{
	private USState[] states;
	
	public VoterObservable(USState[] states) 
	{
		this.states = states;
	}
	
	public void votesChanged()
	{
		setChanged();
		notifyObservers();
	}
	
	//the observable needs a getter to get the state because it uses pull so the observers need to be
	//able to use a getter
	public USState[] getState()
	{
		USState[] USS = new USState[states.length];
		for(int i = 0; i < states.length; i++)
		{
			USS[i] = new USState(states[i]);
		}
		return USS;
	}
	
	public int lookUpState(String state)
	{
		for(int i = 0; i < states.length; i++)
		{
			if(states[i].getState().equalsIgnoreCase(state));
				return i;
		}
		return -1;
	}
	
	//you only have to change the value in the state object because the strategies
	//get the data from the state object
	//if the value received from the look up method is -1 then do nothing
	//because the state is not in the array
	public void setPopularVote(long popDem, long popGOP, String state)
	{
		int i = lookUpState(state);
		if(i >= 0)
		{
			states[i].setDemVotes(popDem);
			states[i].setGOPVotes(popGOP);
		}
		votesChanged();
	}
	
	public void setElectoralCollege(int ec, String state)
	{
		int i = lookUpState(state);
		if(i >= 0)
		{
			states[i].setElectoralVotes(ec);
		}
		votesChanged();
	}
}
