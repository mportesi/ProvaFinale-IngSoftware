package it.polimi.ingsw.changes;

import it.polimi.ingsw.GC_40.Player;
import it.polimi.ingsw.colors.ColorPlayer;

public class ChangeVictoryPoint implements Change {
	private int victoryPoint;
	private ColorPlayer color;
	
	public ChangeVictoryPoint(ColorPlayer color, int victoryPoint){
		this.color=color;
		this.victoryPoint=victoryPoint;
	}

	@Override
	public void applyChange() {
		// TODO Auto-generated method stub

	}

}
