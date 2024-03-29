package it.polimi.ingsw.effects;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.GC_40.Play;
import it.polimi.ingsw.GC_40.Player;

/**
 * @author Chiara
 * This class represents the effect of gaining victory points for the character that the player has.
 *
 */

public class GainVictoryPointForCharacterCard extends Effect {
	int victoryPoint;
	
	
	public GainVictoryPointForCharacterCard(int costImmediateEffect){
		this.victoryPoint=costImmediateEffect;
	}
	@Override
	public void apply(Player player, Play play) throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		int counter= player.counter("characterCard");
		player.incrementVictoryPoint(victoryPoint*counter, play);

	}
	

	@Override
	public String toString(){
		return ("Effect: gain " + victoryPoint + " victoryPointForCharacterCard"  );
	}
}
