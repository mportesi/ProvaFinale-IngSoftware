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
	private int match;
	

	
	public ChangeNewPlayer(Player player, int match){
		this.player=player;
		this.match=match;
	}
	
	@Override
	public void applyChange(ClientModel client) {
		if (client.getName().equals(player.getName())){
		client.setPlayer(player);
		System.out.println("ho registrato: " + player.getName());
		}
		
	}

	@Override
	public String toString() {
		return "ChangeNewPlayer [player=" + player + "]";
	}

}
