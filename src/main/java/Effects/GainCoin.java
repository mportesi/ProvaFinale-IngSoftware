package Effects;

import it.polimi.ingsw.GC_40.Player;

public class GainCoin extends Effect {
	int coin;
	
	public GainCoin(int costImmediateEffect){
		this.coin=costImmediateEffect;
	}

	@Override
	public void apply(Player player) {
		player.incrementCoin(coin);
	}

}