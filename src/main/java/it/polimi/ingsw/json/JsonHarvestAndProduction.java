package it.polimi.ingsw.json;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import it.polimi.ingsw.areas.HarvestAndProductionArea;

/**
 * @author Chiara
 * In this class all the costs associated to the harvest and productiona areas are imported from json.
 *
 */

public class JsonHarvestAndProduction {
	private HarvestAndProductionArea harvest;
	private HarvestAndProductionArea production;
	
	public void importHarvestAndProduction() throws FileNotFoundException, IOException, ParseException {
		JSONParser harvestAndProductionParser = new JSONParser();
		JSONArray harvestAndProductionArray = (JSONArray) harvestAndProductionParser.parse(new FileReader("json/harvestAndProductionArea.json"));
		for (Object o : harvestAndProductionArray) {
			JSONObject harvestAndProduction = (JSONObject) o;

			String type = (String) harvestAndProduction.get("type");
			int costOfLeftArea = ((Long) harvestAndProduction.get("costOfLeftArea")).intValue();
			int costOfRightArea = ((Long) harvestAndProduction.get("costOfRightArea")).intValue();
			int malus = ((Long) harvestAndProduction.get("malus")).intValue();
			
			switch (type){
			case "productionArea": {
				production = new HarvestAndProductionArea (type, costOfLeftArea, costOfRightArea, malus);
				break;
			}
			case "harvestArea": {
				harvest = new HarvestAndProductionArea (type, costOfLeftArea, costOfRightArea, malus);
				break;
			}
			}
			
		}
			
	}
	
	public void importHarvestAndProductionWith3Players() throws FileNotFoundException, IOException, ParseException{
		JSONParser harvestAndProductionParser = new JSONParser();
		JSONArray harvestAndProductionArray = (JSONArray) harvestAndProductionParser.parse(new FileReader("json/harvestAndProductionArea.json"));
		for (Object o : harvestAndProductionArray) {
			JSONObject harvestAndProduction = (JSONObject) o;

			String type = (String) harvestAndProduction.get("type");
			int costOfLeftArea = ((Long) harvestAndProduction.get("costOfLeftArea")).intValue();
			
			switch (type){
			case "productionArea": {
				production = new HarvestAndProductionArea (type, costOfLeftArea);
				break;
			}
			case "harvestArea": {
				harvest = new HarvestAndProductionArea (type, costOfLeftArea);
				break;
			}
			}
			
		}
	}

	public HarvestAndProductionArea getHarvest() {
		return harvest;
	}
	public HarvestAndProductionArea getProduction() {
		return production;
	}

}
