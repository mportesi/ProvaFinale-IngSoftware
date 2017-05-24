package Components;

import java.util.Map;

public class BuildingCard extends Card {
	public Map<String, Long> cost;
	
	public BuildingCard(String type,String name,Long period,Map<String, Long>cost,Map<String, Long> immediateEffect){
		this.type=type;
		this.name=name;
		this.cost=cost;
		this.immediateEffect=immediateEffect;
	}

}