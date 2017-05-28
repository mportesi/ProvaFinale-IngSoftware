package Effects;

import Components.BuildingCard;
import it.polimi.ingsw.GC_40.Player;

public class GainVictoryPointForBuildingCard extends Effect {
	int victoryPoint;
	
	
	public GainVictoryPointForBuildingCard(int costImmediateEffect){
		this.victoryPoint=costImmediateEffect;
	}

	@Override
	public void apply(Player player) {
		// TODO Auto-generated method stub
		BuildingCard buildingCard;
		int counter= player.counter("buildingCard");
		player.incrementVictoryPoint(victoryPoint*counter);

	}

}
