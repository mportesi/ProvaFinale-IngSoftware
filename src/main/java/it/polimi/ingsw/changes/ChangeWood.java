package it.polimi.ingsw.changes;

import it.polimi.ingsw.GC_40.Player;
import it.polimi.ingsw.client.ClientModel;
import it.polimi.ingsw.colors.ColorPlayer;
/**
 * @author Sara
 * To modify the player's  available wood on the client.
 */
public class ChangeWood implements Change {
	private int wood;
	private Player player;
	
	public ChangeWood(Player player, int wood){
		this.wood=wood;
		this.player=player;
	}

	@Override
	public void applyChange(ClientModel client) {
		if(client.getName().equals(player.getName())){
			client.getPlayer().setWood(wood);
		}
	}

}
