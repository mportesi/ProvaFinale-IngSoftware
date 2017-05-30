package it.polimi.ingsw.cards;

import java.util.Map;

import it.polimi.ingsw.GC_40.Player;

public class VentureCard extends Card {
	private int alternativeCostBoolean;
	private Map<String,Integer> cost;
	private int militaryRequirement;
	private int militaryCost;
	
	public VentureCard(String type,String name,int period,Map<String,Integer> costMap,int militaryRequirement,int militaryCost,Map<String,Integer> immediateEffectMap){
		this.type=type;
		this.name=name;
		this.period=period;
		this.cost=cost;
		this.militaryRequirement=militaryRequirement;
		this.militaryCost=militaryCost;
		this.immediateEffect=immediateEffect;
	};
	
	public VentureCard(String type,String name,int period,Map<String,Integer> cost, Map<String,Integer> immediateEffect){
		this.type=type;
		this.name=name;
		this.period=period;
		this.cost=cost;
		this.immediateEffect=immediateEffect;
		militaryRequirement= 0;
		militaryCost=0;
	}
	
	public VentureCard(String type,String name,int period,int militaryRequirement,int militaryCost,Map<String,Integer> cost, Map<String,Integer> immediateEffectMap){
		this.type=type;
		this.name=name;
		this.period=period;
		this.militaryRequirement=militaryRequirement;
		this.militaryCost=militaryCost;
		this.cost=cost;
		this.immediateEffect=immediateEffect;
		cost=null;
	};
	
	@Override
	public void payCost(Player player){
		if (militaryRequirement==0 && militaryCost==0){
			for(String key: cost.keySet()){
				switch(key){
				case "coin":{
					player.decrementCoin(cost.get(key));
				}
				case "wood":{
					player.decrementWood(cost.get(key));
				}
				case "stone":{
					player.decrementStone(cost.get(key));
				}
				case "servant":{
					player.decrementServant(cost.get(key));
				}
				}
			}
		}
		else if(cost.isEmpty()){
			player.decrementMilitaryPoint(militaryCost);
		}
		else chooseCost(player);
	}
	
	//????
	public void chooseCost(Player player){
		return ;
	}
	
}
