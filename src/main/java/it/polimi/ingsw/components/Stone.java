package it.polimi.ingsw.components;

import it.polimi.ingsw.GC_40.Player;

public class Stone extends Resource {

	@Override
	public void incrementPrivilegeCouncil(Player player) {
		player.incrementStone(1);
		player.incrementWood(1);
		
	}

}
