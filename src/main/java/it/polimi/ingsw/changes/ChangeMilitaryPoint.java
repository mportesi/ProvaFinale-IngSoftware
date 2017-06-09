package it.polimi.ingsw.changes;

import it.polimi.ingsw.GC_40.Player;
import it.polimi.ingsw.client.ClientModel;
import it.polimi.ingsw.colors.ColorPlayer;

public class ChangeMilitaryPoint implements Change {
	private int militaryPoint;
	private Player player;
	
	
	public ChangeMilitaryPoint(Player player, int militaryPoint){
		this.militaryPoint=militaryPoint;
		this.player=player;
	}
	

	@Override
	public void applyChange(ClientModel client) {
		/*for (Player p : client.getPlayers()) {
			if (player.equals(p)) {
				p.setMilitaryPoint(militaryPoint);
			}
		}*/

	}

}
