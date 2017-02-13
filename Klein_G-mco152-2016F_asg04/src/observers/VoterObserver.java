package observers;
import java.util.Observable;
import java.util.Observer;

import observable.*;
import State.USState;
import electStrategy.IElectStrategy;
import popVoterStrategies.IPopVoteStrategy;

import java.time.*;

public abstract class VoterObserver implements Observer
{
	protected IPopVoteStrategy popularVotes;
	protected IElectStrategy electoralCollege;
	protected USState[] states;
	
	//the update method receives an observable object, the other object will be null
	//then in the method it uses getters to get the data because it uses pull
	public void update(Observable observable, Object arg)
	{
		if(observable instanceof VoterObservable)
		{
			VoterObservable voterObservable = (VoterObservable) observable;
			this.states = voterObservable.getState();
			//i added in to set the popular and electoral votes because the observable doesn't
			//have that data - there is no need for it to because it's all based on how the observer
			//warps the data which will be different for each
			//here the strategies will get the raw data from the state object that was pulled from
			//the observable and warp the data based on their strategy
			this.popularVotes.setVotes(states);
			this.electoralCollege.setVotes(states);
			display();
			reportPopularVote();
			reportElectoralCollege();
		}
	}
	
	public void reportPopularVote() 
	{
		long demVotes = 0;
		long repVotes = 0;
		for(int i = 0; i < states.length; i++)
		{
			demVotes += popularVotes.getDemVote()[i];
			repVotes += popularVotes.getGOPVote()[i];
		}
		System.out.println("Popular Vote:"
				+ "\n\tDemocratic vote: " + demVotes
				+ "\n\tRepublican vote: " + repVotes);
	}

	public void reportElectoralCollege() 
	{
		int electoralDem = 0;
		int electoralRep = 0;
		for(int i = 0; i < states.length; i++)
		{
			electoralDem += electoralCollege.getNumDemElectVotes()[i];
			electoralRep += electoralCollege.getNumGOPElectVotes()[i];
		}	
		System.out.println("Electoral Vote:"
				+ "\n\tDemocratic vote: " + electoralDem
				+ "\n\tRepublican vote: " + electoralRep);
	}
	

	public void display()
	{
		System.out.println("\nThis report is purely observational and not legally binding"
				+ " in any way - " + LocalDate.now() + " " + LocalTime.now());
	}
}
