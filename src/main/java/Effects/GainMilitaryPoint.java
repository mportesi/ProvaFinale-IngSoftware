package Effects;

import it.polimi.ingsw.GC_40.Player;

public class GainMilitaryPoint extends Effect {
	int militaryPoint;

	@Override
	public void apply(Player player) {
		// TODO Auto-generated method stub7
		player.incrementMilitaryPoint(militaryPoint);

	}

}
