package it.polimi.ingsw.GC_40;

public class GainStone extends Effect {
	int stone;

	@Override
	public void apply() {
		// TODO Auto-generated method stub
		Player.incrementStone(stone);

	}

}
