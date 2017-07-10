package it.polimi.ingsw.effects;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.GC_40.Play;
import it.polimi.ingsw.GC_40.Player;

/**
 * @author Chiara
 * This class represents the effect of paying coin.
 *
 */

public class PayCoin extends Effect{
	
	int coin;
	
	public PayCoin(int amount){
		coin=amount;
	}
	@Override
	public void apply(Player player, Play play)
			throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		player.decrementCoin(coin, play);
	}
	
	@Override
	public boolean isApplicable(Player player){
		if(player.getCoin()>= coin){
			return true;
		}
		else{
			return false;
		}
	}
	@Override
	public String toString(){
		return (" Pay " + coin + " coin"  );
	}

}
