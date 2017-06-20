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
		if (currentPlayer.getMatch() == client.getPlayer().getMatch()){
		client.setCurrentPlayer(currentPlayer);
		System.out.println("It's the " + currentPlayer.getName() + "'s turn.");
	}
	}
	

}
