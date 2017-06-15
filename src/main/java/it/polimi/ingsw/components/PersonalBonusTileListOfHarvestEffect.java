package it.polimi.ingsw.components;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.cards.CreateListOfEffect;
import it.polimi.ingsw.effects.Effect;
import it.polimi.ingsw.effects.GainCoin;
import it.polimi.ingsw.effects.GainFaithPoint;
import it.polimi.ingsw.effects.GainMilitaryPoint;
import it.polimi.ingsw.effects.GainServant;
import it.polimi.ingsw.effects.GainStone;
import it.polimi.ingsw.effects.GainVictoryPoint;
import it.polimi.ingsw.effects.GainWood;

public class PersonalBonusTileListOfHarvestEffect extends CreateListOfEffect{
	
	public PersonalBonusTileListOfHarvestEffect(Map <String, Integer> immediateEffect){
		super(immediateEffect);
	}

	@Override
	public ArrayList<Effect> createListOfEffect() throws FileNotFoundException, IOException, ParseException {
		ArrayList <Effect> harvestEffect= new ArrayList<Effect>();
		List<String> keys = new ArrayList<String>();
		for (String key : immediateEffect.keySet()) {
			keys.add(key);
		}
		for (int i = 0; i < keys.size(); i++) {
			String effect = keys.get(i);
			int costHarvestEffect = immediateEffect.get(effect);
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
		return harvestEffect;
		}

}
