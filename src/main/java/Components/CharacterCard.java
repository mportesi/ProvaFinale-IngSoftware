package Components;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import Effects.Effect;
import Effects.GainCoin;
import Effects.GainStone;
import Effects.GainVictoryPoint;
import Effects.GainWood;

public class CharacterCard extends Card {
	public Long costCoin;
	public String conditionToGain;
	
	public CharacterCard(String type,String name,Long period,Long costCoin,String conditionToGain, Map<String, Long> immediateEffect){
		this.type=type;
		this.name=name;
		this.costCoin=costCoin;
		this.conditionToGain=conditionToGain;
		this.immediateEffect=immediateEffect;
	}
	

	

}