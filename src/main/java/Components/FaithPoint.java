package Components;

import it.polimi.ingsw.GC_40.Player;

public class FaithPoint extends Point {
	public void incrementPrivilegeCouncil(Player player){
		player.incrementFaithPoint(1);
	}

}
