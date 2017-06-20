package it.polimi.ingsw.json;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import it.polimi.ingsw.components.FinalVictoryPoint;

public class JsonTimeOut {
	private int timeOutAction;
	private int timeOutStartPlay;

public JsonTimeOut() throws FileNotFoundException, IOException, ParseException{
	importTimeOut();
}

public void importTimeOut() throws FileNotFoundException, IOException, ParseException {
		
		    JSONParser timeOutParser = new JSONParser();
		
			
			JSONObject timeOut = (JSONObject) timeOutParser.parse(new FileReader("json/timeOut.json"));;
			
			timeOutAction = ((Long) timeOut.get("timeOutAction")).intValue();

			timeOutStartPlay = ((Long) timeOut.get("timeOutStartPlay")).intValue();
			
			
			
			

		}

public int getTimeOutAction() {
	return timeOutAction;
}



public int getTimeOutStartPlay() {
	return timeOutStartPlay;
}


	
}
