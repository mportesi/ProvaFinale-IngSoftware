package it.polimi.ingsw.changes;

import it.polimi.ingsw.GC_40.Player;
import it.polimi.ingsw.client.ClientModel;
import it.polimi.ingsw.colors.ColorPlayer;
/**
 * @author Sara
 * To set on the client's player the modified number of the avaiable stones.
 */
public class ChangeStone implements Change {
	int stone;
	Player player;
	
	public ChangeStone(Player player, int stone){
		this.stone=stone;
		this.player=player;
	}
	
	public void applyChange(ClientModel client){
		if(client.getName().equals(player.getName())){
			client.getPlayer().setStone(stone);
		}
	}

}
