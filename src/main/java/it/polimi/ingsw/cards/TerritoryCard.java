package it.polimi.ingsw.cards;

import java.util.Map;

public class TerritoryCard extends Card {
	
	public TerritoryCard(String type,String name,int period,Map<String, Integer> immediateEffect){
		this.type=type;
		this.name=name;
		this.immediateEffect=immediateEffect;
	}

}