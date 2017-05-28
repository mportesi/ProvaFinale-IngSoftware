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

import com.google.gson.Gson;
import com.google.gson.JsonArray;

import Components.BuildingCard;
import Components.Card;
import Components.CharacterCard;
import Components.Floor;
import Components.TerritoryCard;
import Components.VentureCard;
import Effects.Effect;
import Effects.GainCoin;
import Effects.GainMilitaryPoint;
import Effects.GainStone;
import Effects.GainWood;

public class JSon {
	public static List<Card> buildingDeck = new ArrayList <Card>();
	public static List<Card> territoryDeck = new ArrayList <Card>();
	public static List<Card> ventureDeck = new ArrayList <Card>();
	public static List<Card> characterDeck = new ArrayList <Card>();
	public static ArrayList<Floor> territoryFloors = new ArrayList <Floor> ();
	public static ArrayList<Floor> characterFloors = new ArrayList <Floor> ();
	public static ArrayList<Floor> buildingFloors = new ArrayList <Floor> ();
	public static ArrayList<Floor> ventureFloors = new ArrayList <Floor> ();
	
	public static void importCards() throws FileNotFoundException, IOException, ParseException{
	
	
	JSONParser floorParser = new JSONParser();
	JSONArray floorArray = (JSONArray) floorParser.parse(new FileReader("C:/Users/Sara/Desktop/Polimi/III anno/II semestre/Ingegneria del software_Gianpaolo Cugola/Workspace/Lab1/ProvaFinale-IngSoftware/Floors.json"));
	for (Object o : floorArray)
	{
		JSONObject floor = (JSONObject) o;
		
		String type = (String) floor.get("type");
		int cost = ((Long) floor.get("cost")).intValue();
	//	String typeBonus = (String) floor.get("typeBonus");
		int amountBonus = ((Long) floor.get("amountBonus")).intValue();
		
		switch(type){
		case "territory" :{
			GainWood e = new GainWood (amountBonus);
			Floor f = new Floor (type, cost, e);
			territoryFloors.add(f);
		}
		case "character" :{
			GainStone e = new GainStone (amountBonus);
			Floor f = new Floor (type, cost, e);
			characterFloors.add(f);
		}
		case "building" :{
			GainMilitaryPoint e = new GainMilitaryPoint (amountBonus);
			Floor f = new Floor (type, cost, e);
			buildingFloors.add(f);
		}
		case "venture" :{
			GainCoin e = new GainCoin (amountBonus);
			Floor f = new Floor (type, cost, e);
			ventureFloors.add(f);
		}
	}
	
	
	}
	
	//BuildingCards
	JSONParser buildingParser = new JSONParser();
	JSONArray buildingArray = (JSONArray) buildingParser.parse(new FileReader("C:/Users/Sara/Desktop/Polimi/III anno/II semestre/Ingegneria del software_Gianpaolo Cugola/Workspace/Lab1/ProvaFinale-IngSoftware/Carte Torri.json"));
	  for (Object o : buildingArray)
	  {
	    JSONObject card = (JSONObject) o;
	 
	    
	    String type = (String) card.get("type");
	    int period = ((Long) card.get("period")).intValue();
	    String name = (String) card.get("name");

	    

	

	    Map<String, Integer> costMap = new LinkedHashMap();
	    for (int i = 0; i < cost.size(); i++) {  
	    	JSONObject costObject = (JSONObject) cost.get(i);
	        String typeCost = (String) costObject.get("type");
	        int amount = ((Long) costObject.get("amount")).intValue();
	        costMap.put(typeCost, amount);
	    }
	    
	    /*List <String> cost = new ArrayList<String>();
        for (String key: cost1.keySet()){
        	System.out.println( key );
        	
        	keys.add(key);
        	
        } va in card*/
	   
	    Map<String, Integer> immediateEffectMap = new LinkedHashMap();
	    for (int i = 0; i < immediateEffect.size(); i++) {  
	    	JSONObject immediateEffectObject = (JSONObject) immediateEffect.get(i);
	        String typeImmediateEffect = (String) immediateEffectObject.get("type");
	        int amount = ((Long) immediateEffectObject.get("amount")).intValue();
	        immediateEffectMap.put(typeImmediateEffect, amount);
	    }
	    
	    Card c= new BuildingCard(type, name, period, costMap, immediateEffectMap);
	   
		buildingDeck.add(c);
	  }
	 
	 //TerritoryCards
	  JSONParser territoryParser = new JSONParser();
		JSONArray territoryArray = (JSONArray) territoryParser.parse(new FileReader("C:/Users/Sara/Desktop/Polimi/III anno/II semestre/Ingegneria del software_Gianpaolo Cugola/Workspace/Lab1/ProvaFinale-IngSoftware/Carte Torri.json"));
		  for (Object o : territoryArray)
		  {
		    JSONObject card = (JSONObject) o;
		 
		    
		    String type = (String) card.get("type");
		    int period = ((Long) card.get("period")).intValue();
		    String name = (String) card.get("name");
		    
		    JSONArray immediateEffect=(JSONArray) territoryParser.parse (card.get("immediateEffect").toString());
		    
		    Map<String, Integer> immediateEffectMap = new LinkedHashMap();
		    for (int i = 0; i < immediateEffect.size(); i++) {  
		    	JSONObject immediateEffectObject = (JSONObject) immediateEffect.get(i);
		        String typeImmediateEffect = (String) immediateEffectObject.get("type");
		        int amount = ((Long) immediateEffectObject.get("amount")).intValue();
		        immediateEffectMap.put(typeImmediateEffect, amount);
		    }
		    
		    Card c= new TerritoryCard(type, name, period, immediateEffectMap);
		   
			territoryDeck.add(c);
		}

		// VentureDeck
		JSONParser ventureParser = new JSONParser();
		JSONArray ventureArray = (JSONArray) ventureParser.parse(new FileReader("/target/VentureCards.json"));
		for (Object o : ventureArray) {
			JSONObject card = (JSONObject) o;

			String type = (String) card.get("type");
			int period = (int) card.get("period");
			String name = (String) card.get("name");
			int alternativeCostBoolean = (int) card.get("alternativeCostBoolean");
			int militaryRequirement = (int) card.get("militaryRequirement");
			int militaryCost = (int) card.get("militaryCost");
			JSONArray cost = (JSONArray) ventureParser.parse(card.get("cost").toString());

			JSONArray immediateEffect = (JSONArray) ventureParser.parse(card.get("immediateEffect").toString());

			Map<String, Integer> costMap = new LinkedHashMap();
			for (int i = 0; i < cost.size(); i++) {
				JSONObject costObject = (JSONObject) cost.get(i);
				String typeCost = (String) costObject.get("type");
				int amount = (int) costObject.get("amount");
				costMap.put(typeCost, amount);
			}

			Map<String, Integer> immediateEffectMap = new LinkedHashMap();
			for (int i = 0; i < immediateEffect.size(); i++) {
				JSONObject immediateEffectObject = (JSONObject) immediateEffect.get(i);
				String typeImmediateEffect = (String) immediateEffectObject.get("type");
				int amount = (int) immediateEffectObject.get("amount");
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
		JSONArray characterArray = (JSONArray) characterParser.parse(new FileReader("/target/CharacterCards.json"));
		for (Object o : characterArray) {
			JSONObject card = (JSONObject) o;

			String type = (String) card.get("type");
			int period = (int) card.get("period");
			String name = (String) card.get("name");
			int costCoin = (int) card.get("costCoin");
			String bonusCard = (String) card.get("getCard");

			JSONArray immediateEffect = (JSONArray) buildingParser.parse(card.get("immediateEffect").toString());

			Map<String, Integer> immediateEffectMap = new LinkedHashMap();
			for (int i = 0; i < immediateEffect.size(); i++) {
				JSONObject immediateEffectObject = (JSONObject) immediateEffect.get(i);
				String typeImmediateEffect = (String) immediateEffectObject.get("type");
				int amount = (int) immediateEffectObject.get("amount");
				immediateEffectMap.put(typeImmediateEffect, amount);
			}

			if (bonusCard != null) {
				int valueGetCard = (int) card.get("valueGetCard");
				JSONArray discount = (JSONArray) buildingParser.parse(card.get("discount").toString());

				Map<String, Integer> discountMap = new LinkedHashMap();
				for (int i = 0; i < discount.size(); i++) {
					JSONObject discountObject = (JSONObject) discount.get(i);
					String typeDiscount = (String) discountObject.get("typeDiscount");
					int amount = (int) discountObject.get("amount");
					discountMap.put(typeDiscount, amount);
				}

				Card c = new CharacterCard(type, name, period, costCoin, bonusCard, valueGetCard, discountMap,
						immediateEffectMap);
				characterDeck.add(c);
			} else {

				Card c = new CharacterCard(type, name, period, costCoin, immediateEffectMap);
				characterDeck.add(c);
			}

			 /*
			    
			    String type = (String) card.get("type");
			    int period = ((Long) card.get("period")).intValue();
			    String name = (String) card.get("name");
			    int alternativeCostBoolean= ((Long) card.get("alternativeCostBoolean")).intValue();
			    int militaryRequirement=((Long) card.get("militaryRequirement")).intValue();
			    int militaryCost=((Long) card.get("militaryCost")).intValue();
			    JSONArray cost= (JSONArray) ventureParser.parse (card.get("cost").toString());
			    
			    JSONArray immediateEffect=(JSONArray) ventureParser.parse (card.get("immediateEffect").toString());
			    

			    Map<String, Integer> costMap = new LinkedHashMap();
			    for (int i = 0; i < cost.size(); i++) {  
			    	JSONObject costObject = (JSONObject) cost.get(i);
			        String typeCost = (String) costObject.get("type");
			        int amount = ((Long) costObject.get("amount")).intValue();
			        costMap.put(typeCost, amount);
			    }
			    
			    Map<String, Integer> immediateEffectMap = new LinkedHashMap();
			    for (int i = 0; i < immediateEffect.size(); i++) {  
			    	JSONObject immediateEffectObject = (JSONObject) immediateEffect.get(i);
			        String typeImmediateEffect = (String) immediateEffectObject.get("type");
			        int amount =((Long) immediateEffectObject.get("amount")).intValue();
			        immediateEffectMap.put(typeImmediateEffect, amount);
			    }
			    Card c;
			    if(alternativeCostBoolean==1){
			    	 c= new VentureCard(type, name, period, costMap, militaryRequirement, militaryCost, immediateEffectMap);
			    }else if(militaryRequirement==0 && militaryCost==0){
			    	c= new VentureCard(type, name, period, costMap, immediateEffectMap);
			    }else {c=new VentureCard(type, name, period, militaryRequirement, militaryCost, costMap, immediateEffectMap);}
			    
			   
				ventureDeck.add(c);
			  }*/
			  
		  //CharacterCard
			/*
			  JSONParser characterParser = new JSONParser();
				JSONArray characterArray = (JSONArray) characterParser.parse(new FileReader("C:/Users/Sara/Desktop/Polimi/III anno/II semestre/Ingegneria del software_Gianpaolo Cugola/Workspace/Lab1/ProvaFinale-IngSoftware/Carte Torri.json"));
				  for (Object o : characterArray)
				  {
				    JSONObject card = (JSONObject) o;
				 
				    
				    String type = (String) card.get("type");
				    int period = ((Long) card.get("period")).intValue();
				    String name = (String) card.get("name");
				    int costCoin= ((Long) card.get("costCoin")).intValue();
				  
				    
				    JSONArray immediateEffect=(JSONArray) buildingParser.parse (card.get("immediateEffect").toString());
				    
				    Map<String, Integer> immediateEffectMap = new LinkedHashMap();
				    for (int i = 0; i < immediateEffect.size(); i++) {  
				    	JSONObject immediateEffectObject = (JSONObject) immediateEffect.get(i);
				        String typeImmediateEffect = (String) immediateEffectObject.get("type");
				        int amount = ((Long) immediateEffectObject.get("amount")).intValue();
				        immediateEffectMap.put(typeImmediateEffect, amount);
				    }
				    
				    Card c= new CharacterCard(type, name, period, costCoin,  immediateEffectMap);
				   
					characterDeck.add(c);
				  }*/
				 
		 
	  
	  
	  
	
	
	}

}
