package it.polimi.ingsw.GC_40;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.UUID;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.areas.CouncilPalace;
import it.polimi.ingsw.areas.Floor;
import it.polimi.ingsw.areas.HarvestAndProductionArea;
import it.polimi.ingsw.areas.MarketBuilding;
import it.polimi.ingsw.areas.Tower;
import it.polimi.ingsw.cards.Card;
import it.polimi.ingsw.changes.Change;
import it.polimi.ingsw.changes.ChangeCouncilPalace;
import it.polimi.ingsw.changes.ChangePeriod;
import it.polimi.ingsw.colors.ColorDice;
import it.polimi.ingsw.components.Dice;
import it.polimi.ingsw.components.PersonalBonusTile;
import it.polimi.ingsw.components.PrivilegeCouncil;
import it.polimi.ingsw.components.Relative;
import it.polimi.ingsw.json.JsonCard;
import it.polimi.ingsw.json.JsonCouncilPalace;
import it.polimi.ingsw.json.JsonFloor;
import it.polimi.ingsw.json.JsonHarvestAndProduction;
import it.polimi.ingsw.json.JsonMarket;
import it.polimi.ingsw.json.JsonPersonalBonusTiles;
import it.polimi.ingsw.json.JsonPrivilegeCouncil;

public class Board  extends Observable<Change> implements Serializable{
	private Tower territoryTower;
	private Tower characterTower;
	private Tower buildingTower;
	private Tower ventureTower;
	private CouncilPalace councilPalace;
	private PrivilegeCouncil privilegeCouncil;
	private ArrayList<MarketBuilding> market;
	private HarvestAndProductionArea harvestArea;
	private HarvestAndProductionArea productionArea;
	private Dice blackDice;
	private Dice whiteDice;
	private Dice orangeDice;
	private ArrayList<Card> deck;
	
	
	
	public Board(Play play) throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException{
		JsonCard jsonCard= new JsonCard();
		jsonCard.importCards();
		deck = new ArrayList<Card>();
		create(jsonCard);
		ArrayList<Card> territory1= createDeck(1, "territoryCard");
		ArrayList<Card> territory2= createDeck(2, "territoryCard");
		ArrayList<Card> territory3= createDeck(3, "territoryCard");
		ArrayList<Card> building1= createDeck(1, "buildingCard");
		ArrayList<Card> building2= createDeck(2, "buildingCard");
		ArrayList<Card> building3= createDeck(3, "buildingCard");
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
		
		JsonFloor jsonFloor = new JsonFloor();
		jsonFloor.importFloors();
		ArrayList<Floor> territoryFloorJson=jsonFloor.getTerritoryFloors();
		ArrayList<Floor> territoryFloor= new ArrayList<>();
		for(Floor f: territoryFloorJson){
		territoryFloor.add(new Floor(f, play));}
		territoryTower = new Tower("territory", territory1, territory2, territory3, territoryFloor, play);
		/*for (int i =0; i< territory1.size(); i++){
		System.out.println("carta territorio: " + territory1.get(i));
		}
		for (int i =0; i< jsonFloor.getTerritoryFloors().size(); i++){
			System.out.println("Ho creato il piano territory: " + jsonFloor.getTerritoryFloors().get(i));
			System.out.println("Piano della torre: " + territoryTower.floors.get(i));
			
			}*/
		ArrayList<Floor> buildingFloorJson=jsonFloor.getBuildingFloors();
		ArrayList<Floor> buildingFloor= new ArrayList<>();
		for(Floor f: buildingFloorJson){
		buildingFloor.add(new Floor(f, play));}
		buildingTower = new Tower("building", building1, building2, building3, buildingFloor, play);
		/*for (int i =0; i< building1.size(); i++){
			System.out.println("carta building: " + building1.get(i));
			}
		for (int i =0; i< jsonFloor.getBuildingFloors().size(); i++){
			System.out.println("Ho creato il piano building: " + jsonFloor.getBuildingFloors().get(i));
			System.out.println("Piano della torre: " + buildingTower.floors.get(i));
			
			}*/
		ArrayList<Floor> characterFloorJson=jsonFloor.getCharacterFloors();
		ArrayList<Floor> characterFloor= new ArrayList<>();
		for(Floor f: characterFloorJson){
		characterFloor.add(new Floor(f, play));}
		characterTower = new Tower("character", character1, character2, character3, characterFloor , play);
		/*for (int i =0; i< character1.size(); i++){
			System.out.println("carta character: " + character1.get(i));
			}
		for (int i =0; i< jsonFloor.getCharacterFloors().size(); i++){
			System.out.println("Ho creato il piano character: " + jsonFloor.getCharacterFloors().get(i));
			System.out.println("Piano della torre: " + characterTower.floors.get(i));
			
			}*/
		ArrayList<Floor> ventureFloorJson=jsonFloor.getTerritoryFloors();
		ArrayList<Floor> ventureFloor= new ArrayList<>();
		for(Floor f: ventureFloorJson){
		ventureFloor.add(new Floor(f, play));}
		ventureTower= new Tower("venture", venture1, venture2, venture3, ventureFloor, play);
		/*for (int i =0; i< venture1.size(); i++){
			System.out.println("carta venture: " + venture1.get(i));
			}
		for (int i =0; i< jsonFloor.getVentureFloors().size(); i++){
			System.out.println("Ho creato il piano venture: " + jsonFloor.getVentureFloors().get(i));
			System.out.println("Piano della torre: " + ventureTower.floors.get(i));
			
			}*/
		//System.out.println(jsonFloor.getTerritoryFloors());
		
		JsonCouncilPalace jsonCouncil= new JsonCouncilPalace();
		jsonCouncil.importCouncilPalace();
		CouncilPalace councilPalaceJson=jsonCouncil.getCouncilPalace();
		councilPalace = new CouncilPalace(councilPalaceJson, play);
		
		
		JsonPrivilegeCouncil jsonPrivilegeCouncil= new JsonPrivilegeCouncil();
		jsonPrivilegeCouncil.importPrivilegeCouncil();
		privilegeCouncil=jsonPrivilegeCouncil.getPrivilegeCouncil();

		
		//lista di market
		market = new ArrayList<MarketBuilding>();
		JsonMarket jsonMarket= new JsonMarket();
		jsonMarket.importMarket();
		ArrayList<MarketBuilding> marketJson = new ArrayList<>();
		for(int i=0; i<4; i++){
			marketJson.add(i, jsonMarket.getMarketBuilding(i));
			market.add(i, new MarketBuilding(marketJson.get(i), play));
		}
		
		JsonPersonalBonusTiles jsonPersonalBonusTiles= new JsonPersonalBonusTiles();
		jsonPersonalBonusTiles.importPersonalBonusTiles();
		PersonalBonusTile personalBonusTileSimple = jsonPersonalBonusTiles.getPersonalBonusTiles(0);
		PersonalBonusTile personalBonusTileAdvanced = jsonPersonalBonusTiles.getPersonalBonusTiles(1);
		
		
		JsonHarvestAndProduction jsonHarvestAndProduction = new JsonHarvestAndProduction();
		jsonHarvestAndProduction.importHarvestAndProduction();
		
		HarvestAndProductionArea harvestAreaJson = jsonHarvestAndProduction.getHarvest();
		HarvestAndProductionArea productionAreaJson = jsonHarvestAndProduction.getProduction();
		harvestArea= new HarvestAndProductionArea(harvestAreaJson, play);
		productionArea= new HarvestAndProductionArea(productionAreaJson, play);
		
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
				+ "\n" + market.get(0) + "\n" + market.get(1) + "\n" + market.get(2) + "\n" + market.get(3)
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




	public PrivilegeCouncil getPrivilegeCouncil() {
		return privilegeCouncil;
	}

}
