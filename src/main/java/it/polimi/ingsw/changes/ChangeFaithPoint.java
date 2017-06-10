package it.polimi.ingsw.changes;

import it.polimi.ingsw.GC_40.Observable;
import it.polimi.ingsw.GC_40.Play;
import it.polimi.ingsw.GC_40.Player;
import it.polimi.ingsw.client.ClientModel;
import it.polimi.ingsw.colors.ColorPlayer;

public class ChangeFaithPoint implements Change {
	private int faithPoint;
	private Player player;

	public ChangeFaithPoint(Player player, int faithPoint) {
		this.faithPoint = faithPoint;
		this.player = player;
	}

	@Override
	public void applyChange(ClientModel client) {
		if(client.getPlayer().equals(client)){
			player.setFaithPoint(faithPoint);
		}
		/*for (Player p : client.getPlayers()) {
			if (player.equals(p)) {
				p.setFaithPoint(faithPoint);
			}
		}*/

	}

}
