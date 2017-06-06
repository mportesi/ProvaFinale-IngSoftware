package it.polimi.ingsw.changes;

import it.polimi.ingsw.areas.Floor;
import it.polimi.ingsw.areas.Tower;
import it.polimi.ingsw.client.ClientModel;
import it.polimi.ingsw.components.Relative;

public class ChangeTower implements Change {
	private Tower tower;
	private int floor;
	private Relative relative;
	
	public ChangeTower(Tower tower, int floor, Relative relative){
		this.tower=tower;
		this.floor=floor;
		this.relative=relative;
	}

	@Override
	public void applyChange(ClientModel client) {
		client.setTower(tower, floor, relative);
	}

}
