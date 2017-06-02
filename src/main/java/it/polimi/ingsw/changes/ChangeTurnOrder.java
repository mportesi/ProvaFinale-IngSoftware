package it.polimi.ingsw.changes;

import java.util.ArrayList;

import it.polimi.ingsw.GC_40.Play;
import it.polimi.ingsw.GC_40.Player;

public class ChangeTurnOrder implements Change {
	ArrayList<Player> currentTurnOrder;
	
	public ChangeTurnOrder(ArrayList<Player> currentTurnOrder){
		this.currentTurnOrder=currentTurnOrder;
	}



	@Override
	public void applyChange() {
		// TODO Auto-generated method stub
		//change the order in the model of the player
		
	}


}
