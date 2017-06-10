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
	
	public BuildingCard(String type, String name, int period, Map<String, Integer> cost) {
		super(type, name, period);
		this.cost=cost;
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

			for (Effect e : immediateEffects) {
				if (e != null) {
					e.apply(player);
				} 
					return;
				}
			}
		

		@Override
		public String toString(){
			return (name + ": il costo è " + cost + " Gli effetti immediati sono " + immediateEffects );
		}
}