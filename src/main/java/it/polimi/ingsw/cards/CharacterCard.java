package it.polimi.ingsw.cards;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import it.polimi.ingsw.GC_40.Player;
import it.polimi.ingsw.effects.Effect;
import it.polimi.ingsw.effects.GainCoin;
import it.polimi.ingsw.effects.GainStone;
import it.polimi.ingsw.effects.GainVictoryPoint;
import it.polimi.ingsw.effects.GainWood;

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
	
	@Override
	public void payCost(Player player){
		player.decrementCoin(costCoin);
	}

}