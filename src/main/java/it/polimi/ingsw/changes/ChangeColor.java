package it.polimi.ingsw.changes;

import it.polimi.ingsw.GC_40.Player;
import it.polimi.ingsw.client.ClientModel;
import it.polimi.ingsw.colors.ColorPlayer;

public class ChangeColor implements Change {
	private Player player;
	private ColorPlayer color;
	
	public ChangeColor(Player player, ColorPlayer color){
		this.player=player;
		this.color=color;
	}

	@Override
	public void applyChange(ClientModel client) {
		if (client.getPlayer().getName().equals(player.getName())){
		client.getPlayer().setColor(color);
		}
	}

}
