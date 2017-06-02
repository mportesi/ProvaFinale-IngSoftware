package it.polimi.ingsw.changes;

import it.polimi.ingsw.areas.MarketBuilding;
import it.polimi.ingsw.colors.ColorPlayer;
import it.polimi.ingsw.components.Relative;

public class ChangeMarket implements Change {
	private ColorPlayer color;
	private Relative relative;
	private MarketBuilding market;
	
	public ChangeMarket(ColorPlayer color, Relative relative, MarketBuilding market){
		this.color=color;
		this.relative=relative;
		this.market=market;
	}

	@Override
	public void applyChange() {
		// TODO Auto-generated method stub

	}

}
