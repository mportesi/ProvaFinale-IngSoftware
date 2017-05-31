package it.polimi.ingsw.points;

import it.polimi.ingsw.GC_40.Player;

public class FaithPoint extends Point {

	@Override
	public void incrementPrivilegeCouncil(Player player) {
		player.incrementFaithPoint(1);
	}

}
