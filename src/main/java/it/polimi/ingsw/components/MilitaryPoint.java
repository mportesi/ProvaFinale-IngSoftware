package it.polimi.ingsw.components;

import it.polimi.ingsw.GC_40.Player;

public class MilitaryPoint extends Point {
	
	@Override
	public void incrementPrivilegeCouncil(Player player){
		player.incrementMilitaryPoint(2);
	}

}
