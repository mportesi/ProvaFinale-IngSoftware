package it.polimi.ingsw.actions;

<<<<<<< HEAD:src/main/java/Actions/PutRelativeOnProductionArea.java
import Components.Relative;
import Components.HarvestAndProductionArea;
import Effects.GainHarvestValue;
import Effects.GainProductionValue;
import it.polimi.ingsw.GC_40.Board;
=======
>>>>>>> Sara:src/main/java/it/polimi/ingsw/actions/PutRelativeOnProductionArea.java
import it.polimi.ingsw.GC_40.Player;
import it.polimi.ingsw.areas.HarvestAndProductionArea;
import it.polimi.ingsw.components.Relative;
import it.polimi.ingsw.effects.GainProductionValue;

<<<<<<< HEAD:src/main/java/Actions/PutRelativeOnProductionArea.java
public class PutRelativeOnProductionArea extends PutRelative {
	
=======
public class PutRelativeOnProductionArea implements PutRelative {
>>>>>>> Sara:src/main/java/it/polimi/ingsw/actions/PutRelativeOnProductionArea.java
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
	public void apply() {
		if (isApplicable()) {
			// If the left position is free, the player put the relative there.
			if (area == "left") {
				productionArea.setLeftRelative(relative);
				GainProductionValue gainProductionValue = new GainProductionValue(relative.getValue()); 
				gainProductionValue.apply(player);
			}
			// Else he put the relative on the other side with the penalty
			else {
				productionArea.setRightRelative(relative);
				int malus = Board.harvestArea.getMalus();
				relative.setValue(-malus);
				int newValue= relative.getValue();
				GainProductionValue gainProductionValue = new GainProductionValue(newValue); 
				gainProductionValue.apply(player);
			}
		}
	}

	
	
	
}
