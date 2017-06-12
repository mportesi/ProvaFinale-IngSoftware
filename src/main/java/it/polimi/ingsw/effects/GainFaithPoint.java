package it.polimi.ingsw.effects;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.GC_40.Player;

public class GainFaithPoint extends Effect {
	int faithPoint;
	
	public GainFaithPoint(int faithPoint){
		this.faithPoint=faithPoint;
	}


	@Override
	public void apply(Player player) throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		// TODO Auto-generated method stub
		player.incrementFaithPoint(faithPoint);

	}
	
	@Override
	public String toString(){
		return ("Effect: gain " + faithPoint + " faithPoint"  );
	}

}