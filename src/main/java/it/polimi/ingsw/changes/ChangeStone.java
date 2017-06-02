package it.polimi.ingsw.changes;

import it.polimi.ingsw.GC_40.Player;
import it.polimi.ingsw.colors.ColorPlayer;

public class ChangeStone implements Change {
	int stone;
	ColorPlayer color;
	
	public ChangeStone(ColorPlayer color, int stone){
		this.stone=stone;
		this.color=color;
	}
	
	public void applyChange(){
		//applico incrementStone nel model del client
	}

}
