package Effects;

public class GainVictoryPointForCharacterCard extends Effect {
	Long victoryPoint;
	
	
	public GainVictoryPointForCharacterCard(Long victoryPoint){
		this.victoryPoint=victoryPoint;
	}
	@Override
	public void apply() {
		// TODO Auto-generated method stub
		int counter= player.counter(CharacterCard);
		player.incrementVictoryPoint(victoryPoint*counter);

	}

}
