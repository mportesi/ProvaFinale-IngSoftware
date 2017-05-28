package Effects;

import it.polimi.ingsw.GC_40.Player;

public class GainVictoryPointForTerritoryCard extends Effect {
	int victoryPoint;
	
	public GainVictoryPointForTerritoryCard(int victoryPoint){
		this.victoryPoint=victoryPoint;
	}

	@Override
	public void apply(Player player) {
		int counter=player.counter("territoryCard");
		player.incrementVictoryPoint(victoryPoint*counter);

	}

}
