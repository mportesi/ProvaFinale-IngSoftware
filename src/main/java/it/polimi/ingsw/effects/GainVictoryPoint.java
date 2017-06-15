package it.polimi.ingsw.effects;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.GC_40.Play;
import it.polimi.ingsw.GC_40.Player;

public class GainVictoryPoint extends Effect {
	int victoryPoint;
	
	
	public GainVictoryPoint(int costImmediateEffect){
		this.victoryPoint=costImmediateEffect;
	}

	@Override
	public void apply(Player player, Play play) throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException{
			player.incrementVictoryPoint(victoryPoint, play);

	}
	

	@Override
	public String toString(){
		return ("Effect: gain " + victoryPoint + " victoryPoint"  );
	}

}