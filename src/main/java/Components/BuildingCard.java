package Components;

import java.util.Map;

public class BuildingCard extends Card {
	public Map<String, Integer> cost;
	
	public BuildingCard(String type,String name,int period,Map<String, Integer>cost,Map<String, Integer> immediateEffect){
		this.type=type;
		this.name=name;
		this.cost=cost;
		this.immediateEffect=immediateEffect;
	}
	

}