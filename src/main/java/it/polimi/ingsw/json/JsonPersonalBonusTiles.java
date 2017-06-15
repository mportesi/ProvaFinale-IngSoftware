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

import it.polimi.ingsw.components.PersonalBonusTile;
import it.polimi.ingsw.components.PersonalBonusTileListOfHarvestEffect;
import it.polimi.ingsw.components.PersonalBonusTileListOfProductionEffect;

public class JsonPersonalBonusTiles {
	private ArrayList <PersonalBonusTile> personalBonusTiles;
	
	public  void importPersonalBonusTiles() throws FileNotFoundException, IOException, ParseException {
		personalBonusTiles= new ArrayList<PersonalBonusTile>();
		JSONParser personalBonusTileParser = new JSONParser();
		JSONArray personalBonusTileArray = (JSONArray) personalBonusTileParser.parse(new FileReader("json/tesseraBonus.json"));
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
			
			System.out.println(bonusProductionMap);
			System.out.println(bonusHarvestMap);
			
			PersonalBonusTileListOfProductionEffect personalBonusTileProductionListOfEffect = new PersonalBonusTileListOfProductionEffect (bonusProductionMap);
			PersonalBonusTileListOfHarvestEffect personalBonusTileHarvestListOfEffect = new PersonalBonusTileListOfHarvestEffect (bonusHarvestMap);
			
			PersonalBonusTile personalBonusTile1 = new PersonalBonusTile (type, personalBonusTileProductionListOfEffect, personalBonusTileHarvestListOfEffect, costProduction, costHarvest);
			personalBonusTiles.add(personalBonusTile1);
			System.out.println(personalBonusTile1);
			}
			
		
	}

	public PersonalBonusTile getPersonalBonusTiles(int i) {
		
		// TODO Auto-generated method stub
		return personalBonusTiles.get(i);
	}

}
