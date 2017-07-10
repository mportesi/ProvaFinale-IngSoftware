package it.polimi.ingsw.effects;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.GC_40.Play;
import it.polimi.ingsw.GC_40.Player;

/**
 * @author Chiara
 * This class represents the effect of gaining the production bonus.
 *
 */

public class GainProductionBonus extends Effect {
	int productionBonus;
	
	public GainProductionBonus(int productionBonus){
		this.productionBonus=productionBonus;
	}


	@Override
	public void apply(Player player, Play play) throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		player.addProductionBonus(productionBonus, play);

	}
	
	@Override
	public String toString(){
		return ("Permanent Effect: gain " + productionBonus + " bonus on Production Action"  );
	}

}