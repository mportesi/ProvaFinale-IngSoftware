package it.polimi.ingsw.json;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import it.polimi.ingsw.areas.Floor;
import it.polimi.ingsw.effects.GainCoin;
import it.polimi.ingsw.effects.GainMilitaryPoint;
import it.polimi.ingsw.effects.GainStone;
import it.polimi.ingsw.effects.GainWood;

public class JsonFloor {
	private ArrayList<Floor> territoryFloors;
	private ArrayList<Floor> characterFloors; 
	private ArrayList<Floor> buildingFloors ;
	private ArrayList<Floor> ventureFloors; 
	
	public void importFloors() throws FileNotFoundException, IOException, ParseException {
		territoryFloors= new ArrayList<Floor>();
		characterFloors= new ArrayList<Floor>();
		ventureFloors= new ArrayList<Floor>();
		buildingFloors= new ArrayList<Floor>();
		JSONParser floorParser = new JSONParser();
		JSONArray floorArray = (JSONArray) floorParser.parse(new FileReader("json/Floors.json"));
		for (Object o : floorArray) {
			JSONObject floor = (JSONObject) o;

			String type = (String) floor.get("type");
			int costOfFloor = ((Long) floor.get("cost")).intValue();
			int amountBonus = ((Long) floor.get("amountBonus")).intValue();

			switch (type) {
			case "territory": {
				GainWood e = new GainWood(amountBonus);
				Floor f = new Floor(type, costOfFloor, e);
				if(amountBonus==0){
					 f = new Floor(type, costOfFloor, null);
				}
				territoryFloors.add(f);
				break;
			}
			case "character": {
				GainStone e = new GainStone(amountBonus);
				Floor f = new Floor(type, costOfFloor, e);
				if(amountBonus==0){
					f = new Floor(type, costOfFloor, null);
				}
				characterFloors.add(f);
				break;
			}
			case "building": {
				GainMilitaryPoint e = new GainMilitaryPoint(amountBonus);
				Floor f = new Floor(type, costOfFloor, e);
				if(amountBonus==0){
					 f = new Floor(type, costOfFloor, null);
				}
				buildingFloors.add(f);
				break;
			}
			case "venture": {
				GainCoin e = new GainCoin(amountBonus);
				Floor f = new Floor(type, costOfFloor, e);
				if(amountBonus==0){
					 f = new Floor(type, costOfFloor, null);
				}
				ventureFloors.add(f);
				break;
			}
			}
		}
	}

	public ArrayList<Floor> getTerritoryFloors()  {
		return territoryFloors;
	}
	
	public ArrayList<Floor> getBuildingFloors()  {
		return buildingFloors;
	}
	
	public ArrayList<Floor> getVentureFloors()  {
		return ventureFloors;
	}
	
	public ArrayList<Floor> getCharacterFloors() {
		return characterFloors;
	}

}
