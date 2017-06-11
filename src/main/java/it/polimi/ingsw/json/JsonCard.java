package it.polimi.ingsw.json;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import it.polimi.ingsw.cards.BuildingCard;
import it.polimi.ingsw.cards.BuildingListOfEffect;
import it.polimi.ingsw.cards.Card;
import it.polimi.ingsw.cards.CharacterCard;
import it.polimi.ingsw.cards.CharacterListOfEffect;
import it.polimi.ingsw.cards.TerritoryCard;
import it.polimi.ingsw.cards.TerritoryListOfEffect;
import it.polimi.ingsw.cards.VentureCard;
import it.polimi.ingsw.cards.VentureListOfEffect;

public class JsonCard {

	private List<Card> buildingDeck;
	private List<Card> territoryDeck ;
	private List<Card> ventureDeck ;
	private List<Card> characterDeck ;
	
	public void importCards() throws FileNotFoundException, IOException, ParseException {
		// BuildingCards
				buildingDeck= new ArrayList<Card>();
				JSONParser buildingParser = new JSONParser();
				JSONArray buildingArray = (JSONArray) buildingParser.parse(new FileReader("json/BuildingCards.json"));
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
					
					
					BuildingListOfEffect immediate= new BuildingListOfEffect(immediateEffectMap);
					Card c = new BuildingCard(type, name, period, costMap, immediate);

					buildingDeck.add(c);
				}

				// TerritoryCards
				territoryDeck= new ArrayList<Card>();
				JSONParser territoryParser = new JSONParser();
				JSONArray territoryArray = (JSONArray) territoryParser.parse(new FileReader("json/TerritoryCards.json"));
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
					
					TerritoryListOfEffect immediate= new TerritoryListOfEffect(immediateEffectMap);
					Card c = new TerritoryCard(type, name, period, immediate);
					System.out.println(c);
					territoryDeck.add(c);
				}

				// VentureDeck
				ventureDeck= new ArrayList<Card>();
				JSONParser ventureParser = new JSONParser();
				JSONArray ventureArray = (JSONArray) ventureParser.parse(new FileReader("json/VentureCards.json"));
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
					VentureListOfEffect immediate= new VentureListOfEffect(immediateEffectMap);
					Card c;
					if (alternativeCostBoolean == 1) {
						c = new VentureCard(type, name, period, costMap, militaryRequirement, militaryCost, immediate);
					} else if (militaryRequirement == 0 && militaryCost == 0) {
						c = new VentureCard(type, name, period, costMap, immediate);
					} else {
						c = new VentureCard(type, name, period, militaryRequirement, militaryCost, costMap);
					}

					ventureDeck.add(c);
				}

				// CharacterCard
				characterDeck= new ArrayList<Card>();
				JSONParser characterParser = new JSONParser();
				JSONArray characterArray = (JSONArray) characterParser.parse(new FileReader("json/CharacterCards.json"));
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
					CharacterListOfEffect immediate= new CharacterListOfEffect(immediateEffectMap);
					if (bonusCard != null) {
						int valueGetCard = ((Long) card.get("valueGetCard")).intValue();
						JSONArray discount = (JSONArray) characterParser.parse(card.get("discount").toString());

						Map<String, Integer> discountMap = new LinkedHashMap();
						for (int i = 0; i < discount.size(); i++) {
							JSONObject discountObject = (JSONObject) discount.get(i);
							String typeDiscount = (String) discountObject.get("typeDiscount");
							int amount = ((Long) discountObject.get("amount")).intValue();
							discountMap.put(typeDiscount, amount);
						}

						Card c = new CharacterCard(type, name, period, costCoin, bonusCard, valueGetCard, discountMap, immediate);
						characterDeck.add(c);
					
					} else {

						Card c = new CharacterCard(type, name, period, costCoin, immediate);
						characterDeck.add(c);
						
					}
					
					
					

				}

	}

	public  List<Card> getCharacterDeck() {
		// TODO Auto-generated method stub
		return characterDeck;
	}
	
	public  List<Card> getTerritoryDeck() {
		// TODO Auto-generated method stub
		return territoryDeck;
	}
	
	public  List<Card> getVentureDeck() {
		// TODO Auto-generated method stub
		return ventureDeck;
	}
	
	public  List<Card> getBuildingDeck() {
		// TODO Auto-generated method stub
		return buildingDeck;
	}




}
