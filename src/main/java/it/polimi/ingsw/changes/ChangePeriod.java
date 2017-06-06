package it.polimi.ingsw.changes;

import it.polimi.ingsw.client.ClientModel;

public class ChangePeriod implements Change {
	int period;
	
	public ChangePeriod(int period){
		this.period=period;
	}

	@Override
	public void applyChange(ClientModel client) {
		client.setPeriod(period);
	}

}
