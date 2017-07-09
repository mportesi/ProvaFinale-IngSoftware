package it.polimi.ingsw.actions;

import it.polimi.ingsw.GC_40.Observable;
import it.polimi.ingsw.GC_40.Play;
import it.polimi.ingsw.GC_40.Player;
import it.polimi.ingsw.areas.MarketBuilding;
import it.polimi.ingsw.changes.Change;
import it.polimi.ingsw.changes.ChangeMarket;
import it.polimi.ingsw.changes.ChangeNotApplicable;
import it.polimi.ingsw.changes.ChangeOccupiedRelative;
import it.polimi.ingsw.components.Relative;
import it.polimi.ingsw.effects.Effect;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.json.simple.parser.ParseException;


/**
 *  Action invoked when a player puts his relative on one market.
 *
 * @author Chiara
 *
 */

public class PutRelativeOnMarket extends Observable<Change> implements PutRelative {

	Relative relative;
	MarketBuilding market;
	Player player;
	int match;
	
	public PutRelativeOnMarket(Player player,Relative relative, MarketBuilding market, int match){
		this.player=player;
		this.relative=relative;
		this.market=market;
		this.match = match;
	}
	
	public void setMarket(MarketBuilding market){
		this.market=market;
	}

	@Override
	public boolean isApplicable() {
		if (market.isOccupied()) {
			return false;
		} else if (relative.getValue() >= market.getCost()) {
			return true;
		} else{
			return false;}
	}


/**
 * If the relative of the player has enough value to do the action, it will occupy the area.
 * All the observer will be notified and the player will receive the resources associated to the area.
 * If the action is not applicable, the player will receive a message on the console.
 * @author Chiara
 * 
 *
 */
	
	@Override
	public void apply(Play play) throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		if (isApplicable()) {
			// set the market as occupied because none can put other relatives
			// in that space
			market.setOccupied(player, relative, market);
			play.notifyObserver(new ChangeMarket(player, relative, market));
			player.setOccupiedRelative(relative);
			play.notifyObserver(new ChangeOccupiedRelative(player, relative));
			// take the bonus
			market.applyEffect(player, play);
			play.changeCurrentPlayer();
		}
		else {
			if (relative.getServantsUsed()!=0){
				player.incrementServant(relative.getServantsUsed(), play);
				relative.setValueServant(0);
			}
			play.notifyObserver( new ChangeNotApplicable(player, "you cannot put a relative on this market!"));
		}
		return;
	}

	@Override
	public int getMatch() {
		// TODO Auto-generated method stub
		return match;
	}

}
