package Components;

import it.polimi.ingsw.GC_40.Player;

public class PrivilegeCouncil extends Piece {
	
	public static void giveBonus(Piece piece, Player player){
		piece.incrementPrivilegeCouncil(player);
		
		}

	//It is useless in this class but this class extend Piece
	@Override
	public void incrementPrivilegeCouncil(Player player) {
		return;
	}
}

