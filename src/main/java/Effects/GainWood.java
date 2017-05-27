package Effects;

import it.polimi.ingsw.GC_40.Player;

public class GainWood extends Effect {
	int wood;
	
	public GainWood(int costImmediateEffect){
		this.wood=costImmediateEffect;
	}

	@Override
	public void apply(Player player) {
		player.incrementWood(wood);

	}
	

}