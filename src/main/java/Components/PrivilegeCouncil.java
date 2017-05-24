package Components;

import it.polimi.ingsw.GC_40.Player;

public class PrivilegeCouncil extends Piece {
	
	public static void giveBonus(Piece piece, Player player){
		Piece.incrementPrivilegeCouncil(player);
		}
}

