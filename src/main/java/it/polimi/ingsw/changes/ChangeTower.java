package it.polimi.ingsw.changes;

import it.polimi.ingsw.areas.Floor;
import it.polimi.ingsw.areas.Tower;

public class ChangeTower implements Change {
	private Tower tower;
	private int floor;
	
	public ChangeTower(Tower tower, int floor){
		this.tower=tower;
		this.floor=floor;
	}

	@Override
	public void applyChange() {
		// TODO Auto-generated method stub

	}

}
