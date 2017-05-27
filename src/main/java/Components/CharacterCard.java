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
	public int costCoin;
	
	public CharacterCard(String type,String name,int period,int costCoin, Map<String, Integer> immediateEffect){
		this.type=type;
		this.name=name;
		this.costCoin=costCoin;
		this.immediateEffect=immediateEffect;
	}
	

	

}