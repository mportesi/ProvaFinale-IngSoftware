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
	

	/* (non-Javadoc)
	 * @see it.polimi.ingsw.changes.Change#applyChange()
	 */
	
	public ChangeNewPlayer(Player player, Play play){
		this.player=player;
		this.play=play;
	}
	
	@Override
	public void applyChange(ClientModel client) {
		if (client.getName().equals(player.getName())){
		client.setPlayer(player);
		System.out.println("Ho inizializzato: "+ client.getPlayer().getName() + player.getName());
		}
		//System.out.println("new player " + player.getName());
		//final Logger LOGGER = Logger.getLogger(ChangeNewPlayer.class.getName() );
		//98LOGGER.log(Level.FINE, "ChangeNewPlayer arrivato");
	}

	@Override
	public String toString() {
		return "ChangeNewPlayer [player=" + player + "]";
	}

}
