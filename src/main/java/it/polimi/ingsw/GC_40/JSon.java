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

import Components.Building;
import Components.Card;
import Components.Territory;


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
	    Long period = (Long) card.get("period");
	    String name = (String) card.get("name");

	    JSONArray cost= (JSONArray) buildingParser.parse (card.get("cost").toString());
	    
	    JSONArray immediateEffect=(JSONArray) buildingParser.parse (card.get("immediateEffect").toString());
	    

	    Map<String, Long> costMap = new LinkedHashMap();
	    for (int i = 0; i < cost.size(); i++) {  
	    	JSONObject costObject = (JSONObject) cost.get(i);
	        String typeCost = (String) costObject.get("type");
	        Long amount = (Long) costObject.get("amount");
	        costMap.put(typeCost, amount);
	    }
	    
	    /*List <String> cost = new ArrayList<String>();
        for (String key: cost1.keySet()){
        	System.out.println( key );
        	
        	keys.add(key);
        	
        } va in card*/
	   
	    Map<String, Long> immediateEffectMap = new LinkedHashMap();
	    for (int i = 0; i < immediateEffect.size(); i++) {  
	    	JSONObject immediateEffectObject = (JSONObject) immediateEffect.get(i);
	        String typeImmediateEffect = (String) immediateEffectObject.get("type");
	        Long amount = (Long) immediateEffectObject.get("amount");
	        immediateEffectMap.put(typeImmediateEffect, amount);
	    }
	    
	    Card c= new Building(type, name, period, costMap, immediateEffectMap);
	   
		buildingDeck.add(c);
	  }
	 
	 //TerritoryCards
	  JSONParser territoryParser = new JSONParser();
		JSONArray territoryArray = (JSONArray) territoryParser.parse(new FileReader("C:/Users/Sara/Desktop/Polimi/III anno/II semestre/Ingegneria del software_Gianpaolo Cugola/Workspace/Lab1/ProvaFinale-IngSoftware/Carte Torri.json"));
		  for (Object o : territoryArray)
		  {
		    JSONObject card = (JSONObject) o;
		 
		    
		    String type = (String) card.get("type");
		    Long period = (Long) card.get("period");
		    String name = (String) card.get("name");
		    
		    JSONArray immediateEffect=(JSONArray) territoryParser.parse (card.get("immediateEffect").toString());
		    
		    Map<String, Long> immediateEffectMap = new LinkedHashMap();
		    for (int i = 0; i < immediateEffect.size(); i++) {  
		    	JSONObject immediateEffectObject = (JSONObject) immediateEffect.get(i);
		        String typeImmediateEffect = (String) immediateEffectObject.get("type");
		        Long amount = (Long) immediateEffectObject.get("amount");
		        immediateEffectMap.put(typeImmediateEffect, amount);
		    }
		    
		    Card c= new Territory(type, name, period, immediateEffectMap);
		   
			territoryDeck.add(c);
		  }
		
	//VentureDeck
		  JSONParser ventureParser = new JSONParser();
			JSONArray ventureArray = (JSONArray) ventureParser.parse(new FileReader("C:/Users/Sara/Desktop/Polimi/III anno/II semestre/Ingegneria del software_Gianpaolo Cugola/Workspace/Lab1/ProvaFinale-IngSoftware/Carte Torri.json"));
			  for (Object o : ventureArray)
			  {
			    JSONObject card = (JSONObject) o;
			 
			    
			    String type = (String) card.get("type");
			    Long period = (Long) card.get("period");
			    String name = (String) card.get("name");
			    Long alternativeCost= (Long) card.get("alternativeCost");
			    
			    JSONArray cost= (JSONArray) ventureParser.parse (card.get("cost").toString());
			    
			    JSONArray immediateEffect=(JSONArray) ventureParser.parse (card.get("immediateEffect").toString());
			    

			    Map<String, Long> costMap = new LinkedHashMap();
			    for (int i = 0; i < cost.size(); i++) {  
			    	JSONObject costObject = (JSONObject) cost.get(i);
			        String typeCost = (String) costObject.get("type");
			        Long amount = (Long) costObject.get("amount");
			        costMap.put(typeCost, amount);
			    }
			    
			    if(alternativeCost==1){
			    	JSONArray alternativeCostArray= (JSONArray) ventureParser.parse (card.get("alternativeCost").toString());
			    	Map<String, Long> alternativeCostMap = new LinkedHashMap();
				    for (int i = 0; i < alternativeCostArray.size(); i++) {  
				    	JSONObject costObject = (JSONObject) alternativeCostArray.get(i);
				        String typeCost = (String) costObject.get("type");
				        Long amount = (Long) costObject.get("amount");
				        alternativeCostMap.put(typeCost, amount);
				    }
			    }
			    
			    Map<String, Long> immediateEffectMap = new LinkedHashMap();
			    for (int i = 0; i < immediateEffect.size(); i++) {  
			    	JSONObject immediateEffectObject = (JSONObject) immediateEffect.get(i);
			        String typeImmediateEffect = (String) immediateEffectObject.get("type");
			        Long amount = (Long) immediateEffectObject.get("amount");
			        immediateEffectMap.put(typeImmediateEffect, amount);
			    }
			    
			    if(alternativeCost==1){
			    	Card c= new Venture(type, name, period, costMap, alternativeCostMap, immediateEffectMap);
			    	
			    }else{
			    	Card c= new Venture(type, name, period, costMap, immediateEffectMap);
			    }
			    
			   
				ventureDeck.add(c);
			  }
			  
		  //CharacterCard
			  JSONParser characterParser = new JSONParser();
				JSONArray characterArray = (JSONArray) characterParser.parse(new FileReader("C:/Users/Sara/Desktop/Polimi/III anno/II semestre/Ingegneria del software_Gianpaolo Cugola/Workspace/Lab1/ProvaFinale-IngSoftware/Carte Torri.json"));
				  for (Object o : characterArray)
				  {
				    JSONObject card = (JSONObject) o;
				 
				    
				    String type = (String) card.get("type");
				    Long period = (Long) card.get("period");
				    String name = (String) card.get("name");
				    Long costCoin= (Long) card.get("costCoin")
				  
				    
				    JSONArray immediateEffect=(JSONArray) buildingParser.parse (card.get("immediateEffect").toString());
				    
				    Map<String, Long> immediateEffectMap = new LinkedHashMap();
				    for (int i = 0; i < immediateEffect.size(); i++) {  
				    	JSONObject immediateEffectObject = (JSONObject) immediateEffect.get(i);
				        String typeImmediateEffect = (String) immediateEffectObject.get("type");
				        Long amount = (Long) immediateEffectObject.get("amount");
				        immediateEffectMap.put(typeImmediateEffect, amount);
				    }
				    
				    Card c= new Character(type, name, period, costCoin, immediateEffectMap);
				   
					characterDeck.add(c);
				  }
				 
		 
	  
	  
	  
	
	
	}
	
	}
