package it.polimi.ingsw.effects;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.GC_40.Player;

public class GainServant extends Effect {
	int servant;
	
	public GainServant(int costImmediateEffect){
		this.servant=costImmediateEffect;
	}
	

	@Override
	public void apply(Player player) throws FileNotFoundException, NullPointerException, IOException, ParseException {
		// TODO Auto-generated method stub
		player.incrementServant(servant);
		

	}

}
