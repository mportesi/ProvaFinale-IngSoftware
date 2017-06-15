package it.polimi.ingsw.effects;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.GC_40.Play;
import it.polimi.ingsw.GC_40.Player;

public class GainStone extends Effect {
	int stone;
	
	public GainStone(int costImmediateEffect){
		this.stone=costImmediateEffect;
	}

	@Override
	public void apply(Player player, Play play) throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException{
		player.incrementStone(stone, play);

	}
	

	@Override
	public String toString(){
		return ("Effect: gain " + stone + " stone"  );
	}

}