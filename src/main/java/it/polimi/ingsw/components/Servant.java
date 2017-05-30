package it.polimi.ingsw.components;

import it.polimi.ingsw.GC_40.Player;

public class Servant extends Resource {
	
	public void incrementPrivilegeCouncil(Player player){
		player.incrementServant(2);
	}

}
