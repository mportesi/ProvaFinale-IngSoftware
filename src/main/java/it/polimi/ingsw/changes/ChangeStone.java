package it.polimi.ingsw.changes;

import it.polimi.ingsw.GC_40.Player;
import it.polimi.ingsw.client.ClientModel;
import it.polimi.ingsw.colors.ColorPlayer;

public class ChangeStone implements Change {
	int stone;
	Player player;
	
	public ChangeStone(Player player, int stone){
		this.stone=stone;
		this.player=player;
	}
	
	public void applyChange(ClientModel client){
		if(client.getName().equals(player.getName())){
			client.getPlayer().setStone(stone);
		}
		/*for (Player p : client.getPlayers()) {
			if (player.equals(p)) {
				p.setStone(stone);
			}
		}*/
	}

}
