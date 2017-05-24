package Effects;

public class GainVictoryPointForVentureCard extends Effect {
Long victoryPoint;
	
	
	public GainVictoryPointForVentureCard(Long victoryPoint){
		this.victoryPoint=victoryPoint;
	}

	@Override
	public void apply() {
		// TODO Auto-generated method stub
		int counter= player.counter(VentureCard);
		player.incrementVictoryPoint(victoryPoint*counter);

	}

}
