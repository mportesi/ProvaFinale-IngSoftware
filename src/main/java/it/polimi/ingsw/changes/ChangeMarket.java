package it.polimi.ingsw.changes;

import it.polimi.ingsw.areas.MarketBuilding;
import it.polimi.ingsw.client.ClientModel;
import it.polimi.ingsw.colors.ColorPlayer;
import it.polimi.ingsw.components.Relative;

public class ChangeMarket implements Change {
	
	private Relative relative;
	private MarketBuilding market;
	
	public ChangeMarket(Relative relative, MarketBuilding market){
		
		this.relative=relative;
		this.market=market;
	}

	@Override
	public void applyChange(ClientModel client) {
		client.setMarket(market, relative);
	}

}
