package it.polimi.ingsw.cards;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import it.polimi.ingsw.GC_40.Player;
import it.polimi.ingsw.effects.Card;
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

public class Card {
	protected String type;
	protected String name;
	protected int period;
	protected Map<String, Integer> immediateEffect;
	protected List<Effect> iEffect;
	

	// This method create the list of the Effect of the card from a Map<String,
	// Integer>
	public void createListOfEffect() {
		iEffect = new ArrayList<Effect>();
		List<String> keys = new ArrayList<String>();
		for (String key : immediateEffect.keySet()) {
			keys.add(key);
		}
		for (int i = 0; i < keys.size(); i++) {
			String effect = keys.get(i);
			int costImmediateEffect = immediateEffect.get(effect);
			switch (effect) {
			case "GainCoin": {
				GainCoin gainCoin = new GainCoin(costImmediateEffect);
				iEffect.add(gainCoin);
				break;
			}
			case "GainWood": {
				GainWood gainWood = new GainWood(costImmediateEffect);
				iEffect.add(gainWood);
				break;
			}
			case "GainStone": {
				GainStone gainStone = new GainStone(costImmediateEffect);
				iEffect.add(gainStone);
				break;
			}
			case "GainServant": {
				GainServant gainServant = new GainServant(costImmediateEffect);
				iEffect.add(gainServant);
			}
			case "GainPrivilegeCouncil": {
				String resource = PrivilegeCouncil.choosePrivilegeCouncil();
				GainPrivilegeCouncil gainPrivilegeCouncil = new GainPrivilegeCouncil(costImmediateEffect, resource);
				iEffect.add(gainPrivilegeCouncil);
				break;
			}
			case "GainVictoryPoint": {
				GainVictoryPoint gainVictoryPoint = new GainVictoryPoint(costImmediateEffect);
				iEffect.add(gainVictoryPoint);
				break;
			}
			case "GainVictoryPointForMilitaryPoint": {
				GainVictoryPointForMilitaryPoint gainVictoryPointForMilitaryPoint = new GainVictoryPointForMilitaryPoint(
						costImmediateEffect);
				iEffect.add(gainVictoryPointForMilitaryPoint);
				break;
			}
			case "GainVictoryPointForTerritoryCard": {
				GainVictoryPointForTerritoryCard gainVictoryPointForTerritoryCard = new GainVictoryPointForTerritoryCard(
						costImmediateEffect);
				iEffect.add(gainVictoryPointForTerritoryCard);
				break;
			}
			case "GainVictoryPointForBuildingCard": {
				GainVictoryPointForBuildingCard gainVictoryPointForBuildingCard = new GainVictoryPointForBuildingCard(
						costImmediateEffect);
				iEffect.add(gainVictoryPointForBuildingCard);
				break;
			}
			case "GainVictoryPointForVentureCard": {
				GainVictoryPointForVentureCard gainVictoryPointForVentureCard = new GainVictoryPointForVentureCard(
						costImmediateEffect);
				iEffect.add(gainVictoryPointForVentureCard);
				break;
			}
			case "GainVictoryPointForCharacterCard": {
				GainVictoryPointForCharacterCard gainVictoryPointForCharacterCard = new GainVictoryPointForCharacterCard(
						costImmediateEffect);
				iEffect.add(gainVictoryPointForCharacterCard);
				break;
			}
			case "GainFaithPoint": {
				GainFaithPoint gainFaithPoint = new GainFaithPoint(costImmediateEffect);
				iEffect.add(gainFaithPoint);
				break;
			}
			case "GainMilitaryPoint": {
				GainMilitaryPoint gainMilitaryPoint = new GainMilitaryPoint(costImmediateEffect);
				iEffect.add(gainMilitaryPoint);
				break;
			}
			
			//aggiungo il case con getCard
			}
		}
	}

	// to apply immediate effects
	public void applyEffect(Player player) {
			createListOfEffect();

		for (Effect e : iEffect) {
			if (e != null && e != getCard) {
				e.apply(player);
			} 
				return;
			}
		}
	

	/*for (Effect e : iEffect) {
	if (e != null && e != getCard) {
		e.apply(player);
	} elseif (e != null && e == getCard){
		Card card=player.chooseCard();
		e.apply(player, card);
		
	}
		return;
	}
}*/
	
	public void payCost(Player player){
	};

	public String getType() {
		return type;
	};

	public String getName() {
		return name;
	}

	public int getPeriod() {
		return period;
	}

}