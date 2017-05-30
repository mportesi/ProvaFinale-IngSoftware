package it.polimi.ingsw.effects;

import it.polimi.ingsw.GC_40.Player;

public class GainVictoryPointForMilitaryPoint extends Effect {
	int victoryPoint;
	
	
	public GainVictoryPointForMilitaryPoint(int costImmediateEffect){
		this.victoryPoint=costImmediateEffect;
	}

	@Override
	public void apply(Player player) {
		// TODO Auto-generated method stub
		int counter=player.getMilitaryPoint();
		player.incrementVictoryPoint(victoryPoint*counter);

	}

}
