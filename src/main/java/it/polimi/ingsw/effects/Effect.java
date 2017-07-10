package it.polimi.ingsw.effects;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.GC_40.Play;
import it.polimi.ingsw.GC_40.Player;

/**
 * @author Chiara
 * This class represents the effects.
 *
 */

public abstract class Effect implements Serializable {
	

/**
 * @author Chiara
 * This method apply the effects on the player. Usually the effects consists in incrementing or decrementing some resources.
 *
 */
	
	public abstract void apply(Player player, Play play) throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException;

	/**
	 * @author Chiara
	 * This method checks if the player has enough resources to apply the effect.
	 *
	 */
	
	public boolean isApplicable(Player player) {
		return false;
	}


}
