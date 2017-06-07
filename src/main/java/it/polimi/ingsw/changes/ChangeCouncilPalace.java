package it.polimi.ingsw.changes;

import it.polimi.ingsw.areas.CouncilPalace;
import it.polimi.ingsw.client.ClientModel;
import it.polimi.ingsw.components.Relative;

public class ChangeCouncilPalace implements Change {
	//private Player player;
	private Relative relative;
	
	public ChangeCouncilPalace(Relative relative){
		this.relative=relative;
	}

	@Override
	public void applyChange(ClientModel client) {
		client.setCouncilPalace(relative);
		
	}
	

}
