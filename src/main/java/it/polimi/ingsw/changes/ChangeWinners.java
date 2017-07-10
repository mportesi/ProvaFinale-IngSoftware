package it.polimi.ingsw.changes;

import java.io.IOException;
import java.util.ArrayList;

import it.polimi.ingsw.GC_40.Player;
import it.polimi.ingsw.client.ClientModel;
/**
 * @author Sara
 * To notify the winners.
 */
public class ChangeWinners implements Change {
	private ArrayList<Player> winners;
	
	public ChangeWinners(ArrayList<Player> winners){
		this.winners=winners;
	}

	@Override
	public void applyChange(ClientModel client) throws IOException {
		if(client.getPlayer().getMatch()==winners.get(0).getMatch()){
		client.setEndGame();
		client.setWinners(winners);
		for (Player p : winners){
			rank(p);
		}
		System.out.println("The winners are " + printWinner());}

	}
	
	private void rank(Player player) {
		System.out.println("Player "+ player.getName() + ":\n" + "VictoryPoint: " + player.getVictoryPoint() + "\nMilitaryPoint: " + player.getMilitaryPoint());
			
		}
		
	

	public ArrayList <String> printWinner(){
		ArrayList <String> name = new ArrayList <String>();
		for (Player p : winners){
			
			name.add(p.getName());
		}
		return name;
	}

}
