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
import it.polimi.ingsw.effects.GainMilitaryPoint;
import it.polimi.ingsw.effects.GainResourceForCost;
import it.polimi.ingsw.effects.GainResourceForCostAlternative;
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
import it.polimi.ingsw.effects.PayCoin;
import it.polimi.ingsw.effects.PayFaith;
import it.polimi.ingsw.effects.PayServant;
import it.polimi.ingsw.effects.PayStone;
import it.polimi.ingsw.effects.PayWood;

public class BuildingListOfPermanentEffect extends CreateListOfEffect{
	
	protected transient Map<String, Integer> permanentEffect;
	private String permanentEffectType;
	
	public BuildingListOfPermanentEffect(Map<String, Integer> permanentEffect, String permanentEffectType){
		this.permanentEffect=permanentEffect;
		this.permanentEffectType=permanentEffectType;
	}
	
	@Override
	public ArrayList<Effect> createListOfEffect() throws FileNotFoundException, IOException, ParseException {
		ArrayList<Effect> permanentEffects = new ArrayList<Effect>();
		List<String> keys = new ArrayList<String>();
		for (String key : permanentEffect.keySet()) {
			keys.add(key);
		}
		switch(permanentEffectType){
		case("GainResourceForCost"):{
			ArrayList<Effect> pay= new ArrayList<Effect>();
			ArrayList<Effect> gain= new ArrayList<Effect>();
			for (int i = 0; i < keys.size(); i++){
				String effect = keys.get(i);
				int costImmediateEffect = permanentEffect.get(effect);
				switch(effect){
				case("PayCoin"):{
					PayCoin payCoin=new PayCoin(costImmediateEffect);
					pay.add(payCoin);
					break;
				}
				case("PayFaith"):{
					PayFaith payFaith=new PayFaith(costImmediateEffect);
					pay.add(payFaith);
					break;
				}
				case("PayServant"):{
					PayServant payServant=new PayServant(costImmediateEffect);
					pay.add(payServant);
					break;
				}
				case("PayStone"):{
					PayStone payStone=new PayStone(costImmediateEffect);
					pay.add(payStone);
					break;
				}
				case("PayWood"):{
					PayWood payWood=new PayWood(costImmediateEffect);
					pay.add(payWood);
					break;
				}
				case("GainPrivilegeCouncil"):{
					HasPrivilege hasPrivilege=new HasPrivilege();
					gain.add(hasPrivilege);
					break;
				}
				case("GainMilitaryPoint"):{
					GainMilitaryPoint gainMilitaryPoint=new GainMilitaryPoint(costImmediateEffect);
					gain.add(gainMilitaryPoint);
					break;
				}
				case("GainFaithPoint"):{
					GainFaithPoint gainFaithPoint=new GainFaithPoint(costImmediateEffect);
					gain.add(gainFaithPoint);
					break;
				}
				}
			}
			GainResourceForCost gainResourceForCost= new GainResourceForCost(pay,gain);
			permanentEffects.add(gainResourceForCost);
			break;
		}
		case("GainResourceForCostAlternative"):{
			ArrayList<Effect> pay= new ArrayList<Effect>();
			ArrayList<Effect> gain= new ArrayList<Effect>();
			ArrayList<Effect> payAlt= new ArrayList<Effect>();
			ArrayList<Effect> gainAlt= new ArrayList<Effect>();
			for (int i = 0; i < keys.size(); i++){
				String effect = keys.get(i);
				int costImmediateEffect = permanentEffect.get(effect);
				switch(effect){
				case("PayCoin"):{
					PayCoin payCoin=new PayCoin(costImmediateEffect);
					pay.add(payCoin);
					break;
				}
				case("PayFaith"):{
					PayFaith payFaith=new PayFaith(costImmediateEffect);
					pay.add(payFaith);
					break;
				}
				case("PayServant"):{
					PayServant payServant=new PayServant(costImmediateEffect);
					pay.add(payServant);
					break;
				}
				case("PayStone"):{
					PayStone payStone=new PayStone(costImmediateEffect);
					pay.add(payStone);
					break;
				}
				case("PayWood"):{
					PayWood payWood=new PayWood(costImmediateEffect);
					pay.add(payWood);
					break;
				}
				case("GainCoin"):{
					GainCoin gainCoin=new GainCoin(costImmediateEffect);
					gain.add(gainCoin);
					break;
				}
				case("GainServant"):{
					GainServant gainServant=new GainServant(costImmediateEffect);
					gain.add(gainServant);
					break;
				}
				case("GainStone"):{
					GainStone gainStone=new GainStone(costImmediateEffect);
					gain.add(gainStone);
					break;
				}
				case("GainWood"):{
					GainWood gainWood=new GainWood(costImmediateEffect);
					gain.add(gainWood);
					break;
				}
				case("GainVictoryPoint"):{
					GainVictoryPoint gainVictoryPoint=new GainVictoryPoint(costImmediateEffect);
					gain.add(gainVictoryPoint);
					break;
				}
				case("GainMilitaryPoint"):{
					GainMilitaryPoint gainMilitaryPoint=new GainMilitaryPoint(costImmediateEffect);
					gain.add(gainMilitaryPoint);
					break;
				}
				case("GainFaithPoint"):{
					GainFaithPoint gainFaithPoint=new GainFaithPoint(costImmediateEffect);
					gain.add(gainFaithPoint);
					break;
				}
				case("PayCoinAlt"):{
					PayCoin payCoin=new PayCoin(costImmediateEffect);
					payAlt.add(payCoin);
					break;
				}
				case("PayFaithAlt"):{
					PayFaith payFaith=new PayFaith(costImmediateEffect);
					payAlt.add(payFaith);
					break;
				}
				case("PayServantAlt"):{
					PayServant payServant=new PayServant(costImmediateEffect);
					payAlt.add(payServant);
					break;
				}
				case("PayStoneAlt"):{
					PayStone payStone=new PayStone(costImmediateEffect);
					payAlt.add(payStone);
					break;
				}
				case("PayWoodAlt"):{
					PayWood payWood=new PayWood(costImmediateEffect);
					payAlt.add(payWood);
					break;
				}
				case("GainCoinAlt"):{
					GainCoin gainCoin=new GainCoin(costImmediateEffect);
					gainAlt.add(gainCoin);
					break;
				}
				case("GainServantAlt"):{
					GainServant gainServant=new GainServant(costImmediateEffect);
					gainAlt.add(gainServant);
					break;
				}
				case("GainStoneAlt"):{
					GainStone gainStone=new GainStone(costImmediateEffect);
					gainAlt.add(gainStone);
					break;
				}
				case("GainWoodAlt"):{
					GainWood gainWood=new GainWood(costImmediateEffect);
					gainAlt.add(gainWood);
					break;
				}
				case("GainVictoryPointAlt"):{
					GainVictoryPoint gainVictoryPoint=new GainVictoryPoint(costImmediateEffect);
					gainAlt.add(gainVictoryPoint);
					break;
				}
				case("GainMilitaryPointAlt"):{
					GainMilitaryPoint gainMilitaryPoint=new GainMilitaryPoint(costImmediateEffect);
					gainAlt.add(gainMilitaryPoint);
					break;
				}
				case("GainFaithPointAlt"):{
					GainFaithPoint gainFaithPoint=new GainFaithPoint(costImmediateEffect);
					gainAlt.add(gainFaithPoint);
					break;
				}
				}
			}
			GainResourceForCostAlternative gainResourceForCostAlternative=new GainResourceForCostAlternative(pay,gain,payAlt,gainAlt);
			permanentEffects.add(gainResourceForCostAlternative);
			break;
		}
		case("Gain"):{
			for (int i = 0; i < keys.size(); i++){
				String effect = keys.get(i);
				int costImmediateEffect = permanentEffect.get(effect);
				switch(effect){
				case("GainCoin"):{
					GainCoin gainCoin=new GainCoin(costImmediateEffect);
					permanentEffects.add(gainCoin);
					break;
				}
				case("GainVictoryPoint"):{
					GainVictoryPoint gainVictoryPoint=new GainVictoryPoint(costImmediateEffect);
					permanentEffects.add(gainVictoryPoint);
					break;
				}
				case("GainMilitaryPoint"):{
					GainMilitaryPoint gainMilitaryPoint=new GainMilitaryPoint(costImmediateEffect);
					permanentEffects.add(gainMilitaryPoint);
					break;
				}
				case("GainPrivilegeCouncil"):{
					HasPrivilege hasPrivilege=new HasPrivilege();
					permanentEffects.add(hasPrivilege);
					break;
				}
				case("GainVictoryPointForBuildingCard"):{
					GainVictoryPointForBuildingCard gainVictoryPointForBuildingCard= new GainVictoryPointForBuildingCard(costImmediateEffect);
					permanentEffects.add(gainVictoryPointForBuildingCard);
					break;
				}
				case("GainVictoryPointForCharacterCard"):{
					GainVictoryPointForCharacterCard gainVictoryPointForCharacterCard= new GainVictoryPointForCharacterCard(costImmediateEffect);
					permanentEffects.add(gainVictoryPointForCharacterCard);
					break;
				}
				case("GainVictoryPointForTerritoryCard"):{
					GainVictoryPointForTerritoryCard gainVictoryPointForTerritoryCard= new GainVictoryPointForTerritoryCard(costImmediateEffect);
					permanentEffects.add(gainVictoryPointForTerritoryCard);
					break;
				}
				case("GainVictoryPointForVentureCard"):{
					GainVictoryPointForVentureCard gainVictoryPointForVentureCard= new GainVictoryPointForVentureCard(costImmediateEffect);
					permanentEffects.add(gainVictoryPointForVentureCard);
					break;
				}
				case("GainVictoryPointForMilitaryPoint"):{
					GainVictoryPointForMilitaryPoint gainVictoryPointForMilitaryPoint= new GainVictoryPointForMilitaryPoint(costImmediateEffect);
					permanentEffects.add(gainVictoryPointForMilitaryPoint);
					break;
				}
				}
			}
		}
	}
	return permanentEffects;
	}

}
