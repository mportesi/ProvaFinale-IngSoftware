package it.polimi.ingsw.actions;

import it.polimi.ingsw.GC_40.Player;
import it.polimi.ingsw.components.HarvestAndProductionArea;
import it.polimi.ingsw.components.Relative;
import it.polimi.ingsw.effects.GainProductionValue;

public class PutRelativeOnProductionArea implements PutRelative {
	Relative relative;
	HarvestAndProductionArea productionArea;
	Player player;
	
	public PutRelativeOnProductionArea(Player player, Relative relative){
		this.player=player;
		this.relative=relative;
	}

	@Override
	public boolean isApplicable() {
		if (relative.getValue() >= productionArea.getCost()) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void apply() {
		if (isApplicable()) {
			// If the left position is free, the player put the relative there.
			if (productionArea.getLeftPlayer() == null) {
				productionArea.setLeftPlayer(player);
				GainProductionValue gainProductionValue = new GainProductionValue(1); // ??
				gainProductionValue.apply(player);
			}
			// Else he put the relative on the other side with the penalty
			else {
				productionArea.setRightPlayer(player);
				GainProductionValue gainProductionValue = new GainProductionValue(-3);
				gainProductionValue.apply(player);
			}
		}

	}

}
