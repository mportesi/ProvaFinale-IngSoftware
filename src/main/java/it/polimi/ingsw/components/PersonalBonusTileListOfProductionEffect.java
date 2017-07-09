package it.polimi.ingsw.components;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import it.polimi.ingsw.cards.CreateListOfEffect;
import it.polimi.ingsw.effects.Effect;
import it.polimi.ingsw.effects.GainCoin;
import it.polimi.ingsw.effects.GainFaithPoint;
import it.polimi.ingsw.effects.GainMilitaryPoint;
import it.polimi.ingsw.effects.GainServant;
import it.polimi.ingsw.effects.GainStone;
import it.polimi.ingsw.effects.GainVictoryPoint;
import it.polimi.ingsw.effects.GainWood;

/**
 * @author Chiara
 * In this class are created the production effects of the personal bonus tile.
 *
 */

public class PersonalBonusTileListOfProductionEffect extends CreateListOfEffect{
	
	public PersonalBonusTileListOfProductionEffect(Map <String, Integer> immediateEffect){
		super(immediateEffect);
	}
	
	
	@Override
	public ArrayList <Effect> createListOfEffect(){
		ArrayList <Effect> productionEffect= new ArrayList<Effect>();
		List<String> keys = new ArrayList<String>();
		for (String key : immediateEffect.keySet()) {
			keys.add(key);
		}
		
		for (int i = 0; i < keys.size(); i++) {
			String effect = keys.get(i);
			int costProductionEffect = immediateEffect.get(effect);
			switch (effect) {
			case "coin": {
				GainCoin gainCoin = new GainCoin(costProductionEffect);
				productionEffect.add(gainCoin);
				break;
			}
			
			case "wood": {
				GainWood gainWood = new GainWood(costProductionEffect);
				productionEffect.add(gainWood);
				break;
			}
			case "stone": {
				GainStone gainStone = new GainStone(costProductionEffect);
				productionEffect.add(gainStone);
				break;
			}
			case "servant": {
				GainServant gainServant = new GainServant(costProductionEffect);
				productionEffect.add(gainServant);
				break;
			}
			case "victoryPoint": {
				GainVictoryPoint gainVictoryPoint = new GainVictoryPoint(costProductionEffect);
				productionEffect.add(gainVictoryPoint);
				break;
			}
			case "faithPoint": {
				GainFaithPoint gainFaithPoint = new GainFaithPoint(costProductionEffect);
				productionEffect.add(gainFaithPoint);
				break;
			}
			case "militaryPoint": {
				GainMilitaryPoint gainMilitaryPoint = new GainMilitaryPoint(costProductionEffect);
				productionEffect.add(gainMilitaryPoint);
				break;
			}
			}
			
		}
		return productionEffect;

		
	}

}
