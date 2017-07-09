package it.polimi.ingsw.actions;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.GC_40.Board;
import it.polimi.ingsw.GC_40.Observable;
import it.polimi.ingsw.GC_40.Play;
import it.polimi.ingsw.GC_40.Player;
import it.polimi.ingsw.areas.HarvestAndProductionArea;
import it.polimi.ingsw.cards.TerritoryCard;
import it.polimi.ingsw.changes.Change;
import it.polimi.ingsw.changes.ChangeHarvestLeftArea;
import it.polimi.ingsw.changes.ChangeHarvestRightArea;
import it.polimi.ingsw.changes.ChangeNotApplicable;
import it.polimi.ingsw.changes.ChangeOccupiedRelative;
import it.polimi.ingsw.components.Relative;
import it.polimi.ingsw.effects.GainHarvestValue;
import it.polimi.ingsw.effects.GainProductionValue;

/**
 * @author Chiara
 * Action invoked when a player puts his relative on the Harvest Area.
 *
 */
public class PutRelativeOnHarvestArea extends Observable<Change> implements PutRelative {

	Relative relative;
	HarvestAndProductionArea harvestArea;
	Player player;
	String area;
	int match;
	
	public PutRelativeOnHarvestArea(Player player, Relative relative, HarvestAndProductionArea harvestArea,
			String area, int match) {
		this.player = player;
		this.relative = relative;
		this.area = area;
		this.harvestArea = harvestArea;
		this.match = match;
	}

	/**
	 * @author Chiara
	 * Checks if the action is applicable, in particular if the relative has enough value and, in case the choosen Area is the left one, verifies that this space is free. 
	 * In the second case, if the chosen area is the right one, verifies that there are not other relatives that belong to the player (except the neutral one) with the function isAlreadyPresent().
	 *
	 */
	
	@Override
	public boolean isApplicable() {

		switch (area) {
		case "left": {
			if (relative.getValue() >= harvestArea.getValueOfLeftArea()) {
				if (harvestArea.getLeftRelative() == null) {
					if ((!(harvestArea.isAlreadyPresent(player)) || relative.getColor() == null)) {
						return true;
					}
				}
			}
			break;
		}

		case "right": {

			if (relative.getValue() >= (harvestArea.getValueOfRightArea()-harvestArea.getMalus())) {
				if (!(harvestArea.isAlreadyPresent(player)) || relative.getColor() == null) {
					return true;
				}
			}
			break;
		}

		}
		return false;
	}

	/**
	 * The player puts his/her relative on the left/right area. If the player has some territoryCards, he/she can activate the permanent effects associated to them.
	 * @author Chiara
	 * 
	 *
	 */
	
	@Override
	public void apply(Play play)
			throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		if (isApplicable()) {
			
			if (area.equals("left")) {
				harvestArea.setLeftRelativeOnHarvest(relative);
				play.notifyObserver(new ChangeHarvestLeftArea(relative));
				player.setOccupiedRelative(relative);
				play.notifyObserver(new ChangeOccupiedRelative(player, relative));
				applyPermanentEffect(play);
				GainHarvestValue gainHarvestValue = new GainHarvestValue(relative.getValue());
				gainHarvestValue.apply(player, play);

			}
						else {
				harvestArea.setRightRelativeOnHarvest(relative);
				play.notifyObserver(new ChangeHarvestRightArea(relative));
				player.setOccupiedRelative(relative);
				play.notifyObserver(new ChangeOccupiedRelative(player, relative));
				int malus = play.getBoard().getHarvestArea().getMalus();
				relative.setValue(-malus);
				int newValue = relative.getValue();
				//apply the territory permanent effect
				applyPermanentEffect(play);
				GainHarvestValue gainHarvestValue = new GainHarvestValue(newValue);
				gainHarvestValue.apply(player, play);
			}
			play.changeCurrentPlayer();
		} else {
			if (relative.getServantsUsed()!=0){
				player.incrementServant(relative.getServantsUsed(), play);
				relative.setValueServant(0);
			}
			play.notifyObserver( new ChangeNotApplicable(player, "the relative hasn't enough value!"));
		}
	}
	
	
	
	private void applyPermanentEffect(Play play) throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException{
		for(TerritoryCard card:player.getTerritory()){
			if(relative.getValue()>card.getPermanentCost()){
				card.applyPermanentEffect(player, play);
			}
		}
	}
	
	@Override
	public int getMatch() {
		return match;
	}
}
