package it.polimi.ingsw.components;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import it.polimi.ingsw.GC_40.Player;
import it.polimi.ingsw.effects.Effect;
import it.polimi.ingsw.effects.GainCoin;
import it.polimi.ingsw.effects.GainFaithPoint;
import it.polimi.ingsw.effects.GainMilitaryPoint;
import it.polimi.ingsw.effects.GainServant;
import it.polimi.ingsw.effects.GainStone;
import it.polimi.ingsw.effects.GainVictoryPoint;
import it.polimi.ingsw.effects.GainVictoryPointForBuildingCard;
import it.polimi.ingsw.effects.GainVictoryPointForCharacterCard;
import it.polimi.ingsw.effects.GainVictoryPointForMilitaryPoint;
import it.polimi.ingsw.effects.GainVictoryPointForTerritoryCard;
import it.polimi.ingsw.effects.GainVictoryPointForVentureCard;
import it.polimi.ingsw.effects.GainWood;


public class PersonalBonusTile{
	private String type;
	private List <Effect> productionEffect;
	private List <Effect> harvestEffect;
	private Map<String, Integer> productionEffectMap;
	private Map<String, Integer> harvestEffectMap;
	private int costProduction;
	private int costHarvest;
	
	public PersonalBonusTile (String type, Map<String, Integer> productionEffectMap, Map<String, Integer> harvestEffectMap, int costProduction, int costHarvest){
		this.costProduction=costProduction;
		this.costHarvest=costHarvest;
		this.harvestEffectMap=harvestEffectMap;
		this.productionEffectMap=productionEffectMap;
	}
	
	public void createListOfProductionEffect(){
		productionEffect= new ArrayList<Effect>();
		List<String> keys = new ArrayList<String>();
		for (String key : productionEffectMap.keySet()) {
			keys.add(key);
		}
		for (int i = 0; i < keys.size(); i++) {
			String effect = keys.get(i);
			int costProductionEffect = productionEffectMap.get(effect);
			switch (effect) {
			case "GainCoin": {
				GainCoin gainCoin = new GainCoin(costProductionEffect);
				productionEffect.add(gainCoin);
				break;
			}
			
			case "GainWood": {
				GainWood gainWood = new GainWood(costProductionEffect);
				productionEffect.add(gainWood);
				break;
			}
			case "GainStone": {
				GainStone gainStone = new GainStone(costProductionEffect);
				productionEffect.add(gainStone);
				break;
			}
			case "GainServant": {
				GainServant gainServant = new GainServant(costProductionEffect);
				productionEffect.add(gainServant);
				break;
			}
			case "GainVictoryPoint": {
				GainVictoryPoint gainVictoryPoint = new GainVictoryPoint(costProductionEffect);
				productionEffect.add(gainVictoryPoint);
				break;
			}
			case "GainFaithPoint": {
				GainFaithPoint gainFaithPoint = new GainFaithPoint(costProductionEffect);
				productionEffect.add(gainFaithPoint);
				break;
			}
			case "GainMilitaryPoint": {
				GainMilitaryPoint gainMilitaryPoint = new GainMilitaryPoint(costProductionEffect);
				productionEffect.add(gainMilitaryPoint);
				break;
			}
			}
		}

		
	}
	
	public void createListOfHarvestEffect(){
		harvestEffect= new ArrayList<Effect>();
		List<String> keys = new ArrayList<String>();
		for (String key : harvestEffectMap.keySet()) {
			keys.add(key);
		}
		for (int i = 0; i < keys.size(); i++) {
			String effect = keys.get(i);
			int costHarvestEffect = harvestEffectMap.get(effect);
			switch (effect) {
			case "GainCoin": {
				GainCoin gainCoin = new GainCoin(costHarvestEffect);
				harvestEffect.add(gainCoin);
				break;
			}
			
			case "GainWood": {
				GainWood gainWood = new GainWood(costHarvestEffect);
				harvestEffect.add(gainWood);
				break;
			}
			case "GainStone": {
				GainStone gainStone = new GainStone(costHarvestEffect);
				harvestEffect.add(gainStone);
				break;
			}
			case "GainServant": {
				GainServant gainServant = new GainServant(costHarvestEffect);
				harvestEffect.add(gainServant);
				break;
			}
			case "GainVictoryPoint": {
				GainVictoryPoint gainVictoryPoint = new GainVictoryPoint(costHarvestEffect);
				harvestEffect.add(gainVictoryPoint);
				break;
			}
			case "GainFaithPoint": {
				GainFaithPoint gainFaithPoint = new GainFaithPoint(costHarvestEffect);
				harvestEffect.add(gainFaithPoint);
				break;
			}
			case "GainMilitaryPoint": {
				GainMilitaryPoint gainMilitaryPoint = new GainMilitaryPoint(costHarvestEffect);
				harvestEffect.add(gainMilitaryPoint);
				break;
			}
			}
		}

		

		
	}
	
	
	
	
	public void applyProductionEffect(Player player) {
		createListOfProductionEffect();

		for (Effect e : productionEffect) {
			if (e != null) {
				e.apply(player);
			} else {
				return;
			}
		}
	}
	
	public void applyHarvestEffect(Player player) {
		createListOfHarvestEffect();

		for (Effect e : harvestEffect) {
			if (e != null) {
				e.apply(player);
			} else {
				return;
			}
		}
	}
	
	

}
