package it.polimi.ingsw.effects;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.GC_40.Play;
import it.polimi.ingsw.GC_40.Player;

public class PayFaith extends Effect{
	
	int faith;
	
	public PayFaith(int amount){
		faith=amount;
	}

	@Override
	public void apply(Player player, Play play)
			throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		player.decrementFaithPoint(faith, play);
	}

	@Override
	public boolean isApplicable(Player player){
		if(player.getFaithPoint()>=faith){
			return true;
		}
		else{
			return false;
		}
	}
}
