package it.polimi.ingsw.actions;

import it.polimi.ingsw.GC_40.Observable;
import it.polimi.ingsw.GC_40.Player;
import it.polimi.ingsw.areas.MarketBuilding;
import it.polimi.ingsw.changes.Change;
import it.polimi.ingsw.changes.ChangeMarket;
import it.polimi.ingsw.components.Relative;
import it.polimi.ingsw.effects.Effect;

import java.util.List;

public class PutRelativeOnMarket extends Observable<Change> implements PutRelative {

	Relative relative;
	MarketBuilding market;
	Player player;
	
	public PutRelativeOnMarket(Player player,Relative relative, MarketBuilding market){
		this.player=player;
		this.relative=relative;
		this.market=market;
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
			ChangeMarket changeMarket= new ChangeMarket(relative, market);
			this.notifyObserver(changeMarket);
			// take the bonus
			//market.giveBonus(player, market);
			market.applyEffect(player);
			
		}
	}

}
