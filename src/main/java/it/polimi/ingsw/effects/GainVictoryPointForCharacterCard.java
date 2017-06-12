package it.polimi.ingsw.effects;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.GC_40.Player;

public class GainVictoryPointForCharacterCard extends Effect {
	int victoryPoint;
	
	
	public GainVictoryPointForCharacterCard(int costImmediateEffect){
		this.victoryPoint=costImmediateEffect;
	}
	@Override
	public void apply(Player player) throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		int counter= player.counter("characterCard");
		player.incrementVictoryPoint(victoryPoint*counter);

	}
	

	@Override
	public String toString(){
		return ("Effect: gain " + victoryPoint + " victoryPointForCharacterCard"  );
	}
}
