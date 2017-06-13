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

public class JsonMilitaryPointForTerritory {
	private int forTheFirstCard;
	private int forTheSecondCard;
	private int forTheThirdCard;
	private int forTheFourthCard;
	private int forTheFifthCard;
	private int forTheSixthCard;



public void importMilitaryPointForTerritory() throws FileNotFoundException, IOException, ParseException {
	JSONParser militaryPointForTParser = new JSONParser();
	Object obj = null;
	JSONObject militaryPointForT = (JSONObject) militaryPointForTParser.parse(new FileReader("json/MilitaryPointForTerritory.json"));
	forTheFirstCard = ((Long) militaryPointForT.get("forTheFirstCard")).intValue();
	forTheSecondCard = ((Long) militaryPointForT.get("forTheSecondCard")).intValue();
	forTheThirdCard = ((Long) militaryPointForT.get("forTheThirdCard")).intValue();
	forTheFourthCard = ((Long) militaryPointForT.get("forTheFourthCard")).intValue();
	forTheFifthCard = ((Long) militaryPointForT.get("forTheFifthCard")).intValue();
	forTheSixthCard = ((Long) militaryPointForT.get("forTheSixthCard")).intValue();

}
}