package it.polimi.ingsw.effects;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.GC_40.Play;
import it.polimi.ingsw.GC_40.Player;

/**
 * @author Chiara
 * This class represents the effect of gaining the harvest value.
 *
 */

public class GainHarvestValue extends Effect {
	int harvestValue;
	
	public GainHarvestValue(int harvestValue){
		this.harvestValue=harvestValue;
	}

	@Override
	public void apply(Player player, Play play) throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		if (harvestValue >= player.getPersonalBonusTileSimple().getCostHarvest()){
		player.getPersonalBonusTileSimple().applyHarvestEffect(player, play);		
	}
	}
	
	@Override
	public String toString(){
		return ("Effect: gain " + harvestValue + " coin"  );
	}

}
