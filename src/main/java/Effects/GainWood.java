package Effects;

import it.polimi.ingsw.GC_40.Player;

public class GainWood extends Effect {
	int wood;

	@Override
	public void apply() {
		// TODO Auto-generated method stub
		Player.incrementWood(wood);

	}
	

}