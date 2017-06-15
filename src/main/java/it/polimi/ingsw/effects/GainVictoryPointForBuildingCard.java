
package it.polimi.ingsw.effects;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.GC_40.Play;
import it.polimi.ingsw.GC_40.Player;
import it.polimi.ingsw.cards.BuildingCard;

public class GainVictoryPointForBuildingCard extends Effect {
	int victoryPoint;
	
	
	public GainVictoryPointForBuildingCard(int costImmediateEffect){
		this.victoryPoint=costImmediateEffect;
	}

	@Override
	public void apply(Player player, Play play) throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		BuildingCard buildingCard;
		int counter= player.counter("buildingCard");
		player.incrementVictoryPoint(victoryPoint*counter, play);

	}
	

	@Override
	public String toString(){
		return ("Effect: gain " + victoryPoint + " victoryPointForBuildingCard"  );
	}

}
