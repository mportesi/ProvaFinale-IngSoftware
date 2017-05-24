package Effects;

public class GainVictoryPointForMilitaryPoint extends Effect {
	Long victoryPoint;
	
	
	public GainVictoryPointForMilitaryPoint(Long victoryPoint){
		this.victoryPoint=victoryPoint;
	}

	@Override
	public void apply(Player player) {
		// TODO Auto-generated method stub
		counter=player.getMilitaryPoint();
		player.incrementVictoryPoint(victoryPoint*counter);

	}

}
