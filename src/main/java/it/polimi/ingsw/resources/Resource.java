package it.polimi.ingsw.resources;

import it.polimi.ingsw.GC_40.Player;
import it.polimi.ingsw.components.Piece;

public abstract class Resource extends Piece {
	
	@Override
	public abstract void incrementPrivilegeCouncil(Player player);
}
