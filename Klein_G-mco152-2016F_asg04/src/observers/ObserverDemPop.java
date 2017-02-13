package observers;

import java.util.Observable;

import electStrategy.HonestElectVotes;
import observable.VoterObservable;
import popVoterStrategies.DemPopFavor;

public class ObserverDemPop extends VoterObserver
{
	public ObserverDemPop(Observable observable)
	{
		observable.addObserver(this);
		states = ((VoterObservable) observable).getState();
		popularVotes = new DemPopFavor(states);
		electoralCollege = new HonestElectVotes(states);
	}
}
