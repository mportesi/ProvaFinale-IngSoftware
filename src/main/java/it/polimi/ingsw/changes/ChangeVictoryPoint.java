package it.polimi.ingsw.changes;

import it.polimi.ingsw.GC_40.Player;
import it.polimi.ingsw.client.ClientModel;
import it.polimi.ingsw.colors.ColorPlayer;

public class ChangeVictoryPoint implements Change {
	private int victoryPoint;
	private Player player;
	
	public ChangeVictoryPoint(Player player, int victoryPoint){
		this.player=player;
		this.victoryPoint=victoryPoint;
	}

	@Override
	public void applyChange(ClientModel client) {
		for (Player p : client.getPlayers()) {
			if (player.equals(p)) {
				p.setVictoryPoint(victoryPoint);
			}
		}
	}

}
