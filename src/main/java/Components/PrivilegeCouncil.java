package Components;

import it.polimi.ingsw.GC_40.Player;

public class PrivilegeCouncil extends Piece {
	
	public static void giveBonus(String piece, Player player){
		//piece.increment(player, n)
		switch(piece){
		case "coin": player.incrementCoin(2);
					break;
		case "stone": player.incrementStone(1);
					  player.incrementWood(1);
					break;
		case "wood": player.incrementStone(1);
		  			 player.incrementWood(1);
		  			break;
		case "servant": player.incrementServant(2);
					break;
		case "militaryPoint": player.incrementMilitaryPoint(2);
					break;
		case "faithPoint": player.incrementFaithPoint(1);
					break;
		}
	}

}
