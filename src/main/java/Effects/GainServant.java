package Effects;

import it.polimi.ingsw.GC_40.Player;

public class GainServant extends Effect {
	int servant;
	
	public GainServant(int costImmediateEffect){
		this.servant=costImmediateEffect;
	}
	

	@Override
	public void apply(Player player) {
		// TODO Auto-generated method stub
		player.incrementServant(servant);
		

	}

}
