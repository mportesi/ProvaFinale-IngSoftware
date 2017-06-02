package it.polimi.ingsw.changes;

import it.polimi.ingsw.GC_40.Player;
import it.polimi.ingsw.colors.ColorPlayer;

public class ChangeMilitaryPoint implements Change {
	private int militaryPoint;
	private ColorPlayer color;
	
	
	public ChangeMilitaryPoint(ColorPlayer color, int militaryPoint){
		this.militaryPoint=militaryPoint;
		this.color=color;
	}
	

	@Override
	public void applyChange() {
		// TODO Auto-generated method stub

	}

}
