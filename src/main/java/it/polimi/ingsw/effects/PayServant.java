package it.polimi.ingsw.effects;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.GC_40.Play;
import it.polimi.ingsw.GC_40.Player;

/**
 * @author Chiara
 * This class represents the effect of paying servants.
 *
 */

public class PayServant extends Effect{
	
	int servant;
	
	public PayServant(int amount){
		servant=amount;
	}

	@Override
	public void apply(Player player, Play play)
			throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		player.decrementServant(servant, play);
		
	}

	@Override
	public boolean isApplicable(Player player){
		if(player.getServant()>=servant){
			return true;
		}
		else{
			return false;
		}
	}
	@Override
	public String toString(){
		return (" Pay " + servant + " servant"  );
	}
}
