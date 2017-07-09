package it.polimi.ingsw.effects;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.GC_40.Play;
import it.polimi.ingsw.GC_40.Player;

/**
 * @author Chiara
 * This class represents the effect of gaining the bonus associated to a building card.
 *
 */

public class GainBuildCardBonus extends Effect {
	int buildBonus;
	
	public GainBuildCardBonus(int buildBonus){
		this.buildBonus=buildBonus;
	}


	@Override
	public void apply(Player player, Play play) throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		player.addBuildCardBonus(buildBonus, play);

	}
	
	@Override
	public String toString(){
		return ("Permanent Effect: gain " + buildBonus + " bonus on Building card Action"  );
	}

}