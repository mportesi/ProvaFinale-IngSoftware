package it.polimi.ingsw.points;

import it.polimi.ingsw.GC_40.Player;
import it.polimi.ingsw.components.Piece;

public abstract class Point extends Piece {
	
	@Override
	public abstract void incrementPrivilegeCouncil(Player player);

}
