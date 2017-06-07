/**
 * 
 */
package it.polimi.ingsw.changes;

import java.util.UUID;

import it.polimi.ingsw.GC_40.Observable;
import it.polimi.ingsw.GC_40.Player;
import it.polimi.ingsw.client.Client;
import it.polimi.ingsw.client.ClientModel;

/**
 * @author Sara
 *
 */

public class ChangeNewPlayer extends Observable<Change> implements Change {
	private Player player;
	

	/* (non-Javadoc)
	 * @see it.polimi.ingsw.changes.Change#applyChange()
	 */
	
	public ChangeNewPlayer(Player player){
		this.player=player;
	}
	
	@Override
	public void applyChange(ClientModel client) {
		client.addPlayer(player);
		//TODO GIVE THE NAME TO THE CLIENT AND SET HIS PLAYER 
	}

}
