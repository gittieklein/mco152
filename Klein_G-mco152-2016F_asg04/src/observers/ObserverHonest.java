package observers;

import java.util.Observable;

import electStrategy.HonestElectVotes;
import observable.VoterObservable;
import popVoterStrategies.HonestVotes;

public class ObserverHonest  extends VoterObserver
{
	public ObserverHonest(Observable observable)
	{
		observable.addObserver(this);
		states = ((VoterObservable) observable).getState();
		popularVotes = new HonestVotes(states);
		electoralCollege = new HonestElectVotes(states);
	}
}
