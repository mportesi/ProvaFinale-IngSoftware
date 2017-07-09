package it.polimi.ingsw.effects;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.GC_40.Play;
import it.polimi.ingsw.GC_40.Player;

/**
 * @author Chiara
 * This class represents the effect of gaining militaryPoint.
 *
 */

public class GainMilitaryPoint extends Effect {
	int militaryPoint;
	
	public GainMilitaryPoint(int costImmediateEffect){
		this.militaryPoint=costImmediateEffect;
	}

	@Override
	public void apply(Player player, Play play) throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		player.incrementMilitaryPoint(militaryPoint, play);

	}
	

	@Override
	public String toString(){
		return ("Effect: gain " + militaryPoint + " militaryPoint"  );
	}

}