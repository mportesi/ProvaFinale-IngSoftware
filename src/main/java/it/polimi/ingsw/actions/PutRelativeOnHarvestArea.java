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

	@Override
	public void apply(Play play)
			throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		if (isApplicable()) {
			// If the left position is free, the player put the relative there.
			if (area.equals("left")) {
				harvestArea.setLeftRelativeOnHarvest(relative);
				play.notifyObserver(new ChangeHarvestLeftArea(relative));
				player.setOccupiedRelative(relative);
				play.notifyObserver(new ChangeOccupiedRelative(player, relative));
				//apply the territory permanent effect
				applyPermanentEffect(play);
				GainHarvestValue gainHarvestValue = new GainHarvestValue(relative.getValue());
				gainHarvestValue.apply(player, play);

			}
			// Else he put the relative on the other side with the penalty
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
		// TODO Auto-generated method stub
		return match;
	}
}
