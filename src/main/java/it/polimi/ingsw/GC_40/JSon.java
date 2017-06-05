package it.polimi.ingsw.GC_40;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.invoke.*;
import java.util.List;
import java.util.Map;

import javax.swing.text.html.HTMLDocument.Iterator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import it.polimi.ingsw.areas.CouncilPalace;
import it.polimi.ingsw.areas.Floor;
import it.polimi.ingsw.areas.HarvestAndProductionArea;
import it.polimi.ingsw.areas.MarketBuilding;
import it.polimi.ingsw.cards.BuildingCard;
import it.polimi.ingsw.cards.Card;
import it.polimi.ingsw.cards.CharacterCard;
import it.polimi.ingsw.cards.TerritoryCard;
import it.polimi.ingsw.cards.VentureCard;
import it.polimi.ingsw.components.PersonalBonusTile;
import it.polimi.ingsw.components.PrivilegeCouncil;
import it.polimi.ingsw.effects.Effect;
import it.polimi.ingsw.effects.GainCoin;
import it.polimi.ingsw.effects.GainMilitaryPoint;
import it.polimi.ingsw.effects.GainStone;
import it.polimi.ingsw.effects.GainWood;
//da dividere 
public class JSon {
	public static List<Card> buildingDeck = new ArrayList<Card>();
	public static List<Card> territoryDeck = new ArrayList<Card>();
	public static List<Card> ventureDeck = new ArrayList<Card>();
	public static List<Card> characterDeck = new ArrayList<Card>();
	public static ArrayList<Floor> territoryFloors = new ArrayList<Floor>();
	public static ArrayList<Floor> characterFloors = new ArrayList<Floor>();
	public static ArrayList<Floor> buildingFloors = new ArrayList<Floor>();
	public static ArrayList<Floor> ventureFloors = new ArrayList<Floor>();
	public static ArrayList <MarketBuilding> marketBuilding = new ArrayList <MarketBuilding>();
	public static ArrayList <PersonalBonusTile> personalBonusTiles = new ArrayList <PersonalBonusTile>();
	public static HarvestAndProductionArea harvest;
	public static HarvestAndProductionArea production;
	public static CouncilPalace councilPalace;

	public static void importCards() throws FileNotFoundException, IOException, ParseException {
		
		JSONParser finalVictoryPointParser = new JSONParser();
		JSONArray finalVictoryPointArray = (JSONArray) finalVictoryPointParser.parse(new FileReader("GC_40/finalVictoryPoints.json"));
		for (Object o : finalVictoryPointArray){
			
			JSONObject finalVictoryPoint = (JSONObject) o;
			String type = (String) finalVictoryPoint.get("type");
			
			JSONArray gain = (JSONArray) finalVictoryPointParser.parse(finalVictoryPoint.get("gain").toString());
			
			Map<String, Integer> finalVictoryPointMap = new LinkedHashMap();
			for (int i = 0; i < gain.size(); i++) {
				JSONObject gainObject = (JSONObject) gain.get(i);
				int numberOf = ((Long) gainObject.get("numberOf")).intValue();
				int amount = ((Long) gainObject.get("amount")).intValue();
				finalVictoryPoint.put(numberOf, amount);
			
			
		}
		}
		
		JSONParser councilPalaceParser = new JSONParser();
		JSONObject councilPalaceObj = (JSONObject) councilPalaceParser.parse(new FileReader("GC-40/CouncilPalace.json"));
		
		int bonusPrivilegeCouncil = ((Long) councilPalaceObj.get("bonusPrivilegeCouncil")).intValue();
		int bonusCoin = ((Long) councilPalaceObj.get("bonusCoin")).intValue();
		int cost = ((Long) councilPalaceObj.get("cost")).intValue();
		
		CouncilPalace councilPalace = new CouncilPalace(bonusPrivilegeCouncil, bonusCoin, cost);
		
		
		JSONParser privilegeCouncilParser = new JSONParser();
		JSONObject privilegeCouncilObj = (JSONObject) privilegeCouncilParser.parse(new FileReader("GC-40/PrivilegeCouncil.json"));
		
		int bonusWoodAndStone = ((Long) privilegeCouncilObj.get("bonusWoodAndStone")).intValue();
		int bonusServant = ((Long) privilegeCouncilObj.get("bonusServant")).intValue();
		int bonusCoinP = ((Long) privilegeCouncilObj.get("bonusCoin")).intValue();
		int bonusMilitaryPoint = ((Long) privilegeCouncilObj.get("bonusMilitaryPoint")).intValue();
		int bonusFaithPoint = ((Long) privilegeCouncilObj.get("bonusFaithPoint")).intValue();
		
		PrivilegeCouncil privilegeCouncil = new PrivilegeCouncil(bonusWoodAndStone, bonusServant, bonusCoinP, bonusMilitaryPoint, bonusFaithPoint);
		
		
		
		JSONParser harvestAndProductionParser = new JSONParser();
		JSONArray harvestAndProductionArray = (JSONArray) harvestAndProductionParser.parse(new FileReader("GC-40/BonusFloors.json"));
		for (Object o : harvestAndProductionArray) {
			JSONObject harvestAndProduction = (JSONObject) o;

			String type = (String) harvestAndProduction.get("type");
			int costOfLeftArea = ((Long) harvestAndProduction.get("costOfLeftArea")).intValue();
			int costOfRightArea = ((Long) harvestAndProduction.get("costOfRightArea")).intValue();
			int malus = ((Long) harvestAndProduction.get("malus")).intValue();
			
			switch (type){
			case "production": {
				production = new HarvestAndProductionArea (type, costOfLeftArea, costOfRightArea, malus);
				break;
			}
			case "harvest": {
				harvest = new HarvestAndProductionArea (type, costOfLeftArea, costOfRightArea, malus);
				break;
			}
			}
			
		}
			

		JSONParser floorParser = new JSONParser();
		JSONArray floorArray = (JSONArray) floorParser.parse(new FileReader("GC_40/BonusFloors.json"));
		for (Object o : floorArray) {
			JSONObject floor = (JSONObject) o;

			String type = (String) floor.get("type");
			int costOfFloor = ((Long) floor.get("cost")).intValue();
			int amountBonus = ((Long) floor.get("amountBonus")).intValue();

			switch (type) {
			case "territory": {
				GainWood e = new GainWood(amountBonus);
				Floor f = new Floor(type, costOfFloor, e);
				territoryFloors.add(f);
				break;
			}
			case "character": {
				GainStone e = new GainStone(amountBonus);
				Floor f = new Floor(type, costOfFloor, e);
				characterFloors.add(f);
				break;
			}
			case "building": {
				GainMilitaryPoint e = new GainMilitaryPoint(amountBonus);
				Floor f = new Floor(type, costOfFloor, e);
				buildingFloors.add(f);
				break;
			}
			case "venture": {
				GainCoin e = new GainCoin(amountBonus);
				Floor f = new Floor(type, costOfFloor, e);
				ventureFloors.add(f);
				break;
			}
			}
		}
		
		JSONParser marketParser = new JSONParser();
		JSONArray marketArray = (JSONArray) marketParser.parse(new FileReader("GC_40/MarketBonus.json"));
		for (Object o : marketArray){
			
			JSONObject market = (JSONObject) o;
			String type = (String) market.get("type");
			int costOfMarket= ((Long) market.get("cost")).intValue();
			
			JSONArray bonus = (JSONArray) marketParser.parse(market.get("bonus").toString());
			
			Map<String, Integer> bonusMap = new LinkedHashMap();
			for (int i = 0; i < bonus.size(); i++) {
				JSONObject bonusObject = (JSONObject) bonus.get(i);
				String typeBonus = (String) bonusObject.get("type");
				int amount = ((Long) bonusObject.get("amount")).intValue();
				bonusMap.put(typeBonus, amount);
			
			MarketBuilding m = new MarketBuilding (type, bonusMap, costOfMarket);
			marketBuilding.add(m);
			
		}
		}
		
		JSONParser personalBonusTileParser = new JSONParser();
		JSONArray personalBonusTileArray = (JSONArray) personalBonusTileParser.parse(new FileReader("GC_40/MarketBonus.json"));
		for (Object o : personalBonusTileArray){
			
			JSONObject personalBonusTile = (JSONObject) o;
			String type = (String) personalBonusTile.get("type");
			int costProduction = ((Long) personalBonusTile.get("costProduction")).intValue();
			int costHarvest = ((Long) personalBonusTile.get("costHarvest")).intValue();
			
			JSONArray bonusProduction = (JSONArray) personalBonusTileParser.parse(personalBonusTile.get("bonusProduction").toString());
			JSONArray bonusHarvest = (JSONArray) personalBonusTileParser.parse(personalBonusTile.get("bonusHarvest").toString());
			
			Map<String, Integer> bonusProductionMap = new LinkedHashMap();
			for (int i = 0; i < bonusProduction.size(); i++) {
				JSONObject bonusObject = (JSONObject) bonusProduction.get(i);
				String typeBonus = (String) bonusObject.get("type");
				int amount = ((Long) bonusObject.get("amount")).intValue();
				bonusProductionMap.put(typeBonus, amount);
			}
				
		
			Map<String, Integer> bonusHarvestMap = new LinkedHashMap();
			for (int j = 0; j < bonusHarvest.size(); j++) {
				JSONObject bonusObject1 = (JSONObject) bonusHarvest.get(j);
				String typeBonus1 = (String) bonusObject1.get("type");
				int amount1 = ((Long) bonusObject1.get("amount")).intValue();
				bonusHarvestMap.put(typeBonus1, amount1);
			
			}
			
			PersonalBonusTile personalBonusTile1 = new PersonalBonusTile (type, bonusProductionMap, bonusHarvestMap, costProduction, costHarvest);
			personalBonusTiles.add(personalBonusTile1);
			}
		
		

		// BuildingCards
		JSONParser buildingParser = new JSONParser();
		JSONArray buildingArray = (JSONArray) buildingParser.parse(new FileReader("GC_40/BuildingCards.json"));
		for (Object o : buildingArray) {
			JSONObject card = (JSONObject) o;

			String type = (String) card.get("type");
			int period = ((Long) card.get("period")).intValue();
			String name = (String) card.get("name");

			JSONArray costOfBuilding = (JSONArray) buildingParser.parse(card.get("cost").toString());

			JSONArray immediateEffect = (JSONArray) buildingParser.parse(card.get("immediateEffect").toString());

			Map<String, Integer> costMap = new LinkedHashMap();
			for (int i = 0; i < costOfBuilding.size(); i++) {
				JSONObject costObject = (JSONObject) costOfBuilding.get(i);
				String typeCost = (String) costObject.get("type");
				int amount = ((Long) costObject.get("amount")).intValue();
				costMap.put(typeCost, amount);
			}

			Map<String, Integer> immediateEffectMap = new LinkedHashMap();
			for (int i = 0; i < immediateEffect.size(); i++) {
				JSONObject immediateEffectObject = (JSONObject) immediateEffect.get(i);
				String typeImmediateEffect = (String) immediateEffectObject.get("type");
				int amount = ((Long) immediateEffectObject.get("amount")).intValue();
				immediateEffectMap.put(typeImmediateEffect, amount);
			}

			Card c = new BuildingCard(type, name, period, costMap, immediateEffectMap);

			buildingDeck.add(c);
		}

		// TerritoryCards
		JSONParser territoryParser = new JSONParser();
		JSONArray territoryArray = (JSONArray) territoryParser.parse(new FileReader("GC_40/TerritoryCards.json"));
		for (Object o : territoryArray) {
			JSONObject card = (JSONObject) o;

			String type = (String) card.get("type");
			int period = ((Long) card.get("period")).intValue();
			String name = (String) card.get("name");

			JSONArray immediateEffect = (JSONArray) territoryParser.parse(card.get("immediateEffect").toString());

			Map<String, Integer> immediateEffectMap = new LinkedHashMap();
			for (int i = 0; i < immediateEffect.size(); i++) {
				JSONObject immediateEffectObject = (JSONObject) immediateEffect.get(i);
				String typeImmediateEffect = (String) immediateEffectObject.get("type");
				int amount = ((Long) immediateEffectObject.get("amount")).intValue();
				immediateEffectMap.put(typeImmediateEffect, amount);
			}

			Card c = new TerritoryCard(type, name, period, immediateEffectMap);

			territoryDeck.add(c);
		}

		// VentureDeck
		JSONParser ventureParser = new JSONParser();
		JSONArray ventureArray = (JSONArray) ventureParser.parse(new FileReader("GC_40/VentureCards.json"));
		for (Object o : ventureArray) {
			JSONObject card = (JSONObject) o;

			String type = (String) card.get("type");
			int period = ((Long) card.get("period")).intValue();
			String name = (String) card.get("name");
			int alternativeCostBoolean = ((Long) card.get("alternativeCostBoolean")).intValue();
			int militaryRequirement = ((Long) card.get("militaryRequirement")).intValue();
			int militaryCost = ((Long) card.get("militaryCost")).intValue();
			JSONArray costOfVenture = (JSONArray) ventureParser.parse(card.get("cost").toString());

			JSONArray immediateEffect = (JSONArray) ventureParser.parse(card.get("immediateEffect").toString());

			Map<String, Integer> costMap = new LinkedHashMap();
			for (int i = 0; i < costOfVenture.size(); i++) {
				JSONObject costObject = (JSONObject) costOfVenture.get(i);
				String typeCost = (String) costObject.get("type");
				int amount = ((Long) costObject.get("amount")).intValue();
				costMap.put(typeCost, amount);
			}

			Map<String, Integer> immediateEffectMap = new LinkedHashMap();
			for (int i = 0; i < immediateEffect.size(); i++) {
				JSONObject immediateEffectObject = (JSONObject) immediateEffect.get(i);
				String typeImmediateEffect = (String) immediateEffectObject.get("type");
				int amount = ((Long) immediateEffectObject.get("amount")).intValue();
				immediateEffectMap.put(typeImmediateEffect, amount);
			}
			Card c;
			if (alternativeCostBoolean == 1) {
				c = new VentureCard(type, name, period, costMap, militaryRequirement, militaryCost, immediateEffectMap);
			} else if (militaryRequirement == 0 && militaryCost == 0) {
				c = new VentureCard(type, name, period, costMap, immediateEffectMap);
			} else {
				c = new VentureCard(type, name, period, militaryRequirement, militaryCost, costMap, immediateEffectMap);
			}

			ventureDeck.add(c);
		}

		// CharacterCard
		JSONParser characterParser = new JSONParser();
		JSONArray characterArray = (JSONArray) characterParser.parse(new FileReader("GC_40/CharacterCards.json"));
		for (Object o : characterArray) {
			JSONObject card = (JSONObject) o;

			String type = (String) card.get("type");
			int period = ((Long) card.get("period")).intValue();
			String name = (String) card.get("name");
			int costCoin = ((Long) card.get("costCoin")).intValue();
			String bonusCard = (String) card.get("getCard");

			JSONArray immediateEffect = (JSONArray) characterParser.parse(card.get("immediateEffect").toString());

			Map<String, Integer> immediateEffectMap = new LinkedHashMap();
			for (int i = 0; i < immediateEffect.size(); i++) {
				JSONObject immediateEffectObject = (JSONObject) immediateEffect.get(i);
				String typeImmediateEffect = (String) immediateEffectObject.get("type");
				int amount = ((Long) immediateEffectObject.get("amount")).intValue();
				immediateEffectMap.put(typeImmediateEffect, amount);
			}

			if (bonusCard != null) {
				int valueGetCard = (int) card.get("valueGetCard");
				JSONArray discount = (JSONArray) characterParser.parse(card.get("discount").toString());

				Map<String, Integer> discountMap = new LinkedHashMap();
				for (int i = 0; i < discount.size(); i++) {
					JSONObject discountObject = (JSONObject) discount.get(i);
					String typeDiscount = (String) discountObject.get("typeDiscount");
					int amount = ((Long) discountObject.get("amount")).intValue();
					discountMap.put(typeDiscount, amount);
				}

				Card c = new CharacterCard(type, name, period, costCoin, bonusCard, valueGetCard, discountMap,
						immediateEffectMap);
				characterDeck.add(c);
			} else {

				Card c = new CharacterCard(type, name, period, costCoin, immediateEffectMap);
				characterDeck.add(c);
			}

		}

	}
}
