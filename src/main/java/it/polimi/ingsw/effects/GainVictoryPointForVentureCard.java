package it.polimi.ingsw.effects;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.GC_40.Play;
import it.polimi.ingsw.GC_40.Player;
import it.polimi.ingsw.cards.Card;
import it.polimi.ingsw.cards.VentureCard;

/**
 * @author Chiara
 * This class represents the effect of gaining victory points for the venture cards that the player has.
 *
 */

public class GainVictoryPointForVentureCard extends Effect {
int victoryPoint;
	
	
	public GainVictoryPointForVentureCard(int costImmediateEffect){
		this.victoryPoint=costImmediateEffect;
	}

	@Override
	public void apply(Player player, Play play) throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		int counter= player.counter("ventureCard");
		player.incrementVictoryPoint(victoryPoint*counter, play);

	}
	
	@Override
	public String toString(){
		return ("Effect: gain " + victoryPoint + " victoryPointForVentureCard"  );
	}
}
