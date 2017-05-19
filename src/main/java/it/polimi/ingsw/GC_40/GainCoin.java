package it.polimi.ingsw.GC_40;

public class GainCoin extends Effect {
	int coin;

	@Override
	public void apply() {
		// TODO Auto-generated method stub
		player.incrementCoin(coin);
	}

}
