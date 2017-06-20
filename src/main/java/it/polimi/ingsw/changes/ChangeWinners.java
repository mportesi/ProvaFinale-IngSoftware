package it.polimi.ingsw.changes;

import java.util.ArrayList;

import it.polimi.ingsw.GC_40.Player;
import it.polimi.ingsw.client.ClientModel;

public class ChangeWinners implements Change {
	private ArrayList<Player> winners;
	
	public ChangeWinners(ArrayList<Player> winners){
		this.winners=winners;
	}

	@Override
	public void applyChange(ClientModel client) {
		client.setEndGame();
		System.out.println("The winners are " + printWinner());

	}
	
	public ArrayList <String> printWinner(){
		ArrayList <String> name = new ArrayList <String>();
		for (Player p : winners){
			name.add(p.getName());
		}
		return name;
	}

}
