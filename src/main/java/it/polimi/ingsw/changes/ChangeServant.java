package it.polimi.ingsw.changes;

import it.polimi.ingsw.GC_40.Player;
import it.polimi.ingsw.colors.ColorPlayer;

public class ChangeServant implements Change {
	int servant;
	ColorPlayer color;
	
	public ChangeServant(ColorPlayer color, int servant){
		this.servant=servant;
		this.color=color;
	}

	@Override
	public void applyChange() {
		// TODO Auto-generated method stub

	}

}
