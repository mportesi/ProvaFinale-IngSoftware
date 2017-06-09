package it.polimi.ingsw.changes;

import it.polimi.ingsw.GC_40.Player;
import it.polimi.ingsw.client.ClientModel;

public class ChangeInitializePlay implements Change {
	private int numberOfPlayers;
	
	
	public ChangeInitializePlay(int numberOfPlayers){
		this.numberOfPlayers=numberOfPlayers;
		
	}

	@Override
	public void applyChange(ClientModel client) {
		// TODO Auto-generated method stub
		System.out.println("The game can start");

	}

}
