/**
 * 
 */
package it.polimi.ingsw.changes;

import java.util.UUID;

import it.polimi.ingsw.GC_40.Player;
import it.polimi.ingsw.client.Client;

/**
 * @author Sara
 *
 */

public class ChangeNewPlayer implements Change {
	private Player player;
	

	/* (non-Javadoc)
	 * @see it.polimi.ingsw.changes.Change#applyChange()
	 */
	
	@Override
	public void applyChange() {
		// TODO Auto-generated method stub
		
		client.setPlayer();
	}

}
