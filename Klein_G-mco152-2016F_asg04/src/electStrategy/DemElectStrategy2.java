package electStrategy;

import State.*;

public class DemElectStrategy2 implements IElectStrategy {
	private USState[] states;
	private int[] electVotesDem;
	private int[] electVotesGOP;
	private int[] totalElectVotes;

	public DemElectStrategy2(USState[] state) {
		this.states = new USState[state.length];
		for (int i = 0; i < state.length; i++) {
			this.states[i] = new USState(state[i]);
		}
		totalElectVotes = new int[state.length];
		for (int i = 0; i < state.length; i++) {
			totalElectVotes[i] = state[i].getElectoralVotes();
		}
		electVotesDem = new int[state.length];
		electVotesGOP = new int[state.length];
		calculateVote();
	}

	private void calculateVote() {
		// the electoral vote will be calculated as if the dem has 2% of rep votes
		//and rep has 2% less
		//and after that it's based on popular vote with all or none
		for (int i = 0; i < states.length; i++) {
			long gop2 = (long) (states[i].getGOPVotes() * .02);	//2% of gop vote
			if (states[i].getDemVotes() + gop2 > states[i].getGOPVotes() - gop2) {
				electVotesDem[i] = totalElectVotes[i];
				electVotesGOP[i] = 0;
			} else {
				electVotesDem[i] = 0;
				electVotesGOP[i] = totalElectVotes[i];
			}
		}
	}

	// when the getters are called, the data is already updated from the last
	// pull
	public int[] getNumDemElectVotes() {
		return electVotesDem;
	}

	public int[] getNumGOPElectVotes() {
		return electVotesGOP;
	}

	public void setVotes(USState[] state) {
		this.states = new USState[state.length];
		for (int i = 0; i < state.length; i++) {
			this.states[i] = new USState(state[i]);
		}
		calculateVote();
	}

}
