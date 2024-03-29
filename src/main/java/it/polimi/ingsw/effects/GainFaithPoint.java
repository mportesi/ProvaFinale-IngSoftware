package it.polimi.ingsw.effects;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.GC_40.Play;
import it.polimi.ingsw.GC_40.Player;

/**
 * @author Chiara
 * This class represents the effect of gaining faith point.
 *
 */

public class GainFaithPoint extends Effect {
	int faithPoint;
	
	public GainFaithPoint(int faithPoint){
		this.faithPoint=faithPoint;
	}


	@Override
	public void apply(Player player, Play play) throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		player.incrementFaithPoint(faithPoint, play);

	}
	
	@Override
	public String toString(){
		return ("Effect: gain " + faithPoint + " faithPoint"  );
	}

}