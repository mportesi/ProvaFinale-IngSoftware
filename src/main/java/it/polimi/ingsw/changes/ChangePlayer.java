package it.polimi.ingsw.changes;

import it.polimi.ingsw.GC_40.Play;
import it.polimi.ingsw.GC_40.Player;
import it.polimi.ingsw.client.ClientModel;

public class ChangePlayer implements Change {
	private Player currentPlayer;
	private Play play;
	
	public ChangePlayer(Player currentPlayer, Play play){
		this.currentPlayer=currentPlayer;
		this.play=play;
	}

	@Override
	public void applyChange(ClientModel client) {
		if(client.getPlayer().getMatch()==play.getMatch()){
		client.setCurrentPlayer(currentPlayer);
		System.out.println("It's the " + currentPlayer.getName() + "'s turn.");
	}
	}

}
