package Effects;

import it.polimi.ingsw.GC_40.Player;

public class GainVictoryPointForCharacterCard extends Effect {
	int victoryPoint;
	
	
	public GainVictoryPointForCharacterCard(int costImmediateEffect){
		this.victoryPoint=costImmediateEffect;
	}
	@Override
	public void apply(Player player) {
		int counter= player.counter("characterCard");
		player.incrementVictoryPoint(victoryPoint*counter);

	}
}
