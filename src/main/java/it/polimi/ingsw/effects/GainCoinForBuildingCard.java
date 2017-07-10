package it.polimi.ingsw.effects;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.GC_40.Play;
import it.polimi.ingsw.GC_40.Player;
import it.polimi.ingsw.cards.BuildingCard;

public class GainCoinForBuildingCard extends Effect {
	int coin;
	
	
	public GainCoinForBuildingCard(int costImmediateEffect){
		this.coin=costImmediateEffect;
	}

	@Override
	public void apply(Player player, Play play) throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		BuildingCard buildingCard;
		int counter= player.counter("buildingCard");
		player.incrementCoin(coin*counter, play);

	}
	

	@Override
	public String toString(){
		return ("Effect: gain " + coin + " coinForBuildingCard"  );
	}

}

