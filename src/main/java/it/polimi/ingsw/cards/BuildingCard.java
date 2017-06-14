package it.polimi.ingsw.cards;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.GC_40.Player;
import it.polimi.ingsw.effects.Effect;

public class BuildingCard extends Card {
	

	private Map<String, Integer> cost;
	private BuildingListOfEffect effects;
	private ArrayList<Effect> immediateEffects;
	
	public BuildingCard(String type, String name, int period, Map<String, Integer> cost, BuildingListOfEffect effects) throws FileNotFoundException, IOException, ParseException {
		super(type, name, period);
		this.cost=cost;
		this.effects=effects;
		immediateEffects = effects.createListOfEffect();
	}
	
	
	@Override
	public void payCost(Player player) throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException{
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
	
	// to apply immediate effects
		public void applyEffect(Player player) throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
				immediateEffects=effects.createListOfEffect();
				System.out.println("Gli effetti della carta sono: "+ immediateEffects);
			for (Effect e : immediateEffects) {
				if (e != null) {
					e.apply(player);
				} 
					return;
				}
			}
		

		@Override
		public String toString(){
			return (name + ":\n The cost is " + cost + "\n The immediate effects are " + immediateEffects );
		}
		
		public int getCostCoin(){
			return cost.get("coin");
		}
		public int getCostWood(){
			return cost.get("wood");
		}
		public int getCostStone(){
			return cost.get("stone");
		}
		public int getCostServant(){
			return cost.get("servant");
		}
}