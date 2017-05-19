package it.polimi.ingsw.GC_40;

public class GainServant extends Effect {
	int servant;

	@Override
	public void apply() {
		// TODO Auto-generated method stub
		Player.incrementServant(servant);
		

	}

}
