package it.polimi.ingsw.changes;

import it.polimi.ingsw.GC_40.Player;
import it.polimi.ingsw.client.ClientModel;

public class ChangePlayer implements Change {
	private Player currentPlayer;
	
	public ChangePlayer(Player currentPlayer){
		this.currentPlayer=currentPlayer;
	}

	@Override
	public void applyChange(ClientModel client) {
		client.setCurrentPlayer(currentPlayer);
		client.setStartPlay(true);
		System.out.println("StartPLay" + client.getStartPlay());
		System.out.println("It's the " + currentPlayer.getName() + "'s turn.");
	}

}
