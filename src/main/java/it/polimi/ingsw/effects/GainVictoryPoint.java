package it.polimi.ingsw.effects;

import it.polimi.ingsw.GC_40.Player;

public class GainVictoryPoint extends Effect {
	int victoryPoint;
	
	
	public GainVictoryPoint(int costImmediateEffect){
		this.victoryPoint=costImmediateEffect;
	}

	@Override
	public void apply(Player player){
		// TODO Auto-generated method stub
			player.incrementVictoryPoint(victoryPoint);

	}

}