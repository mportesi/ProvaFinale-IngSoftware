package it.polimi.ingsw.effects;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.GC_40.Play;
import it.polimi.ingsw.GC_40.Player;

/**
 * @author Chiara
 * This class represents the effect of gaining the harvest bonus.
 *
 */

public class GainHarvestBonus extends Effect {
	int harvestBonus;
	
	public GainHarvestBonus(int harvestBonus){
		this.harvestBonus=harvestBonus;
	}


	@Override
	public void apply(Player player, Play play) throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		player.addHarvestBonus(harvestBonus, play);

	}
	
	@Override
	public String toString(){
		return ("Permanent Effect: gain " + harvestBonus + " bonus on Harvest Action"  );
	}

}