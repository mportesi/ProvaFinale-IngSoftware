package Effects;

import it.polimi.ingsw.GC_40.Player;

public class GainWood extends Effect {
	Long wood;
	
	public GainWood(Long wood){
		this.wood=wood;
	}

	@Override
	public void apply() {
		// TODO Auto-generated method stub
		player.incrementWood(wood);

	}
	

}