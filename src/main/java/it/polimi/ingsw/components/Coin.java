package it.polimi.ingsw.components;

import it.polimi.ingsw.GC_40.Player;

public class Coin extends Resource {

	@Override
	public void incrementPrivilegeCouncil(Player player) {
		// TODO Auto-generated method stub
		player.incrementCoin(2);
		
	}

}
