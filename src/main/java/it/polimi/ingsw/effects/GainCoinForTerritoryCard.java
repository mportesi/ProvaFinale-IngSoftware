package it.polimi.ingsw.effects;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.GC_40.Play;
import it.polimi.ingsw.GC_40.Player;
import it.polimi.ingsw.cards.BuildingCard;
import it.polimi.ingsw.cards.TerritoryCard;

public class GainCoinForTerritoryCard extends Effect {
	int coin;
	
	
	public GainCoinForTerritoryCard(int costImmediateEffect){
		this.coin=costImmediateEffect;
	}

	@Override
	public void apply(Player player, Play play) throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		TerritoryCard terryìitoryCard;
		int counter= player.counter("territoryCard");
		player.incrementCoin(coin*counter, play);

	}
	

	@Override
	public String toString(){
		return ("Effect: gain " + coin + " coinForTerritoryCard"  );
	}

}
