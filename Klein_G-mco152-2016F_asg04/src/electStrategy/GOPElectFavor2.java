package electStrategy;

import State.USState;

public class GOPElectFavor2 implements IElectStrategy {
	private USState[] states;
	private int[] electVotesDem;
	private int[] electVotesGOP;
	private int[] totalElectVotes;

	public GOPElectFavor2(USState[] state) {
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
		long min = states[0].getDemVotes() - states[0].getGOPVotes();
		int index = 0;
		for (int i = 1; i < states.length; i++) {
			if (states[i].getDemVotes() - states[i].getGOPVotes() < min) {
				min = states[i].getDemVotes() - states[i].getGOPVotes();
				index = i;
			}
		}
		electVotesDem[index] = totalElectVotes[index] / 2;
		electVotesGOP[index] = totalElectVotes[index] - electVotesDem[index];
		// after you check for the state that will split, you need to set the
		// rest of the states
		// the rest will be based on the pop vote on an all or none basis
		for (int i = 0; i < states.length; i++) {
			if (index != i) {
				if (states[i].getDemVotes() > states[i].getGOPVotes()) {
					electVotesDem[i] = totalElectVotes[i];
					electVotesGOP[i] = 0;
				} else {
					electVotesDem[i] = 0;
					electVotesGOP[i] = totalElectVotes[i];
				}
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
