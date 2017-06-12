package it.polimi.ingsw.changes;

import java.util.ArrayList;

import it.polimi.ingsw.GC_40.Player;
import it.polimi.ingsw.client.ClientModel;

public class ChangeRound implements Change {
	private int round;
	private ArrayList<Player> players;
	
	public ChangeRound(int round, ArrayList<Player> players){
		this.round=round;
		this.players=players;
	}

	@Override
	public void applyChange(ClientModel client) {
		client.setRound(round);
		for(Player player: players){
		client.setPlayer(player);}

	}

}
