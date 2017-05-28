package Effects;

import Components.Card;
import Components.VentureCard;
import it.polimi.ingsw.GC_40.Player;

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
