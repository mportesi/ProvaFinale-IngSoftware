package it.polimi.ingsw.effects;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.GC_40.Play;
import it.polimi.ingsw.GC_40.Player;

/**
 * @author Chiara
 * This class represents the effect of gaining the production value.
 *
 */

public class GainProductionValue extends Effect {
	int productionValue;

	
	public GainProductionValue(int productionValue){
		this.productionValue=productionValue;
	}

	@Override
	public void apply(Player player, Play play) throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		if (productionValue >= player.getPersonalBonusTileSimple().getCostProduction()){
		player.getPersonalBonusTileSimple().applyProductionEffect(player, play);		

	}


	}
	

	@Override
	public String toString(){
		return ("Effect: gain " + productionValue + " productionValue"  );
	}

}
