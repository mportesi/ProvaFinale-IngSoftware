package Effects;

import it.polimi.ingsw.GC_40.Player;

public class GainServant extends Effect {
	Long servant;
	
	public GainServant(Long servant){
		this.servant=servant;
	}
	

	@Override
	public void apply() {
		// TODO Auto-generated method stub
		Player.incrementServant(servant);
		

	}

}
