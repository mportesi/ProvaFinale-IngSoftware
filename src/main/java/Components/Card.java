package Components;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import Effects.Effect;
import Effects.GainCoin;
import Effects.GainStone;
import Effects.GainVictoryPoint;
import Effects.GainVictoryPointForBuildingCard;
import Effects.GainVictoryPointForCharacterCard;
import Effects.GainVictoryPointForMilitaryPoint;
import Effects.GainVictoryPointForTerritoryCard;
import Effects.GainVictoryPointForVentureCard;
import Effects.GainWood;

public class Card {
	protected String type;
	protected String name;
	protected Long period;
	protected Map<String, Long> immediateEffect;
	protected List<Effect> iEffect;
	
	public void createListOfEffect(){
		iEffect= new ArrayList<Effect>();
		List<String> keys= new ArrayList<String>();
		for(String key: immediateEffect.keySet()){
			keys.add(key);
		}
		for(int i=0; i<keys.size(); i++){
			String effect= keys.get(i);
			Long costImmediateEffect= immediateEffect.get(effect);
			switch(effect){
			case "GainCoin":{
				GainCoin gainCoin= new GainCoin(costImmediateEffect);
				iEffect.add(gainCoin);
				break;
			}
			case "GainWood":{
				GainWood gainWood= new GainWood(costImmediateEffect);
				iEffect.add(gainWood);
				break;
			}
			case "GainStone":{
				GainStone gainStone= new GainStone(costImmediateEffect);
				iEffect.add(gainStone);
				break;
			}
			case "GainServant":{
				GainServant gainServant= new GainServant(costImmediateEffect);
				iEffect.add(gainServant);
			}
			case "GainVictoryPoint":{
				GainVictoryPoint gainVictoryPoint= new GainVictoryPoint(costImmediateEffect);
				iEffect.add(gainVictoryPoint);
				break;
			}
			case "GainVictoryPointForMilitaryPoint":{
				GainVictoryPointForMilitaryPoint gainVictoryPointForMilitaryPoint= new GainVictoryPointForMilitaryPoint(costImmediateEffect);
				iEffect.add(gainVictoryPointForMilitaryPoint);
				break;
			}
			case "GainVictoryPointForTerritoryCard":{
				GainVictoryPointForTerritoryCard gainVictoryPointForTerritoryCard= new GainVictoryPointForTerritoryCard(costImmediateEffect);
				iEffect.add(gainVictoryPointForTerritoryCard);
				break;
			}
			case "GainVictoryPointForBuildingCard":{
				GainVictoryPointForBuildingCard gainVictoryPointForBuildingCard= new GainVictoryPointForBuildingCard(costImmediateEffect);
				iEffect.add(gainVictoryPointForBuildingCard);
				break;
			}
			case "GainVictoryPointForVentureCard":{
				GainVictoryPointForVentureCard gainVictoryPointForVentureCard= new GainVictoryPointForVentureCard(costImmediateEffect);
				iEffect.add(gainVictoryPointForVentureCard);
				break;
			}
			case "GainVictoryPointForCharacterCard":{
				GainVictoryPointForCharacterCard gainVictoryPointForCharacterCard= new GainVictoryPointForCharacterCard(costImmediateEffect);
				iEffect.add(gainVictoryPointForCharacterCard);
				break;
			}
			case "GainFaithPoint":{
				GainFaithPoint gainFaithPoint= new GainFaithPoint(costImmediateEffect);
				iEffect.add(gainWood);
				break;
			}
			case "GainMilitaryPoint":{
				GainMilitaryPoint gainMilitaryPoint= new GainMilitaryPoint(costImmediateEffect);
				iEffect.add(gainStone);
				break;
			}
		}
		}
	}
	
	public void applyEffect(){
		createListOfEffect();
	
		for (Effect e: iEffect){
			if(e!=null){
			e.apply();}
			else{return;}
		}
	}
	

	public String getType(){
		return type;
	};
	
	public String getName(){
		return name;
	}
	
	public Long getPeriod(){
		return period;
	}
	
	

}