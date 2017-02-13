package State;

public class USState 
{
	private long demVotes;
	private long GOPVotes;
	private int electoralVotes;
	private String state;
	
	public USState(String state, long demVotes, long GOPVotes, int electoralVotes)
	{
		this.demVotes = demVotes;
		this.GOPVotes = GOPVotes;
		this.electoralVotes = electoralVotes;
		this.state = state;
	}

	public USState(USState state)
	{
		this(state.state, state.demVotes, state.GOPVotes, state.electoralVotes);
	}
	
	public long getDemVotes() {
		return demVotes;
	}

	public long getGOPVotes() {
		return GOPVotes;
	}

	public int getElectoralVotes() {
		return electoralVotes;
	}

	public String getState() {
		return state;
	}

	public void setDemVotes(long demVotes) {
		this.demVotes = demVotes;
	}

	public void setGOPVotes(long gOPVotes) {
		GOPVotes = gOPVotes;
	}

	public void setElectoralVotes(int electoralVotes) {
		this.electoralVotes = electoralVotes;
	}
	
}
