package it.polimi.ingsw.effects;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.GC_40.Play;
import it.polimi.ingsw.GC_40.Player;

/**
 * @author Chiara
 * This class represents the effect of paying stones.
 *
 */

public class PayStone extends Effect{

	int stone;
	
	public PayStone(int amount){
		stone=amount;
	}
	
	@Override
	public void apply(Player player, Play play)
			throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		player.decrementStone(stone, play);
	}
	
	@Override
	public boolean isApplicable(Player player){
		if(player.getStone()>=stone){
			return true;
		}
		else{
			return false;
		}
	}
	@Override
	public String toString(){
		return (" Pay " + stone + " stone"  );
	}

}
