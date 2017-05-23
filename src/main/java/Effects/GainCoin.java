package Effects;

import it.polimi.ingsw.GC_40.Player;

public class GainCoin extends Effect {
	int coin;

	@Override
	public void apply(Player player) {
		// TODO Auto-generated method stub
		player.incrementCoin(coin);
	}

}
