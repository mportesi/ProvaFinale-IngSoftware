package Effects;

import it.polimi.ingsw.GC_40.Player;

public class GainMilitaryPoint extends Effect {
	Long militaryPoint;
	
	public GainMilitaryPoint(Long militaryPoint){
		this.militaryPoint=militaryPoint;
	}

	@Override
	public void apply(Player player) {
		// TODO Auto-generated method stub7
		player.incrementMilitaryPoint(militaryPoint);

	}

}