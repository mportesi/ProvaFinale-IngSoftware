package it.polimi.ingsw.changes;

import it.polimi.ingsw.colors.ColorPlayer;
import it.polimi.ingsw.components.Relative;

public class ChangeHarvestLeftArea implements Change {
	private ColorPlayer color;
	private Relative relative;
	
	public ChangeHarvestLeftArea(ColorPlayer color, Relative relative){
		this.color=color;
		this.relative=relative;
	}

	@Override
	public void applyChange() {
		// TODO Auto-generated method stub

	}

}