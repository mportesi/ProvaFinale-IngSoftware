package it.polimi.ingsw.actions;

import it.polimi.ingsw.GC_40.Board;
import it.polimi.ingsw.GC_40.Observable;
import it.polimi.ingsw.GC_40.Player;
import it.polimi.ingsw.areas.HarvestAndProductionArea;
import it.polimi.ingsw.changes.Change;
import it.polimi.ingsw.changes.ChangeHarvestLeftArea;
import it.polimi.ingsw.changes.ChangeHarvestRightArea;
import it.polimi.ingsw.components.Relative;
import it.polimi.ingsw.effects.GainHarvestValue;
import it.polimi.ingsw.effects.GainProductionValue;

public class PutRelativeOnHarvestArea extends Observable<Change> implements PutRelative{

	Relative relative;
	HarvestAndProductionArea harvestArea;
	Player player;
	String area; 

	public PutRelativeOnHarvestArea(Player player, Relative relative, String area){
		this.player = player;
		this.relative=relative;
		this.area = area;
	}
	
	@Override
	public boolean isApplicable() {
		
		switch (area){
		case "left" : {
			if (relative.getValue() >= harvestArea.getValueOfLeftArea() && harvestArea.getLeftRelative() == null && (!(harvestArea.isAlreadyPresent(player)) || relative.getColor() == null)) {
			return true;
		} break;
		}
			
		
		
		case "right" : {

			if (relative.getValue() >= harvestArea.getValueOfRightArea() && (!(harvestArea.isAlreadyPresent(player)) || relative.getColor() == null)){
				return true;
			} break;
			}
		
		}
		return false;
	}


	@Override
	public void apply() {
		if (isApplicable()) {
			// If the left position is free, the player put the relative there.
			if (area == "left") {
				harvestArea.setLeftRelative(relative);
				ChangeHarvestLeftArea changeHarvestLeftArea= new ChangeHarvestLeftArea(relative);
				this.notifyObserver(changeHarvestLeftArea);
				GainHarvestValue gainHarvestValue = new GainHarvestValue(relative.getValue()); 
				gainHarvestValue.apply(player);
				
			}
			// Else he put the relative on the other side with the penalty
			else {
				harvestArea.setRightRelative(relative);
				ChangeHarvestRightArea changeHarvestRightArea= new ChangeHarvestRightArea(relative);
				this.notifyObserver(changeHarvestRightArea);
				int malus = Board.harvestArea.getMalus();
				relative.setValue(-malus);
				int newValue= relative.getValue();
				GainHarvestValue gainHarvestValue = new GainHarvestValue(newValue); 
				gainHarvestValue.apply(player);
			}
		}
	}

}
