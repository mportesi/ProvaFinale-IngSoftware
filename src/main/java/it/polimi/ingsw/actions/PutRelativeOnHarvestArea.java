package it.polimi.ingsw.actions;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.GC_40.Board;
import it.polimi.ingsw.GC_40.Observable;
import it.polimi.ingsw.GC_40.Play;
import it.polimi.ingsw.GC_40.Player;
import it.polimi.ingsw.areas.HarvestAndProductionArea;
import it.polimi.ingsw.changes.Change;
import it.polimi.ingsw.changes.ChangeHarvestLeftArea;
import it.polimi.ingsw.changes.ChangeHarvestRightArea;
import it.polimi.ingsw.components.Relative;
import it.polimi.ingsw.effects.GainHarvestValue;
import it.polimi.ingsw.effects.GainProductionValue;

public class PutRelativeOnHarvestArea extends Observable<Change> implements PutRelative {

	Relative relative;
	HarvestAndProductionArea harvestArea;
	Player player;
	String area;

	public PutRelativeOnHarvestArea(Player player, Relative relative, HarvestAndProductionArea harvestArea,
			String area) {
		this.player = player;
		this.relative = relative;
		this.area = area;
		this.harvestArea = harvestArea;
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

			if (relative.getValue() >= harvestArea.getValueOfRightArea()) {
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
			if (area == "left") {
				harvestArea.setLeftRelativeOnHarvest(relative);
				player.setOccupiedRelative(relative);
				GainHarvestValue gainHarvestValue = new GainHarvestValue(relative.getValue());
				gainHarvestValue.apply(player);

			}
			// Else he put the relative on the other side with the penalty
			else {
				harvestArea.setRightRelativeOnHarvest(relative);
				player.setOccupiedRelative(relative);
				int malus = play.getBoard().getHarvestArea().getMalus();
				relative.setValue(-malus);
				int newValue = relative.getValue();
				GainHarvestValue gainHarvestValue = new GainHarvestValue(newValue);
				gainHarvestValue.apply(player);
			}
			play.changeCurrentPlayer();
		} else {
			play.actionNotApplicable(player);
		}
	}
}
