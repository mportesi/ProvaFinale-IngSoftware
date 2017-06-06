package it.polimi.ingsw.changes;

import java.util.ArrayList;

import it.polimi.ingsw.GC_40.Play;
import it.polimi.ingsw.GC_40.Player;
import it.polimi.ingsw.client.ClientModel;

public class ChangeTurnOrder implements Change {
	ArrayList<Player> currentTurnOrder;
	
	public ChangeTurnOrder(ArrayList<Player> currentTurnOrder){
		this.currentTurnOrder=currentTurnOrder;
	}



	@Override
	public void applyChange(ClientModel client) {
		client.setCurrentTurnOrder(currentTurnOrder);
	}


}
