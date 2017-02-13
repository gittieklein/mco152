package observers;

import java.util.Observable;

import electStrategy.DemElectFavor;
import observable.VoterObservable;
import popVoterStrategies.DemPopFavor;

public class ObserverFavorsDem extends VoterObserver
{
	public ObserverFavorsDem(Observable observable)
	{
		observable.addObserver(this);
		states = ((VoterObservable) observable).getState();
		popularVotes = new DemPopFavor(states);
		electoralCollege = new DemElectFavor(states);
	}
}
