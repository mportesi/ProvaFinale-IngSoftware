package it.polimi.ingsw.GC_40;

import java.util.ArrayList;
import java.util.Collections;

import it.polimi.ingsw.components.Card;
import it.polimi.ingsw.components.CouncilPalace;
import it.polimi.ingsw.components.Dice;
import it.polimi.ingsw.components.Floor;
import it.polimi.ingsw.components.HarvestAndProductionArea;
import it.polimi.ingsw.components.MarketBuilding;
import it.polimi.ingsw.components.PersonalBonusTile;
import it.polimi.ingsw.components.Tower;

public class Board {
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
	
	
	
	public Board(){
		ArrayList<Card> territory1= createDeck(1, "territory");
		ArrayList<Card> territory2= createDeck(2, "territory");
		ArrayList<Card> territory3= createDeck(3, "territory");
		ArrayList<Card> building1= createDeck(1, "building");
		ArrayList<Card> building2= createDeck(2, "building");
		ArrayList<Card> building3= createDeck(3, "building");
		ArrayList<Card> character1= createDeck(1, "character");
		ArrayList<Card> character2= createDeck(2, "character");
		ArrayList<Card> character3= createDeck(3, "character");
		ArrayList<Card> venture1= createDeck(1, "venture");
		ArrayList<Card> venture2= createDeck(2, "venture");
		ArrayList<Card> venture3= createDeck(3, "venture");
		
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
		buildingTower= new Tower("building", building1, building2, building3, JSon.buildingFloors);
		characterTower= new Tower("character", character1, character2, character3, JSon.characterFloors);
		ventureTower= new Tower("venture", venture1, venture2, venture3, JSon.ventureFloors);
		councilPalace= new CouncilPalace();
		
		MarketBuilding market1 = JSon.marketBuilding.get(0);
		MarketBuilding market2 = JSon.marketBuilding.get(1);
		MarketBuilding market3 = JSon.marketBuilding.get(2);
		MarketBuilding market4 = JSon.marketBuilding.get(3);
		
		
		PersonalBonusTile personalBonusTileSimple = JSon.personalBonusTiles.get(0);
		PersonalBonusTile personalBonusTileAdvanced = JSon.personalBonusTiles.get(1);
		
		
		
		harvestArea= new HarvestAndProductionArea();
		productionArea= new HarvestAndProductionArea();
		
		
		blackDice= new Dice(ColorDice.BLACK);
		whiteDice= new Dice(ColorDice.WHITE);
		orangeDice= new Dice(ColorDice.ORANGE);
	}
	
	
	
	
	public ArrayList<Card> createDeck(int period, String type) {
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
		
			ArrayList<Card> newDeck= new ArrayList<Card>();
			for(Card c:deck){
				if (c.getType().equals(type) && c.getPeriod()==period){
					newDeck.add(c);
					}
			}
			return newDeck;
			
		}


}
