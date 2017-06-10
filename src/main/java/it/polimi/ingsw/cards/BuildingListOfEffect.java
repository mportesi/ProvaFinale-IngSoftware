package it.polimi.ingsw.cards;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import it.polimi.ingsw.effects.Effect;
import it.polimi.ingsw.effects.GainFaithPoint;
import it.polimi.ingsw.effects.GainVictoryPoint;


public class BuildingListOfEffect extends CardListOfEffect {

	
	public BuildingListOfEffect(Map<String, Integer> immediateEffect) {
		super(immediateEffect);
	}

	public ArrayList<Effect> createListOfEffect() {
		ArrayList<Effect> immediateEffects = new ArrayList<Effect>();
		List<String> keys = new ArrayList<String>();
		for (String key : immediateEffect.keySet()) {
			keys.add(key);
		}
		
		for (int i = 0; i < keys.size(); i++) {
			String effect = keys.get(i);
			int costImmediateEffect = immediateEffect.get(effect);
			switch (effect) {
		
			case "GainFaithPoint": {
				GainFaithPoint gainFaithPoint = new GainFaithPoint(costImmediateEffect);
				immediateEffects.add(gainFaithPoint);
				break;
			}
			case "GainVictoryPoint": {
				GainVictoryPoint gainVictoryPoint = new GainVictoryPoint(costImmediateEffect);
				immediateEffects.add(gainVictoryPoint);
				break;
			}
			
			
			}
		}
		return immediateEffects;
	}

}
