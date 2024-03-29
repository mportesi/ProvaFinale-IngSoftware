package it.polimi.ingsw.changes;

import it.polimi.ingsw.GC_40.Player;
import it.polimi.ingsw.client.ClientModel;
/**
 * @author Sara
 * To set the current player on the client and to switch the turn.
 */
public class ChangePlayer implements Change {
	private Player currentPlayer;
	
	public ChangePlayer(Player currentPlayer){
		this.currentPlayer=currentPlayer;
	}

	@Override
	public void applyChange(ClientModel client) {
		if (currentPlayer.getMatch() == client.getPlayer().getMatch()){
		client.getTimer().cancel();
		client.setCurrentPlayer(currentPlayer);
		System.out.println(client.getPlayer());
		System.out.println("It's the " + currentPlayer.getName() + "'s turn.");
	}
	}
	

}
