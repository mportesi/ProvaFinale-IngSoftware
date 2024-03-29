package it.polimi.ingsw.changes;

import it.polimi.ingsw.GC_40.Observable;
import it.polimi.ingsw.GC_40.Play;
import it.polimi.ingsw.GC_40.Player;
import it.polimi.ingsw.client.ClientModel;
import it.polimi.ingsw.colors.ColorPlayer;
/**
 * @author Sara
 * To modify the player's coins on the client.
 */
public class ChangeCoin implements Change {
	private int coin;
	private Player player;

	public ChangeCoin(Player player, int coin) {
		this.coin = coin;
		this.player = player;
	}

	@Override
	public void applyChange(ClientModel client){
		if (client.getName().equals(player.getName())){
			client.getPlayer().setCoin(coin);
		}

	}
}

