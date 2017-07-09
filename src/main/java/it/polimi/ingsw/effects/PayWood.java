package it.polimi.ingsw.effects;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.GC_40.Play;
import it.polimi.ingsw.GC_40.Player;

public class PayWood extends Effect{
	
	int wood;
	
	public PayWood(int amount){
		wood=amount;
	}

	@Override
	public void apply(Player player, Play play)
			throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		player.decrementWood(wood, play);
		
	}
	
	@Override
	public boolean isApplicable(Player player){
		if(player.getWood()>= wood){
			return true;
		}
		else{
			return false;
		}
	}

}
