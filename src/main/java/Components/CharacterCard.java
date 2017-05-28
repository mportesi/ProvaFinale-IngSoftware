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
	String card;
	int value;
	Map<String, Integer> discount;
	
	
	public CharacterCard(String type,String name,int period,int costCoin, Map<String, Integer> immediateEffect){
		this.type=type;
		this.name=name;
		this.costCoin=costCoin;
		this.immediateEffect=immediateEffect;
	}
	
	public CharacterCard(String type,String name,int period,int costCoin, String card, int value, Map<String,Integer> discount, Map<String, Integer> immediateEffect){
		this.type=type;
		this.name=name;
		this.costCoin=costCoin;
		this.card=card;
		this.value=value;
		this.discount=discount;
		this.immediateEffect=immediateEffect;
	}

	

}