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

import it.polimi.ingsw.components.FinalVictoryPoint;

/**
 * @author Chiara
 * In this class all the victory point for the final ranking are imported from json.
 *
 */

public class JsonFinalVictoryPoint {
	private ArrayList <FinalVictoryPoint> finalVictoryPointList;

	public void importVictoryPoint() throws FileNotFoundException, IOException, ParseException {
		finalVictoryPointList = new ArrayList <FinalVictoryPoint>();
		JSONParser finalVictoryPointParser = new JSONParser();
		JSONArray finalVictoryPointArray = (JSONArray) finalVictoryPointParser.parse(new FileReader("json/finalVictoryPoint.json"));
		for (Object o : finalVictoryPointArray){
			
			JSONObject finalVictoryPoint = (JSONObject) o;
			String type = (String) finalVictoryPoint.get("type");
			int victoryPointForOne = ((Long) finalVictoryPoint.get("victoryPointForOne")).intValue();
			int victoryPointForTwo = ((Long) finalVictoryPoint.get("victoryPointForTwo")).intValue();
			int victoryPointForThree = ((Long) finalVictoryPoint.get("victoryPointForThree")).intValue();
			int victoryPointForFour = ((Long) finalVictoryPoint.get("victoryPointForFour")).intValue();
			int victoryPointForFive = ((Long) finalVictoryPoint.get("victoryPointForFive")).intValue();
			int victoryPointForSix = ((Long) finalVictoryPoint.get("victoryPointForSix")).intValue();
			
			FinalVictoryPoint finalVictoryPoints = new FinalVictoryPoint (type, victoryPointForOne, victoryPointForTwo, victoryPointForThree, victoryPointForFour, victoryPointForFive, victoryPointForSix);
			finalVictoryPointList.add(finalVictoryPoints);
			
			

		}
	
}
	public ArrayList<FinalVictoryPoint> getFinalVictoryPointList(){
		return finalVictoryPointList;
	}
}
