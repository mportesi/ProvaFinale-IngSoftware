package Effects;

import it.polimi.ingsw.GC_40.Player;

public class GainVictoryPoint extends Effect {
	Long victoryPoint;
	
	
	public GainVictoryPoint(Long victoryPoint){
		this.victoryPoint=victoryPoint;
	}

	@Override
	public void apply(Player player){
		// TODO Auto-generated method stub
			player.incrementVictoryPoint(victoryPoint);

	}

}