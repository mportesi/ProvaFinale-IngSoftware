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
import it.polimi.ingsw.changes.ChangeOccupiedRelative;
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
			System.out.println("sono nel case left");
			if (relative.getValue() >= harvestArea.getValueOfLeftArea()) {
				System.out.println("Sono nell'if che verifica il valore dell'azione");
				if (harvestArea.getLeftRelative() == null) {
					System.out.println("sono nell'if che verifica che la zona a sx sia libera");
					if ((!(harvestArea.isAlreadyPresent(player)) || relative.getColor() == null)) {
						System.out.println("sono nell'if che verifica che anche nella sinistra non ci sia nessuno");
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
			System.out.println("The action is applicable()");
			// If the left position is free, the player put the relative there.
			if (area.equals("left")) {
				System.out.println("Sono nel case left");
				harvestArea.setLeftRelativeOnHarvest(relative);
				play.notifyObserver(new ChangeHarvestLeftArea(relative));
				
				player.setOccupiedRelative(relative);
				play.notifyObserver(new ChangeOccupiedRelative(player, relative));
				GainHarvestValue gainHarvestValue = new GainHarvestValue(relative.getValue());
				gainHarvestValue.apply(player, play);
				System.out.println(player);

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
				GainHarvestValue gainHarvestValue = new GainHarvestValue(newValue);
				gainHarvestValue.apply(player, play);
				System.out.println(player);
			}
			play.changeCurrentPlayer();
		} else {
			play.actionNotApplicable(player);
		}
	}
}
