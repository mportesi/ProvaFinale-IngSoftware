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

import it.polimi.ingsw.components.FinalVictoryPoint;

public class JsonFinalVictoryPoint {
	private Map <Integer, Integer> finalVictoryPointMap;
	private ArrayList <FinalVictoryPoint> finalVictoryPointList;
	private int victoryPointForTheFirst;
	private int victoryPointForTheSecond;

	
	public void importVictoryPoint() throws FileNotFoundException, IOException, ParseException {
		JSONParser VPForMilitaryParser = new JSONParser();
		Object obj = null;
		JSONObject VPForMilitary = (JSONObject) VPForMilitaryParser.parse(new FileReader("json/VPForMilitary.json"));
		victoryPointForTheFirst = ((Long) VPForMilitary.get("victoryPointForTheFirst")).intValue();
		victoryPointForTheSecond = ((Long) VPForMilitary.get("victoryPointForTheSecond")).intValue();
		
		
		finalVictoryPointList= new ArrayList<FinalVictoryPoint>();
		JSONParser finalVictoryPointParser = new JSONParser();
		JSONArray finalVictoryPointArray = (JSONArray) finalVictoryPointParser.parse(new FileReader("json/finalVictoryPoints.json"));
		for (Object o : finalVictoryPointArray){
			
			JSONObject finalVictoryPoint = (JSONObject) o;
			String type = (String) finalVictoryPoint.get("type");
			
			JSONArray gain = (JSONArray) finalVictoryPointParser.parse(finalVictoryPoint.get("gain").toString());
			
			Map<Integer, Integer> finalVictoryPointMap = new LinkedHashMap<Integer, Integer>();
			for (int i = 0; i < gain.size(); i++) {
				JSONObject gainObject = (JSONObject) gain.get(i);
				int numberOf = ((Long) gainObject.get("numberOf")).intValue();
				int amount = ((Long) gainObject.get("amount")).intValue();
				finalVictoryPointMap.put(numberOf, amount);
				
			FinalVictoryPoint finalVictoryPointClass = new FinalVictoryPoint (type, finalVictoryPointMap);
			finalVictoryPointList.add(finalVictoryPointClass);
		}
			
		}
	}
}
