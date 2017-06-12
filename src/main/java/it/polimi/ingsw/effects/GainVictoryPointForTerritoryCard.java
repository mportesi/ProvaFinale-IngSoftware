package it.polimi.ingsw.effects;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.GC_40.Player;

public class GainVictoryPointForTerritoryCard extends Effect {
	int victoryPoint;
	
	public GainVictoryPointForTerritoryCard(int victoryPoint){
		this.victoryPoint=victoryPoint;
	}

	@Override
	public void apply(Player player) throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		int counter=player.counter("territoryCard");
		player.incrementVictoryPoint(victoryPoint*counter);

	}
	
	@Override
	public String toString(){
		return ("Effect: gain " + victoryPoint + " victoryPointForTerritoryCard"  );
	}
}
