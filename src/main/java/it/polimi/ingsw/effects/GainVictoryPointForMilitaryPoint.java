
package it.polimi.ingsw.effects;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.GC_40.Player;

public class GainVictoryPointForMilitaryPoint extends Effect {
	int victoryPoint;
	
	
	public GainVictoryPointForMilitaryPoint(int costImmediateEffect){
		this.victoryPoint=costImmediateEffect;
	}

	@Override
	public void apply(Player player) throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		// TODO Auto-generated method stub
		int counter=player.getMilitaryPoint();
		player.incrementVictoryPoint(victoryPoint*counter);

	}
	
	@Override
	public String toString(){
		return ("Effect: gain " + victoryPoint + " victoryPointForMilitaryPoint"  );
	}

}
