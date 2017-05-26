package Components;

import java.util.Map;

public class VentureCard extends Card {
	private Long alternativeCostBoolean;
	private Map<String,Long> cost;
	private Long militaryRequirement;
	private Long militaryCost;
	
	public VentureCard(String type,String name,Long period,Map<String,Long> costMap,Long militaryRequirement,Long militaryCost,Map<String,Long> immediateEffectMap){
		this.type=type;
		this.name=name;
		this.period=period;
		this.cost=cost;
		this.militaryRequirement=militaryRequirement;
		this.militaryCost=militaryCost;
		this.immediateEffect=immediateEffect;
	};
	
	public VentureCard(String type,String name,Long period,Map<String,Long> cost, Map<String,Long> immediateEffect){
		this.type=type;
		this.name=name;
		this.period=period;
		this.cost=cost;
		this.immediateEffect=immediateEffect;
		militaryRequirement=(long) 0;
		militaryCost=(long) 0;
	}
	
	public VentureCard(String type,String name,Long period,Long militaryRequirement,Long militaryCost,Map<String,Long> cost, Map<String,Long> immediateEffectMap){
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
