package observable;

import State.USState;
import observers.*;

public class CalculateElectionVotes 
{
	public static void main(String[] args)
	{
		USState[] states = new USState[5];
		states[0] = new USState("Ohio", 2801753, 2760302, 18);
		states[1] = new USState("New York", 4567813, 2809754, 28);
		states[2] = new USState("Florida", 4604975, 4607886, 29);
		states[3] = new USState("Texas", 3867816, 4681590, 38);
		states[4] = new USState("Oklahoma", 420375, 949136, 7);
		
		VoterObservable observable = new VoterObservable(states);
		
		VoterObserver observer1 = new ObserverDemPop(observable);
		VoterObserver observer2 = new ObserverDemPopGOPElect(observable);
		VoterObserver observer3 = new ObserverFavorsDem(observable);
		VoterObserver observer4 = new ObserverFavorsGOP(observable);
		VoterObserver observer5 = new ObserverHonest(observable);
		
		observable.setElectoralCollege(29, "New York");
	}
}
