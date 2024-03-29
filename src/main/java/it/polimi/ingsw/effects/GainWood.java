package it.polimi.ingsw.effects;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.GC_40.Play;
import it.polimi.ingsw.GC_40.Player;

/**
 * @author Chiara
 * This class represents the effect of gaining wood.
 *
 */

public class GainWood extends Effect {
	int wood;
	
	public GainWood(int costImmediateEffect){
		this.wood=costImmediateEffect;
	}

	@Override
	public void apply(Player player, Play play) throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		player.incrementWood(wood, play);

	}
	
	@Override
	public String toString(){
		return ("Effect: gain " + wood + " wood"  );
	}

}