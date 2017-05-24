package Effects;

public class GainVictoryPointForBuildingCard extends Effect {
	Long victoryPoint;
	
	
	public GainVictoryPointForBuildingCard(Long victoryPoint){
		this.victoryPoint=victoryPoint;
	}

	@Override
	public void apply(Player player) {
		// TODO Auto-generated method stub
		int counter= player.counter(BuildingCard);
		player.incrementVictoryPoint(victoryPoint*counter);

	}

}
