package it.polimi.ingsw.actions;

import it.polimi.ingsw.GC_40.Observable;
import it.polimi.ingsw.GC_40.Play;
import it.polimi.ingsw.GC_40.Player;
import it.polimi.ingsw.areas.MarketBuilding;
import it.polimi.ingsw.changes.Change;
import it.polimi.ingsw.changes.ChangeGiveBackServants;
import it.polimi.ingsw.changes.ChangeMarket;
import it.polimi.ingsw.changes.ChangeNotApplicable;
import it.polimi.ingsw.changes.ChangeOccupiedRelative;
import it.polimi.ingsw.components.PrivilegeCouncil;
import it.polimi.ingsw.components.Relative;
import it.polimi.ingsw.effects.Effect;
import it.polimi.ingsw.effects.GainPrivilegeCouncil;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.json.simple.parser.ParseException;

public class PutRelativeOnMarketPrivilege extends Observable<Change> implements PutRelative {

	Relative relative;
	MarketBuilding market;
	Player player;
	String bonus;
	
	public PutRelativeOnMarketPrivilege(Player player,Relative relative, MarketBuilding market,String bonus){
		this.player=player;
		this.relative=relative;
		this.market=market;
		this.bonus=bonus;
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
		} else
			return false;
	}

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
			GainPrivilegeCouncil gain= new GainPrivilegeCouncil(bonus);
			gain.apply(player, play);
			play.changeCurrentPlayer();
			
		}
		else {
			if (relative.getServantsUsed()!=0){
				relative.setValueServant(0);
				play.notifyObserver(new ChangeGiveBackServants(player, relative, relative.getServantsUsed()));
			}
			play.notifyObserver( new ChangeNotApplicable(player, "you cannot put a relative on this market!"));
		}
	}

}
