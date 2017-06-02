package it.polimi.ingsw.changes;

import it.polimi.ingsw.GC_40.Player;
import it.polimi.ingsw.colors.ColorPlayer;

public class ChangeWood implements Change {
	private int wood;
	private ColorPlayer color;
	
	public ChangeWood(ColorPlayer color, int wood){
		this.wood=wood;
		this.color=color;
	}

	@Override
	public void applyChange() {
		// TODO Auto-generated method stub

	}

}
