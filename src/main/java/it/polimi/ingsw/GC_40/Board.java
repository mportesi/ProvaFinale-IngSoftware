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

public class Board  extends Observable<Change> implements Serializable{
	public static Tower territoryTower;
	public static Tower characterTower;
	public static Tower buildingTower;
	public static Tower ventureTower;
	public static CouncilPalace councilPalace;
	public static MarketBuilding market1;
	public static MarketBuilding market2;
	public static MarketBuilding market3;
	public static MarketBuilding market4;
	public static HarvestAndProductionArea harvestArea;
	public static HarvestAndProductionArea productionArea;
	public static Dice blackDice;
	public static Dice whiteDice;
	public static Dice orangeDice;
	public static ArrayList<Card> deck;
	
	
	
	public Board() throws FileNotFoundException, NullPointerException, IOException, ParseException{
		JSon.importCards();
		deck=new ArrayList<Card>();
		create();
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
		
	
		territoryTower= new Tower("territory", territory1, territory2, territory3, JSon.territoryFloors);
		for (int i =0; i< territory1.size(); i++){
		System.out.println("carta territorio: " + territory1.get(i));
		}
		for (int i =0; i< JSon.territoryFloors.size(); i++){
			System.out.println("Ho creato il piano territory: " + JSon.territoryFloors.get(i));
			System.out.println("Piano della torre: " + territoryTower.floors.get(i));
			
			}
		
		buildingTower= new Tower("building", building1, building2, building3, JSon.buildingFloors);
		for (int i =0; i< building1.size(); i++){
			System.out.println("carta building: " + building1.get(i));
			}
		for (int i =0; i< JSon.buildingFloors.size(); i++){
			System.out.println("Ho creato il piano building: " + JSon.buildingFloors.get(i));
			System.out.println("Piano della torre: " + buildingTower.floors.get(i));
			
			}
		
		characterTower= new Tower("character", character1, character2, character3, JSon.characterFloors);
		for (int i =0; i< character1.size(); i++){
			System.out.println("carta character: " + character1.get(i));
			}
		for (int i =0; i< JSon.characterFloors.size(); i++){
			System.out.println("Ho creato il piano character: " + JSon.characterFloors.get(i));
			System.out.println("Piano della torre: " + characterTower.floors.get(i));
			
			}
		
		ventureTower= new Tower("venture", venture1, venture2, venture3, JSon.ventureFloors);
		for (int i =0; i< venture1.size(); i++){
			System.out.println("carta venture: " + venture1.get(i));
			}
		for (int i =0; i< JSon.ventureFloors.size(); i++){
			System.out.println("Ho creato il piano venture: " + JSon.ventureFloors.get(i));
			System.out.println("Piano della torre: " + ventureTower.floors.get(i));
			
			}
		
		
		
		councilPalace = JSon.councilPalace;
		
		//lista di market
		MarketBuilding market1 = JSon.marketBuilding.get(0);
		MarketBuilding market2 = JSon.marketBuilding.get(1);
		MarketBuilding market3 = JSon.marketBuilding.get(2);
		MarketBuilding market4 = JSon.marketBuilding.get(3);
		
		
		PersonalBonusTile personalBonusTileSimple = JSon.personalBonusTiles.get(0);
		PersonalBonusTile personalBonusTileAdvanced = JSon.personalBonusTiles.get(1);
		
		
		
		harvestArea = JSon.harvest;
		productionArea = JSon.production;
		
		
		blackDice = new Dice(ColorDice.BLACK);
		whiteDice = new Dice(ColorDice.WHITE);
		orangeDice = new Dice(ColorDice.ORANGE);
	}
	
	
	
	
	//public ArrayList<Card> createDeck(int period, String type) throws FileNotFoundException, NullPointerException, IOException, ParseException {
		
		public void create(){
		for (Card card : JSon.characterDeck){
			 deck.add(card);
		}
		for (Card card : JSon.buildingDeck){
			 deck.add(card);
		}
		for (Card card : JSon.territoryDeck){
			 deck.add(card);
		}
		for (Card card : JSon.ventureDeck){
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
			return newDeck;
			
		}




	@Override
	public String toString() {
		return ("Board" + "\n" + "TerritoryTower" + territoryTower + "\n" + "BuildingTower" + buildingTower + "\n" + "CharacterTower" + "\n" + characterTower + "\n" + "VentureTower" + "\n" + ventureTower);
	}




	public CouncilPalace getCouncilPalace() {
		// TODO Auto-generated method stub
		return councilPalace;
	}


}
