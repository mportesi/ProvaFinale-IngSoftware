package it.polimi.ingsw.effects;

import it.polimi.ingsw.GC_40.Player;
import it.polimi.ingsw.cards.Card;
import it.polimi.ingsw.cards.VentureCard;

public class GainVictoryPointForVentureCard extends Effect {
int victoryPoint;
	
	
	public GainVictoryPointForVentureCard(int costImmediateEffect){
		this.victoryPoint=costImmediateEffect;
	}

	@Override
	public void apply(Player player) {
		int counter= player.counter("ventureCard");
		player.incrementVictoryPoint(victoryPoint*counter);

	}

}
