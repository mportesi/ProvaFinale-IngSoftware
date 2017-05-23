package Effects;

import it.polimi.ingsw.GC_40.Player;

public class GainFaithPoint extends Effect {
	int faithPoint;

	@Override
	public void apply() {
		// TODO Auto-generated method stub
		Player.incrementFaithPoint(faithPoint);

	}

}
