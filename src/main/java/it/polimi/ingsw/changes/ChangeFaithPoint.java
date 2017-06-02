package it.polimi.ingsw.changes;

import it.polimi.ingsw.GC_40.Play;
import it.polimi.ingsw.GC_40.Player;
import it.polimi.ingsw.colors.ColorPlayer;

public class ChangeFaithPoint implements Change {
	private int faithPoint;
	private ColorPlayer color;
	
	public ChangeFaithPoint(ColorPlayer color, int faithPoint){
		this.faithPoint=faithPoint;
		this.color=color;
	}
	
	
	@Override
	public void applyChange() {
		// TODO Auto-generated method stub
		
	}

	

}
