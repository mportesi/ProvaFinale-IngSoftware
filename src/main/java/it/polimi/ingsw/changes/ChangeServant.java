package it.polimi.ingsw.changes;

import it.polimi.ingsw.GC_40.Player;
import it.polimi.ingsw.client.ClientModel;
import it.polimi.ingsw.colors.ColorPlayer;

public class ChangeServant implements Change {
	int servant;
	Player player;
	
	public ChangeServant(Player player, int servant){
		this.servant=servant;
		this.player=player;
	}

	@Override
	public void applyChange(ClientModel client) {
			if (client.getName().equals(player.getName())) {
				client.getPlayer().setServant(servant);
			}
		}

	}
