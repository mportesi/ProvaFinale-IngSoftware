package it.polimi.ingsw.actions;

import it.polimi.ingsw.GC_40.Observable;
import it.polimi.ingsw.GC_40.Play;
import it.polimi.ingsw.GC_40.Player;
import it.polimi.ingsw.areas.MarketBuilding;
import it.polimi.ingsw.changes.Change;
import it.polimi.ingsw.changes.ChangeMarket;
import it.polimi.ingsw.components.Relative;
import it.polimi.ingsw.effects.Effect;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.json.simple.parser.ParseException;

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
	public void apply(Play play) throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		if (isApplicable()) {
			// set the market as occupied because none can put other relatives
			// in that space
			market.setOccupied(relative, market);
			market.setPlayer(player);
			player.setOccupiedRelative(relative);
			// take the bonus
			market.applyEffect(player);
			play.changeCurrentPlayer();
		}
		else {
			play.actionNotApplicable(player);
		}
		return;
	}

}
