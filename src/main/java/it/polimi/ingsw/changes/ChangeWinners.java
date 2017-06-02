package it.polimi.ingsw.changes;

import java.util.ArrayList;

import it.polimi.ingsw.GC_40.Player;

public class ChangeWinners implements Change {
	private ArrayList<Player> winners;
	
	public ChangeWinners(ArrayList<Player> winners){
		this.winners=winners;
	}

	@Override
	public void applyChange() {
		// TODO Auto-generated method stub

	}

}
