package it.polimi.ingsw.json;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import it.polimi.ingsw.areas.MarketBuilding;
import it.polimi.ingsw.areas.MarketListOfEffect;

public class JsonMarket {
	private ArrayList <MarketBuilding> marketBuilding;
	
	public void importMarket() throws FileNotFoundException, IOException, ParseException {
	marketBuilding= new ArrayList<MarketBuilding>();
	JSONParser marketParser = new JSONParser();
	JSONArray marketArray = (JSONArray) marketParser.parse(new FileReader("json/MarketBonus.json"));
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
		}
		System.out.println(bonusMap);
		MarketListOfEffect marketEffect = new MarketListOfEffect(bonusMap);
		MarketBuilding m = new MarketBuilding (type, marketEffect, costOfMarket);
		marketBuilding.add(m);
		
		System.out.println("STAMPO I MARKET"+m);
		
	
		
	}
	
	}

	public MarketBuilding getMarketBuilding(int i) throws FileNotFoundException, IOException, ParseException {
		
		// TODO Auto-generated method stub
		return marketBuilding.get(i);
	}
}
