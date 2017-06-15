package it.polimi.ingsw.changes;

import java.util.ArrayList;

import it.polimi.ingsw.GC_40.Player;
import it.polimi.ingsw.client.ClientModel;

public class ChangeInitializePlay implements Change {
	private int numberOfPlayers;
	private ArrayList<Player> players;
	
	public ChangeInitializePlay(int numberOfPlayers){
		this.numberOfPlayers=numberOfPlayers;
		this.players=players;
		
	}

	@Override
	public void applyChange(ClientModel client) {
		System.out.println("The game can start");
		//client.setStartPlay(true);
	}

}
