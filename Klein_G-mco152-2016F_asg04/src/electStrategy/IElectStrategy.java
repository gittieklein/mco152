package electStrategy;

import State.USState;

//there is no setter for the electoral votes because the number of electoral
//votes a state gets will not change
//what could change is the number that each party gets
public interface IElectStrategy 
{
	public int[] getNumDemElectVotes();
	public int[] getNumGOPElectVotes();
	public void setVotes(USState[] states);
}
