package Components;

import java.util.Map;

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
	
}
