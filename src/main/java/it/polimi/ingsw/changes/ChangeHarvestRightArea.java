package it.polimi.ingsw.changes;

import java.util.ArrayList;

import it.polimi.ingsw.client.ClientModel;
import it.polimi.ingsw.components.Relative;

public class ChangeHarvestRightArea implements Change {
	private Relative relative;
	
	public ChangeHarvestRightArea(Relative relative){
		this.relative=relative;
	}
	

	@Override
	public void applyChange(ClientModel client) {
		client.setHarvestRightArea(relative);
	}

}
