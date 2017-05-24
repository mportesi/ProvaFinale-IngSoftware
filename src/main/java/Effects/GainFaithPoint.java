package Effects;

import it.polimi.ingsw.GC_40.Player;

public class GainFaithPoint extends Effect {
	Long faithPoint;
	
	public GainFaithPoint(Long faithPoint){
		this.faithPoint=faithPoint;
	}


	@Override
	public void apply() {
		// TODO Auto-generated method stub
		Player.incrementFaithPoint(faithPoint);

	}

}