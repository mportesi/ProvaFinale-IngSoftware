package Effects;

import it.polimi.ingsw.GC_40.Player;

public class GainFaithPoint extends Effect {
	int faithPoint;
	
	public GainFaithPoint(int faithPoint){
		this.faithPoint=faithPoint;
	}


	@Override
	public void apply(Player player) {
		// TODO Auto-generated method stub
		player.incrementFaithPoint(faithPoint);

	}

}