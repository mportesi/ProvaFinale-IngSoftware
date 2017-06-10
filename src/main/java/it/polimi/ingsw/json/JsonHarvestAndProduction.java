package it.polimi.ingsw.json;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import it.polimi.ingsw.areas.HarvestAndProductionArea;

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
				System.out.println("sono in json voglio stampare la production" + production);
				break;
			}
			case "harvestArea": {
				harvest = new HarvestAndProductionArea (type, costOfLeftArea, costOfRightArea, malus);
				break;
			}
			}
			
		}
			
	}

	public HarvestAndProductionArea getHarvest() {
	
		// TODO Auto-generated method stub
		return harvest;
	}
	public HarvestAndProductionArea getProduction() {
	
		// TODO Auto-generated method stub
		return production;
	}

}
