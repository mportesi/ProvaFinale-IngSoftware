package Components;

import it.polimi.ingsw.GC_40.Player;

public class MilitaryPoint extends Point {
	public void incrementPrivilegeCouncil(Player player){
		player.incrementMilitaryPoint(2);
	}

}
