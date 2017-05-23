package Effects;

public class GainVictoryPointForCard extends GainForSomething {
	int victoryPoint;
	
	@Override
	public void apply() {
		// TODO Auto-generated method stub
		
		player.incrementVictoryPoint(victoryPoint);

	}

}
