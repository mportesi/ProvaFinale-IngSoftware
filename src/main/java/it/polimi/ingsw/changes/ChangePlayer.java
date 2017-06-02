package it.polimi.ingsw.changes;

import it.polimi.ingsw.GC_40.Player;

public class ChangePlayer implements Change {
	private Player currentPlayer;
	
	public ChangePlayer(Player currentPlayer){
		this.currentPlayer=currentPlayer;
	}

	@Override
	public void applyChange() {
		// TODO Auto-generated method stub

	}

}
