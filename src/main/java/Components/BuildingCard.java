package Components;

import java.util.Map;

import it.polimi.ingsw.GC_40.Player;

public class BuildingCard extends Card {
	public Map<String, Integer> cost;
	
	public BuildingCard(String type,String name,int period,Map<String, Integer>cost,Map<String, Integer> immediateEffect){
		this.type=type;
		this.name=name;
		this.cost=cost;
		this.immediateEffect=immediateEffect;
	}
	
	@Override
	public void payCost(Player player){
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
			}
		}
	}

}