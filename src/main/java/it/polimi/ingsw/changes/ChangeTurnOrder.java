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
		if(client.getPlayer().getMatch()==currentTurnOrder.get(0).getMatch()){
		client.setCurrentTurnOrder(currentTurnOrder);
		System.out.println("The current turn order is: "+ printCurrentTurnOrder());}
	}

	public ArrayList <String> printCurrentTurnOrder(){
		ArrayList <String> order = new ArrayList <String>();
		for (Player p : currentTurnOrder){
			order.add(p.getName());
		}
		return order;
	}
}
