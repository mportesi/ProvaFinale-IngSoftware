package it.polimi.ingsw.changes;

import it.polimi.ingsw.GC_40.Player;
import it.polimi.ingsw.client.ClientModel;
import it.polimi.ingsw.colors.ColorPlayer;
/**
 * @author Sara
 * To update the victory points on the client's player.
 */
public class ChangeVictoryPoint implements Change {
	private int victoryPoint;
	private Player player;
	
	public ChangeVictoryPoint(Player player, int victoryPoint){
		this.player=player;
		this.victoryPoint=victoryPoint;
	}

	@Override
	public void applyChange(ClientModel client) {
		if(client.getName().equals(player.getName())){
			client.getPlayer().setVictoryPoint(victoryPoint);
		}
	}

}
