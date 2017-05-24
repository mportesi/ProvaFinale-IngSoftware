package Effects;

public class GainVictoryPointForTerritoryCard extends Effect {
	Long victoryPoint;
	
	public GainVictoryPointForTerritoryCard(Long victoryPoint){
		this.victoryPoint=victoryPoint;
	}

	@Override
	public void apply() {
		// TODO Auto-generated method stub
		counter=player.counter(TerritoryCard);
		player.incrementVictoryPoint(victoryPoint*counter);

	}

}
