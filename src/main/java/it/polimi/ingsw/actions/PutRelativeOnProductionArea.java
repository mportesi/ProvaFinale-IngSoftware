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
import it.polimi.ingsw.changes.ChangeProductionLeftArea;
import it.polimi.ingsw.changes.ChangeProductionRightArea;
import it.polimi.ingsw.components.Relative;
import it.polimi.ingsw.effects.GainProductionValue;


public class PutRelativeOnProductionArea extends Observable<Change> implements PutRelative {
	Relative relative;
	HarvestAndProductionArea productionArea;
	Player player;
	String area; 

	public PutRelativeOnProductionArea(Player player, Relative relative, HarvestAndProductionArea productionArea, String area){
		this.player = player;
		this.relative=relative;
		this.area = area;
		this.productionArea=productionArea;
	}
	
	@Override
	public boolean isApplicable() {
		
		switch (area){
		case "left" : {
			if (relative.getValue() >= productionArea.getValueOfLeftArea()) {
				if (productionArea.getLeftRelative() == null) {
					if ((!(productionArea.isAlreadyPresent(player)) || relative.getColor() == null)) {
						return true;
					}
				}
			}
			break;
		}
			
		
		
		case "right" : {
			if (relative.getValue() >= productionArea.getValueOfRightArea()) {
				if (!(productionArea.isAlreadyPresent(player)) || relative.getColor() == null) {
					return true;
				}
			}
			break;
			}
		
		}
		return false;
	}


	@Override
	public void apply(Play play) throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		if (isApplicable()) {
			// If the left position is free, the player put the relative there.
			if (area == "left") {
				productionArea.setLeftRelativeOnProduction(relative);
				play.notifyObserver(new ChangeProductionLeftArea(relative));
				player.setOccupiedRelative(relative);
				play.notifyObserver(new ChangeOccupiedRelative(player, relative));
				GainProductionValue gainProductionValue = new GainProductionValue(relative.getValue()); 
				gainProductionValue.apply(player, play);
				System.out.println(player);
			}
			// Else he put the relative on the other side with the penalty
			else {
				productionArea.setRightRelativeOnProduction(relative);
				play.notifyObserver(new ChangeProductionRightArea(relative));
				player.setOccupiedRelative(relative);
				play.notifyObserver(new ChangeOccupiedRelative(player, relative));
				int malus = play.getBoard().getHarvestArea().getMalus();
				relative.setValue(-malus);
				int newValue= relative.getValue();
				GainProductionValue gainProductionValue = new GainProductionValue(newValue); 
				gainProductionValue.apply(player, play);
				System.out.println(player);
			}
			play.changeCurrentPlayer();
		}
		else {
			play.actionNotApplicable(player);
		}
		return;
	}

	
	
	
}
