package it.polimi.ingsw.cards;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.effects.Effect;
import it.polimi.ingsw.effects.GainCoin;
import it.polimi.ingsw.effects.GainFaithPoint;
import it.polimi.ingsw.effects.GainHarvestValue;
import it.polimi.ingsw.effects.GainMilitaryPoint;
import it.polimi.ingsw.effects.GainPrivilegeCouncil;
import it.polimi.ingsw.effects.GainProductionValue;
import it.polimi.ingsw.effects.GainServant;
import it.polimi.ingsw.effects.GainStone;
import it.polimi.ingsw.effects.GainVictoryPoint;
import it.polimi.ingsw.effects.GainVictoryPointForBuildingCard;
import it.polimi.ingsw.effects.GainVictoryPointForCharacterCard;
import it.polimi.ingsw.effects.GainVictoryPointForMilitaryPoint;
import it.polimi.ingsw.effects.GainVictoryPointForTerritoryCard;
import it.polimi.ingsw.effects.GainVictoryPointForVentureCard;
import it.polimi.ingsw.effects.GainWood;
import it.polimi.ingsw.effects.HasPrivilege;

/**
 * @author Sara
 * This is an auxiliary class to build the different effects of the cards based on external files json.
 */
public class VentureListOfEffect extends CreateListOfEffect {
	
	public VentureListOfEffect(Map<String, Integer> immediateEffect) {
		super(immediateEffect);
	}

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
			case "GainCoin": {
				GainCoin gainCoin = new GainCoin(costImmediateEffect);
				immediateEffects.add(gainCoin);
				break;
			}
			case "GainWood": {
				GainWood gainWood = new GainWood(costImmediateEffect);
				immediateEffects.add(gainWood);
				break;
			}
			case "GainStone": {
				GainStone gainStone = new GainStone(costImmediateEffect);
				immediateEffects.add(gainStone);
				break;
			}
			case "GainServant": {
				GainServant gainServant = new GainServant(costImmediateEffect);
				immediateEffects.add(gainServant);
			}
			case "GainPrivilegeCouncil": {
				HasPrivilege privilege = new HasPrivilege();
				immediateEffects.add(privilege);
				break;
			}
			case "GainVictoryPoint": {
				GainVictoryPoint gainVictoryPoint = new GainVictoryPoint(costImmediateEffect);
				immediateEffects.add(gainVictoryPoint);
				break;
			}
			case "GainVictoryPointForMilitaryPoint": {
				GainVictoryPointForMilitaryPoint gainVictoryPointForMilitaryPoint = new GainVictoryPointForMilitaryPoint(
						costImmediateEffect);
				immediateEffects.add(gainVictoryPointForMilitaryPoint);
				break;
			}
			case "GainVictoryPointForTerritoryCard": {
				GainVictoryPointForTerritoryCard gainVictoryPointForTerritoryCard = new GainVictoryPointForTerritoryCard(
						costImmediateEffect);
				immediateEffects.add(gainVictoryPointForTerritoryCard);
				break;
			}
			case "GainVictoryPointForBuildingCard": {
				GainVictoryPointForBuildingCard gainVictoryPointForBuildingCard = new GainVictoryPointForBuildingCard(
						costImmediateEffect);
				immediateEffects.add(gainVictoryPointForBuildingCard);
				break;
			}
			case "GainVictoryPointForVentureCard": {
				GainVictoryPointForVentureCard gainVictoryPointForVentureCard = new GainVictoryPointForVentureCard(
						costImmediateEffect);
				immediateEffects.add(gainVictoryPointForVentureCard);
				break;
			}
			case "GainVictoryPointForCharacterCard": {
				GainVictoryPointForCharacterCard gainVictoryPointForCharacterCard = new GainVictoryPointForCharacterCard(
						costImmediateEffect);
				immediateEffects.add(gainVictoryPointForCharacterCard);
				break;
			}
			case "GainFaithPoint": {
				GainFaithPoint gainFaithPoint = new GainFaithPoint(costImmediateEffect);
				immediateEffects.add(gainFaithPoint);
				break;
			}
			case "GainMilitaryPoint": {
				GainMilitaryPoint gainMilitaryPoint = new GainMilitaryPoint(costImmediateEffect);
				immediateEffects.add(gainMilitaryPoint);
				break;
			}
			case "GainHarvestValue":{
				GainHarvestValue gainHarvestValue= new GainHarvestValue(costImmediateEffect);
				immediateEffects.add(gainHarvestValue);
				break;
			}
			case "GainProductionValue":{
				GainProductionValue gainProductionValue= new GainProductionValue(costImmediateEffect);
				immediateEffects.add(gainProductionValue);
				break;
				
			}
			}
		}
		return immediateEffects;
	}
}