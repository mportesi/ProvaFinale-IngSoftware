/**
 * 
 */
package it.polimi.ingsw.changes;

import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

import it.polimi.ingsw.GC_40.Observable;
import it.polimi.ingsw.GC_40.Play;
import it.polimi.ingsw.GC_40.Player;
import it.polimi.ingsw.client.Client;
import it.polimi.ingsw.client.ClientModel;

/**
 * @author Sara
 *
 */

public class ChangeNewPlayer extends Observable<Change> implements Change {
	private Player player;
	private Play play;
	

	
	public ChangeNewPlayer(Player player, Play play){
		this.player=player;
		this.play=play;
	}
	
	@Override
	public void applyChange(ClientModel client) {
		//if (client.getPlayer().getMatch()==play.getMatch() && client.getName().equals(player.getName())){
		client.setPlayer(player);
		}
	}

	@Override
	public String toString() {
		return "ChangeNewPlayer [player=" + player + "]";
	}

}
