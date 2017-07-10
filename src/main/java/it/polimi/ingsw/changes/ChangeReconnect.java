package it.polimi.ingsw.changes;

import it.polimi.ingsw.GC_40.Player;
import it.polimi.ingsw.client.ClientModel;
/**
 * @author Sara
 * To notify that a client is reconnected to the game.
 */
public class ChangeReconnect implements Change {
	Player player;
	
	public ChangeReconnect(Player player){
		this.player = player;
	}
	
	@Override
	public void applyChange(ClientModel client) {
		if (player.getMatch()==(client.getPlayer().getMatch())){
		System.out.println("The player " + player.getName() + " has reconnected.");
		
	}
}
}
