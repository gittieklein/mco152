package observers;

import java.util.Observable;

import electStrategy.*;
import observable.VoterObservable;
import popVoterStrategies.DemPopFavor;

public class ObserverDemPopGOPElect extends VoterObserver
{
	public ObserverDemPopGOPElect(Observable observable)
	{
		observable.addObserver(this);
		states = ((VoterObservable) observable).getState();
		popularVotes = new DemPopFavor(states);
		electoralCollege = new GOPElectFavor2(states);
	}
}
