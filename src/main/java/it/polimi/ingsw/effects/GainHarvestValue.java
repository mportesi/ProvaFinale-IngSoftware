package it.polimi.ingsw.effects;

import it.polimi.ingsw.GC_40.Player;

public class GainHarvestValue extends Effect {
	int harvestValue;
	
	public GainHarvestValue(int harvestValue){
		this.harvestValue=harvestValue;
	}

	@Override
	public void apply(Player player) {
		player.personalBonusTile.applyHarvestEffect(player);		

	}

}
