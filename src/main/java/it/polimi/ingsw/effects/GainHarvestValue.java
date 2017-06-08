package it.polimi.ingsw.effects;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.GC_40.Player;

public class GainHarvestValue extends Effect {
	int harvestValue;
	
	public GainHarvestValue(int harvestValue){
		this.harvestValue=harvestValue;
	}

	@Override
	public void apply(Player player) throws FileNotFoundException, NullPointerException, IOException, ParseException {
		//attiva gli effetti permanenti con valore tot
		if (harvestValue >= player.personalBonusTile.getCostHarvest()){
		player.personalBonusTile.applyHarvestEffect(player);		

	}
	}

}
