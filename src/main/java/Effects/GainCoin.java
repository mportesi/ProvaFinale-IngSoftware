package Effects;

import it.polimi.ingsw.GC_40.Player;

public class GainCoin extends Effect {
	Long coin;
	
	public GainCoin(Long coin){
		this.coin=coin;
	}

	@Override
	public void apply(Player player) {
		// TODO Auto-generated method stub
		player.incrementCoin(coin);
	}

}