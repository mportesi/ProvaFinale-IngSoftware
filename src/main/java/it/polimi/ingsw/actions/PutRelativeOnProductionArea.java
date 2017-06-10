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
import it.polimi.ingsw.changes.ChangeProductionLeftArea;
import it.polimi.ingsw.changes.ChangeProductionRightArea;
import it.polimi.ingsw.components.Relative;
import it.polimi.ingsw.effects.GainProductionValue;


public class PutRelativeOnProductionArea extends Observable<Change> implements PutRelative {
	Relative relative;
	HarvestAndProductionArea productionArea;
	Player player;
	String area; 

	public PutRelativeOnProductionArea(Player player, Relative relative, String area){
		this.player = player;
		this.relative=relative;
		this.area = area;
	}
	
	@Override
	public boolean isApplicable() {
		
		switch (area){
		case "left" : {
			if (relative.getValue() >= productionArea.getValueOfLeftArea() && productionArea.getLeftRelative() == null && (!(productionArea.isAlreadyPresent(player)) || relative.getColor() == null)) {
			return true;
		} break;
		}
			
		
		
		case "right" : {

			if (relative.getValue() >= productionArea.getValueOfRightArea() && (!(productionArea.isAlreadyPresent(player)) || relative.getColor() == null)){
				return true;
			} break;
			}
		
		}
		return false;
	}


	@Override
	public void apply(Play play) throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		if (isApplicable()) {
			// If the left position is free, the player put the relative there.
			if (area == "left") {
				productionArea.setLeftRelative(relative);
				ChangeProductionLeftArea changeProductionLeftArea= new ChangeProductionLeftArea(relative);
				this.notifyObserver(changeProductionLeftArea);
				GainProductionValue gainProductionValue = new GainProductionValue(relative.getValue()); 
				gainProductionValue.apply(player);
			}
			// Else he put the relative on the other side with the penalty
			else {
				productionArea.setRightRelative(relative);
				ChangeProductionRightArea changeProductionRightArea= new ChangeProductionRightArea(relative);
				this.notifyObserver(changeProductionRightArea);
				int malus = play.getBoard().getHarvestArea().getMalus();
				relative.setValue(-malus);
				int newValue= relative.getValue();
				GainProductionValue gainProductionValue = new GainProductionValue(newValue); 
				gainProductionValue.apply(player);
			}
		}
	}

	
	
	
}
