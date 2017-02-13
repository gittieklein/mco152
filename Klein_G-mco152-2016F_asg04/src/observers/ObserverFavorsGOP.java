package observers;

import java.util.Observable;
import observable.*;

import electStrategy.GOPElectFavor;
import popVoterStrategies.*;

public class ObserverFavorsGOP extends VoterObserver
{
	public ObserverFavorsGOP(Observable observable)
	{
		observable.addObserver(this);
		states = ((VoterObservable) observable).getState();
		popularVotes = new GOPPopFavor(states);
		//there are 2 strategies that are in favor for rep so i chose 1
		electoralCollege = new GOPElectFavor(states);
	}
}
