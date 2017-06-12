package it.polimi.ingsw.effects;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.GC_40.Player;

public class GainCoin extends Effect {
	int coin;
	
	public GainCoin(int costImmediateEffect){
		this.coin=costImmediateEffect;
	}

	@Override
	public void apply(Player player) throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		player.incrementCoin(coin);
	}

	@Override
	public String toString(){
		return ("Effect: gain " + coin + " coin"  );
	}

	

}