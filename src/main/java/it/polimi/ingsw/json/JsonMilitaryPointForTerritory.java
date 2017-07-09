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


/**
 * @author Chiara
 * In this class all the number of victory points necessary to take the territory cards are imported from json.
 *
 */

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
	setForTheFirstCard(((Long) militaryPointForT.get("forTheFirstCard")).intValue());
	setForTheSecondCard(((Long) militaryPointForT.get("forTheSecondCard")).intValue());
	setForTheThirdCard(((Long) militaryPointForT.get("forTheThirdCard")).intValue());
	setForTheFourthCard(((Long) militaryPointForT.get("forTheFourthCard")).intValue());
	setForTheFifthCard(((Long) militaryPointForT.get("forTheFifthCard")).intValue());
	setForTheSixthCard(((Long) militaryPointForT.get("forTheSixthCard")).intValue());

}



public int getForTheFirstCard() {
	return forTheFirstCard;
}



public void setForTheFirstCard(int forTheFirstCard) {
	this.forTheFirstCard = forTheFirstCard;
}



public int getForTheSecondCard() {
	return forTheSecondCard;
}



public void setForTheSecondCard(int forTheSecondCard) {
	this.forTheSecondCard = forTheSecondCard;
}



public int getForTheThirdCard() {
	return forTheThirdCard;
}



public void setForTheThirdCard(int forTheThirdCard) {
	this.forTheThirdCard = forTheThirdCard;
}



public int getForTheFourthCard() {
	return forTheFourthCard;
}



public void setForTheFourthCard(int forTheFourthCard) {
	this.forTheFourthCard = forTheFourthCard;
}



public int getForTheFifthCard() {
	return forTheFifthCard;
}



public void setForTheFifthCard(int forTheFifthCard) {
	this.forTheFifthCard = forTheFifthCard;
}



public int getForTheSixthCard() {
	return forTheSixthCard;
}



public void setForTheSixthCard(int forTheSixthCard) {
	this.forTheSixthCard = forTheSixthCard;
}
}