package it.polimi.ingsw.json;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import it.polimi.ingsw.areas.CouncilPalace;

public class JsonCouncilPalace {
	private CouncilPalace councilPalace;
	
	public void  importCouncilPalace() throws FileNotFoundException, IOException, ParseException {
	
	JSONParser councilPalaceParser = new JSONParser();
	JSONObject councilPalaceObj = (JSONObject) councilPalaceParser.parse(new FileReader("json/CouncilPalace.json"));
	
	int bonusPrivilegeCouncil = ((Long) councilPalaceObj.get("bonusPrivilegeCouncil")).intValue();
	int bonusCoin = ((Long) councilPalaceObj.get("bonusCoin")).intValue();
	int cost = ((Long) councilPalaceObj.get("cost")).intValue();
	
	councilPalace = new CouncilPalace(bonusPrivilegeCouncil, bonusCoin, cost);
	System.out.println ("il councilPalace è" + councilPalace);
	}

	public CouncilPalace getCouncilPalace(){
	
		// TODO Auto-generated method stub
		return councilPalace;
	}
}
