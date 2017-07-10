package it.polimi.ingsw.areas;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.cards.CreateListOfEffect;
import it.polimi.ingsw.effects.Effect;
import it.polimi.ingsw.effects.GainCoin;
import it.polimi.ingsw.effects.GainMilitaryPoint;
import it.polimi.ingsw.effects.GainPrivilegeCouncil;
import it.polimi.ingsw.effects.GainServant;

/**
 * @author Sara
 * This class is an auxiliary class that contains the method to create the effect for every market.
 * When it is called, it creates the different effect that will be apply on the player
 * based on the bonus of that market.
 */
public class MarketListOfEffect extends CreateListOfEffect {
	
	
	public MarketListOfEffect(Map <String, Integer> immediateEffect){
		super(immediateEffect);
	}

	@Override
	public ArrayList<Effect> createListOfEffect() throws FileNotFoundException, IOException, ParseException {
		ArrayList <Effect> marketEffect = new ArrayList<Effect>();
		List<String> keys = new ArrayList<String>();
		for (String key : immediateEffect.keySet()) {
			keys.add(key);
		}
		for (int i = 0; i < keys.size(); i++) {
			String effect = keys.get(i);
			int bonusEffect = immediateEffect.get(effect);
			switch (effect) {
			case "coin": {
				GainCoin gainCoin = new GainCoin(bonusEffect);
				marketEffect.add(gainCoin);
				break;
			}

			case "servant": {
				GainServant gainServant = new GainServant(bonusEffect);
				marketEffect.add(gainServant);
				break;
			}

			case "militaryPoint": {
				GainMilitaryPoint gainMilitaryPoint = new GainMilitaryPoint(bonusEffect);
				marketEffect.add(gainMilitaryPoint);
				break;
			}
			}
		}
		return marketEffect;
	}
		
	}

