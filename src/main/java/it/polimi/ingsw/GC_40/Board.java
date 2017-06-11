package it.polimi.ingsw.GC_40;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.areas.CouncilPalace;
import it.polimi.ingsw.areas.Floor;
import it.polimi.ingsw.areas.HarvestAndProductionArea;
import it.polimi.ingsw.areas.MarketBuilding;
import it.polimi.ingsw.areas.Tower;
import it.polimi.ingsw.cards.Card;
import it.polimi.ingsw.changes.Change;
import it.polimi.ingsw.colors.ColorDice;
import it.polimi.ingsw.components.Dice;
import it.polimi.ingsw.components.PersonalBonusTile;
import it.polimi.ingsw.json.JsonCard;
import it.polimi.ingsw.json.JsonCouncilPalace;
import it.polimi.ingsw.json.JsonFloor;
import it.polimi.ingsw.json.JsonHarvestAndProduction;
import it.polimi.ingsw.json.JsonMarket;
import it.polimi.ingsw.json.JsonPersonalBonusTiles;

public class Board  extends Observable<Change> implements Serializable{
	private Tower territoryTower;
	private Tower characterTower;
	private Tower buildingTower;
	private Tower ventureTower;
	private CouncilPalace councilPalace;
	private ArrayList<MarketBuilding> market;
	private HarvestAndProductionArea harvestArea;
	private HarvestAndProductionArea productionArea;
	private Dice blackDice;
	private Dice whiteDice;
	private Dice orangeDice;
	private ArrayList<Card> deck;
	
	
	
	public Board() throws FileNotFoundException, NullPointerException, IOException, ParseException{
		JsonCard jsonCard= new JsonCard();
		jsonCard.importCards();
		deck=new ArrayList<Card>();
		create(jsonCard);
		ArrayList<Card> territory1= createDeck(1, "territory");
		ArrayList<Card> territory2= createDeck(2, "territory");
		ArrayList<Card> territory3= createDeck(3, "territory");
		ArrayList<Card> building1= createDeck(1, "building");
		ArrayList<Card> building2= createDeck(2, "building");
		ArrayList<Card> building3= createDeck(3, "building");
		ArrayList<Card> character1= createDeck(1, "characterCard");
		ArrayList<Card> character2= createDeck(2, "characterCard");
		ArrayList<Card> character3= createDeck(3, "characterCard");
		ArrayList<Card> venture1= createDeck(1, "ventureCard");
		ArrayList<Card> venture2= createDeck(2, "ventureCard");
		ArrayList<Card> venture3= createDeck(3, "ventureCard");
		
		Collections.shuffle(territory1);
		Collections.shuffle(territory2);
		Collections.shuffle(territory3);
		Collections.shuffle(building1);
		Collections.shuffle(building2);
		Collections.shuffle(building3);
		Collections.shuffle(character1);
		Collections.shuffle(character2);
		Collections.shuffle(character3);
		Collections.shuffle(venture1);
		Collections.shuffle(venture2);
		Collections.shuffle(venture3);
		
		JsonFloor jsonFloor= new JsonFloor();
		jsonFloor.importFloors();
		territoryTower= new Tower("territory", territory1, territory2, territory3, jsonFloor.getTerritoryFloors());
		/*for (int i =0; i< territory1.size(); i++){
		System.out.println("carta territorio: " + territory1.get(i));
		}
		for (int i =0; i< jsonFloor.getTerritoryFloors().size(); i++){
			System.out.println("Ho creato il piano territory: " + jsonFloor.getTerritoryFloors().get(i));
			System.out.println("Piano della torre: " + territoryTower.floors.get(i));
			
			}*/
		
		buildingTower= new Tower("building", building1, building2, building3, jsonFloor.getBuildingFloors());
		/*for (int i =0; i< building1.size(); i++){
			System.out.println("carta building: " + building1.get(i));
			}
		for (int i =0; i< jsonFloor.getBuildingFloors().size(); i++){
			System.out.println("Ho creato il piano building: " + jsonFloor.getBuildingFloors().get(i));
			System.out.println("Piano della torre: " + buildingTower.floors.get(i));
			
			}*/
		
		characterTower= new Tower("character", character1, character2, character3, jsonFloor.getCharacterFloors());
		/*for (int i =0; i< character1.size(); i++){
			System.out.println("carta character: " + character1.get(i));
			}
		for (int i =0; i< jsonFloor.getCharacterFloors().size(); i++){
			System.out.println("Ho creato il piano character: " + jsonFloor.getCharacterFloors().get(i));
			System.out.println("Piano della torre: " + characterTower.floors.get(i));
			
			}*/
		
		ventureTower= new Tower("venture", venture1, venture2, venture3, jsonFloor.getVentureFloors());
		/*for (int i =0; i< venture1.size(); i++){
			System.out.println("carta venture: " + venture1.get(i));
			}
		for (int i =0; i< jsonFloor.getVentureFloors().size(); i++){
			System.out.println("Ho creato il piano venture: " + jsonFloor.getVentureFloors().get(i));
			System.out.println("Piano della torre: " + ventureTower.floors.get(i));
			
			}*/
		//System.out.println(jsonFloor.getTerritoryFloors());
		territoryTower= new Tower("territory", territory1, territory2, territory3, jsonFloor.getTerritoryFloors());
		buildingTower= new Tower("building", building1, building2, building3, jsonFloor.getBuildingFloors());
		characterTower= new Tower("character", character1, character2, character3, jsonFloor.getCharacterFloors());
		ventureTower= new Tower("venture", venture1, venture2, venture3, jsonFloor.getVentureFloors());
		
		JsonCouncilPalace jsonCouncil= new JsonCouncilPalace();
		jsonCouncil.importCouncilPalace();
		
		councilPalace = jsonCouncil.getCouncilPalace();

		
		//lista di market
		market= new ArrayList<MarketBuilding>();
		JsonMarket jsonMarket= new  JsonMarket();
		jsonMarket.importMarket();
		for(int i=0; i<4; i++){
			market.add(i, jsonMarket.getMarketBuilding(i));
		}
		
		JsonPersonalBonusTiles jsonPersonalBonusTiles= new JsonPersonalBonusTiles();
		jsonPersonalBonusTiles.importPersonalBonusTiles();
		PersonalBonusTile personalBonusTileSimple = jsonPersonalBonusTiles.getPersonalBonusTiles(0);
		PersonalBonusTile personalBonusTileAdvanced = jsonPersonalBonusTiles.getPersonalBonusTiles(1);
		
		
		JsonHarvestAndProduction jsonHarvestAndProduction = new JsonHarvestAndProduction();
		jsonHarvestAndProduction.importHarvestAndProduction();
		System.out.println("harvest " + jsonHarvestAndProduction.getHarvest());
		harvestArea = jsonHarvestAndProduction.getHarvest();
		productionArea = jsonHarvestAndProduction.getProduction();
		
		
		blackDice = new Dice(ColorDice.BLACK);
		whiteDice = new Dice(ColorDice.WHITE);
		orangeDice = new Dice(ColorDice.ORANGE);
	}
	
	

	
		public void create(JsonCard jsonCard){
		for (Card card : jsonCard.getCharacterDeck()){
			 deck.add(card);
		}
		for (Card card : jsonCard.getBuildingDeck()){
			 deck.add(card);
		}
		for (Card card : jsonCard.getTerritoryDeck()){
			 deck.add(card);
		}
		for (Card card : jsonCard.getVentureDeck()){
			 deck.add(card);
		}
		}
		
		public ArrayList<Card> createDeck(int period, String type) throws FileNotFoundException, NullPointerException, IOException, ParseException {
			
			ArrayList<Card> newDeck= new ArrayList<Card>();
			for(Card c:deck){
				if (c.getType().equals(type) && c.getPeriod()==period){
					newDeck.add(c);
					
					}
			}
			/*for(int i=0; i<newDeck.size(); i++){
				System.out.println(newDeck.get(i));
			}*/
			return newDeck;
			
			
		}


	@Override
	public String toString() {
		return ("Board" + "\n" + territoryTower + "\n" + buildingTower +  "\n" + characterTower + "\n" + ventureTower
				+ "\n" + councilPalace
				+ "\n" + market.get(0) + "\n" + market.get(1) + "\n" + market.get(1) + "\n" + market.get(2)
				+ "\n" + harvestArea 
				+ "\n" + productionArea 
				+ "\n" + blackDice + "\n" + whiteDice + "\n" + orangeDice);
	}


	public CouncilPalace getCouncilPalace() {
		// TODO Auto-generated method stub
		return councilPalace;
	}

	public Tower getTerritoryTower() {
		return territoryTower;
	}
	
	public Tower getBuildingTower() {
		return buildingTower;
	}




	public Tower getCharacterTower() {
		return characterTower;
	}




	public Tower getVentureTower() {
		return ventureTower;
	}





	public HarvestAndProductionArea getHarvestArea() {
		return harvestArea;
	}




	public HarvestAndProductionArea getProductionArea() {
		return productionArea;
	}




	public Dice getBlackDice() {
		return blackDice;
	}




	public Dice getWhiteDice() {
		return whiteDice;
	}




	public Dice getOrangeDice() {
		return orangeDice;
	}




	public ArrayList<Card> getDeck() {
		return deck;
	}

	public MarketBuilding getMarket(int i) {
		return market.get(i);
	}





	public ArrayList<MarketBuilding> getMarket() {
		return market;
	}

}
