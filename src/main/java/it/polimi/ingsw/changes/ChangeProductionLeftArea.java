package it.polimi.ingsw.changes;

import it.polimi.ingsw.client.ClientModel;
import it.polimi.ingsw.colors.ColorPlayer;
import it.polimi.ingsw.components.Relative;

public class ChangeProductionLeftArea implements Change {
	
	private Relative relative;
	
	public ChangeProductionLeftArea(Relative relative){
		this.relative=relative;
	}

	@Override
	public void applyChange(ClientModel client) {
		client.setProductionLeftArea(relative);

	}

}
