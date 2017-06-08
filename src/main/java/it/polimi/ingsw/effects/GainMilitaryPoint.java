package it.polimi.ingsw.effects;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.GC_40.Player;

public class GainMilitaryPoint extends Effect {
	int militaryPoint;
	
	public GainMilitaryPoint(int costImmediateEffect){
		this.militaryPoint=costImmediateEffect;
	}

	@Override
	public void apply(Player player) throws FileNotFoundException, NullPointerException, IOException, ParseException {
		// TODO Auto-generated method stub7
		player.incrementMilitaryPoint(militaryPoint);

	}

}