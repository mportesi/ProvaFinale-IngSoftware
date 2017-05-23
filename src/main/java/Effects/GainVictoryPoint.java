package Effects;

import it.polimi.ingsw.GC_40.Player;

public class GainVictoryPoint extends Effect {
	int victoryPoint;

	@Override
	public void apply(){
		// TODO Auto-generated method stub
		Player.incrementVictoryPoint(victoryPoint);

	}

}
