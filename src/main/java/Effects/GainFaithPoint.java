package Effects;

import it.polimi.ingsw.GC_40.Player;

public class GainFaithPoint extends Effect {
	Long faithPoint;
	
	public GainFaithPoint(Long faithPoint){
		this.faithPoint=faithPoint;
	}


	@Override
	public void apply(Player player) {
		// TODO Auto-generated method stub
		player.incrementFaithPoint(faithPoint);

	}

}