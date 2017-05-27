package Effects;

public class GainVictoryPointForTerritoryCard extends Effect {
	int victoryPoint;
	
	public GainVictoryPointForTerritoryCard(int victoryPoint){
		this.victoryPoint=victoryPoint;
	}

	@Override
	public void apply(Player player) {
		// TODO Auto-generated method stub
		counter=player.counter(TerritoryCard);
		player.incrementVictoryPoint(victoryPoint*counter);

	}

}
