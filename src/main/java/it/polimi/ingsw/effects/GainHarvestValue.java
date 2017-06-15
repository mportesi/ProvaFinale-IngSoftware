package it.polimi.ingsw.effects;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.GC_40.Play;
import it.polimi.ingsw.GC_40.Player;

public class GainHarvestValue extends Effect {
	int harvestValue;
	
	public GainHarvestValue(int harvestValue){
		this.harvestValue=harvestValue;
	}

	@Override
	public void apply(Player player, Play play) throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		//attiva gli effetti permanenti con valore tot
		System.out.println(player.getPersonalBonusTile());
		
		if (harvestValue >= player.getPersonalBonusTile().getCostHarvest()){
		player.getPersonalBonusTile().applyHarvestEffect(player, play);		
	}
	}
	
	@Override
	public String toString(){
		return ("Effect: gain " + harvestValue + " coin"  );
	}

}
