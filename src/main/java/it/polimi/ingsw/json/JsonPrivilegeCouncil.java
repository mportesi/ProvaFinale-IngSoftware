package it.polimi.ingsw.json;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import it.polimi.ingsw.components.PrivilegeCouncil;

public class JsonPrivilegeCouncil {
	private PrivilegeCouncil privilegeCouncil;
	
	public void importPrivilegeCouncil() throws FileNotFoundException, IOException, ParseException {

		JSONParser privilegeCouncilParser = new JSONParser();
		JSONObject privilegeCouncilObj = (JSONObject) privilegeCouncilParser.parse(new FileReader("json/privilegeCouncil.json"));
		
		int bonusWoodAndStone = ((Long) privilegeCouncilObj.get("bonusWoodAndStone")).intValue();
		int bonusServant = ((Long) privilegeCouncilObj.get("bonusServant")).intValue();
		int bonusCoinP = ((Long) privilegeCouncilObj.get("bonusCoin")).intValue();
		int bonusMilitaryPoint = ((Long) privilegeCouncilObj.get("bonusMilitaryPoint")).intValue();
		int bonusFaithPoint = ((Long) privilegeCouncilObj.get("bonusFaithPoint")).intValue();
		
		privilegeCouncil = new PrivilegeCouncil(bonusWoodAndStone, bonusServant, bonusCoinP, bonusMilitaryPoint, bonusFaithPoint);
}
	public PrivilegeCouncil getPrivilegeCouncil(){
		return privilegeCouncil;
	}
}
