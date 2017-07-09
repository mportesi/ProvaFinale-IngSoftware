package it.polimi.ingsw.cards;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.effects.Effect;
import it.polimi.ingsw.effects.GainFaithPoint;
import it.polimi.ingsw.effects.GainVictoryPoint;

/**
 * @author Sara
 * This is an auxiliary class to build the different effects of the cards based on external files json.
 */
public class BuildingListOfEffect extends CreateListOfEffect {

	
	public BuildingListOfEffect(Map<String, Integer> immediateEffect) {
		super(immediateEffect);
	}

	/**
	 * @author Sara
	 * This method create the effects for a building card when it is called.
	 * It assign the different effect that a specific card has.
	 * The building cards can have only two different types of effects that are gain faith points or victory points.
	 */
	public ArrayList<Effect> createListOfEffect() throws FileNotFoundException, IOException, ParseException {
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
