package it.polimi.ingsw.changes;

import it.polimi.ingsw.client.ClientModel;

public class ChangeRound implements Change {
	private int round;
	
	public ChangeRound(int round){
		this.round=round;
	}

	@Override
	public void applyChange(ClientModel client) {
		client.setRound(round);

	}

}
