package it.polimi.ingsw.actions;

import it.polimi.ingsw.GC_40.Player;
import it.polimi.ingsw.areas.HarvestAndProductionArea;
import it.polimi.ingsw.components.Relative;
import it.polimi.ingsw.effects.GainHarvestValue;
import it.polimi.ingsw.effects.GainProductionValue;

public class PutRelativeOnHarvestArea implements PutRelative {

	Relative relative;
	HarvestAndProductionArea harvestArea;
	Player player;

	public PutRelativeOnHarvestArea(Player player, Relative relative){
		this.player=player;
		this.relative=relative;
	}
	
	@Override
	public boolean isApplicable() {
		// ??
		if (relative.getValue() >= harvestArea.getCost()) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void apply() {
		if (isApplicable()) {
			// If the left position is free, the player put the relative there.
			if (harvestArea.getLeftPlayer() == null) {
				harvestArea.setLeftPlayer(player);
				GainHarvestValue gainHarvestValue = new GainHarvestValue(1); // ???
				gainHarvestValue.apply(player);
			}
			// Else he put the relative on the other side with the penalty
			else {
				harvestArea.setRightPlayer(player);
				GainHarvestValue gainHarvestValue = new GainHarvestValue(-3); // ???
				gainHarvestValue.apply(player);
			}
		}
	}

}
