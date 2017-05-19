package it.polimi.ingsw.GC_40;

public class GainMilitaryPoint extends Effect {
	int militaryPoint;

	@Override
	public void apply() {
		// TODO Auto-generated method stub7
		Player.incrementMilitaryPoint(militaryPoint);

	}

}
