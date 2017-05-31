package it.polimi.ingsw.actions;

import it.polimi.ingsw.GC_40.Player;
import it.polimi.ingsw.areas.MarketBuilding;
import it.polimi.ingsw.components.Relative;
import it.polimi.ingsw.effects.Effect;

import java.util.List;

public class PutRelativeOnMarket implements PutRelative {

	Relative relative;
	MarketBuilding market;
	Player player;
	
	public PutRelativeOnMarket(Player player,Relative relative){
		this.player=player;
		this.relative=relative;
	}
	
	public void setMarket(MarketBuilding market){
		this.market=market;
	}

	@Override
	public boolean isApplicable() {
		if (market.IsOccupied()) {
			return false;
		} else if (relative.getValue() >= market.getCost()) {
			return true;
		} else
			return false;
	}

	@Override
	public void apply() {
		if (isApplicable()) {
			// set the market as occupied because none can put other relatives
			// in that space
			market.setOccupied();
			// take the bonus
			//market.giveBonus(player, market);
			market.applyEffect(player);
			
		}
	}

}
