package it.polimi.ingsw.changes;

import it.polimi.ingsw.client.ClientModel;

public class ChangePeriod implements Change {
	private int period;
	private int match;
	
	public ChangePeriod(int period, int match){
		this.period=period;
		this.match=match;
	}

	@Override
	public void applyChange(ClientModel client) {
		if(client.getPlayer().getMatch()==match){
		client.setPeriod(period);
		System.out.println("The period " + (period-1) + " is finished!");}
	}

}
