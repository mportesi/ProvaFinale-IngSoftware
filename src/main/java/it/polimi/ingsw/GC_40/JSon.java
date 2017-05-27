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
import Components.TerritoryCard;
import Components.VentureCard;


public class JSon {
	public static List<Card> buildingDeck = new ArrayList <Card>();
	public static List<Card> territoryDeck = new ArrayList <Card>();
	public static List<Card> ventureDeck = new ArrayList <Card>();
	public static List<Card> characterDeck = new ArrayList <Card>();
	
	public static void importCards() throws FileNotFoundException, IOException, ParseException{
	
	
	
	//BuildingCards
	JSONParser buildingParser = new JSONParser();
	JSONArray buildingArray = (JSONArray) buildingParser.parse(new FileReader("C:/Users/Sara/Desktop/Polimi/III anno/II semestre/Ingegneria del software_Gianpaolo Cugola/Workspace/Lab1/ProvaFinale-IngSoftware/Carte Torri.json"));
	  for (Object o : buildingArray)
	  {
	    JSONObject card = (JSONObject) o;
	 
	    
	    String type = (String) card.get("type");
	    int period = (int) card.get("period");
	    String name = (String) card.get("name");

	    JSONArray cost= (JSONArray) buildingParser.parse (card.get("cost").toString());
	    
	    JSONArray immediateEffect=(JSONArray) buildingParser.parse (card.get("immediateEffect").toString());
	    

	    Map<String, Integer> costMap = new LinkedHashMap();
	    for (int i = 0; i < cost.size(); i++) {  
	    	JSONObject costObject = (JSONObject) cost.get(i);
	        String typeCost = (String) costObject.get("type");
	        int amount = (int) costObject.get("amount");
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
	        int amount = (int) immediateEffectObject.get("amount");
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
		    int period = (int) card.get("period");
		    String name = (String) card.get("name");
		    
		    JSONArray immediateEffect=(JSONArray) territoryParser.parse (card.get("immediateEffect").toString());
		    
		    Map<String, Integer> immediateEffectMap = new LinkedHashMap();
		    for (int i = 0; i < immediateEffect.size(); i++) {  
		    	JSONObject immediateEffectObject = (JSONObject) immediateEffect.get(i);
		        String typeImmediateEffect = (String) immediateEffectObject.get("type");
		        int amount = (int) immediateEffectObject.get("amount");
		        immediateEffectMap.put(typeImmediateEffect, amount);
		    }
		    
		    Card c= new TerritoryCard(type, name, period, immediateEffectMap);
		   
			territoryDeck.add(c);
		  }
		
	//VentureDeck
		  JSONParser ventureParser = new JSONParser();
			JSONArray ventureArray = (JSONArray) ventureParser.parse(new FileReader("C:/Users/Sara/Desktop/Polimi/III anno/II semestre/Ingegneria del software_Gianpaolo Cugola/Workspace/Lab1/ProvaFinale-IngSoftware/Carte Torri.json"));
			  for (Object o : ventureArray)
			  {
			    JSONObject card = (JSONObject) o;
			 
			    
			    String type = (String) card.get("type");
			    int period = (int) card.get("period");
			    String name = (String) card.get("name");
			    int alternativeCostBoolean= (int) card.get("alternativeCostBoolean");
			    int militaryRequirement=(int) card.get("militaryRequirement");
			    int militaryCost=(int) card.get("militaryCost");
			    JSONArray cost= (JSONArray) ventureParser.parse (card.get("cost").toString());
			    
			    JSONArray immediateEffect=(JSONArray) ventureParser.parse (card.get("immediateEffect").toString());
			    

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
			        int amount =(int) immediateEffectObject.get("amount");
			        immediateEffectMap.put(typeImmediateEffect, amount);
			    }
			    Card c;
			    if(alternativeCostBoolean==1){
			    	 c= new VentureCard(type, name, period, costMap, militaryRequirement, militaryCost, immediateEffectMap);
			    }else if(militaryRequirement==0 && militaryCost==0){
			    	c= new VentureCard(type, name, period, costMap, immediateEffectMap);
			    }else {c=new VentureCard(type, name, period, militaryRequirement, militaryCost, costMap, immediateEffectMap);}
			    
			   
				ventureDeck.add(c);
			  }
			  
		  //CharacterCard
			  JSONParser characterParser = new JSONParser();
				JSONArray characterArray = (JSONArray) characterParser.parse(new FileReader("C:/Users/Sara/Desktop/Polimi/III anno/II semestre/Ingegneria del software_Gianpaolo Cugola/Workspace/Lab1/ProvaFinale-IngSoftware/Carte Torri.json"));
				  for (Object o : characterArray)
				  {
				    JSONObject card = (JSONObject) o;
				 
				    
				    String type = (String) card.get("type");
				    int period = (int) card.get("period");
				    String name = (String) card.get("name");
				    int costCoin= (int) card.get("costCoin");
				  
				    
				    JSONArray immediateEffect=(JSONArray) buildingParser.parse (card.get("immediateEffect").toString());
				    
				    Map<String, Integer> immediateEffectMap = new LinkedHashMap();
				    for (int i = 0; i < immediateEffect.size(); i++) {  
				    	JSONObject immediateEffectObject = (JSONObject) immediateEffect.get(i);
				        String typeImmediateEffect = (String) immediateEffectObject.get("type");
				        int amount = (int) immediateEffectObject.get("amount");
				        immediateEffectMap.put(typeImmediateEffect, amount);
				    }
				    
				    Card c= new CharacterCard(type, name, period, costCoin,  immediateEffectMap);
				   
					characterDeck.add(c);
				  }
				 
		 
	  
	  
	  
	
	
	}
	
	}
