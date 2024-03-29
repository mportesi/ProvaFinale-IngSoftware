package it.polimi.ingsw.effects;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.GC_40.Play;
import it.polimi.ingsw.GC_40.Player;

/**
 * @author Chiara
 * This class represents the effect of gaining victory points for the territory cards that the player has.
 *
 */
public class GainVictoryPointForTerritoryCard extends Effect {
	int victoryPoint;
	
	public GainVictoryPointForTerritoryCard(int victoryPoint){
		this.victoryPoint=victoryPoint;
	}

	@Override
	public void apply(Player player, Play play) throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		int counter=player.counter("territoryCard");
		player.incrementVictoryPoint(victoryPoint*counter, play);

	}
	
	@Override
	public String toString(){
		return ("Effect: gain " + victoryPoint + " victoryPointForTerritoryCard"  );
	}
}
