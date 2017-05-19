package it.polimi.ingsw.GC_40;

public class GainVictoryPoint extends Effect {
	int victoryPoint;

	@Override
	public void apply(){
		// TODO Auto-generated method stub
		Player.incrementVictoryPoint(victoryPoint);

	}

}
