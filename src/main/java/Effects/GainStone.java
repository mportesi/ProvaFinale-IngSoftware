package Effects;

import it.polimi.ingsw.GC_40.Player;

public class GainStone extends Effect {
	int stone;

	@Override
	public void apply() {
		// TODO Auto-generated method stub
		Player.incrementStone(stone);

	}

}
