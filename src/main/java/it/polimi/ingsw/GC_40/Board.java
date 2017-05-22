package it.polimi.ingsw.GC_40;

import java.util.ArrayList;
import java.util.Collections;

public class Board {
	public static Tower territoryTower;
	public static Tower characterTower;
	public static Tower buildingTower;
	public static Tower ventureTower;
	public CouncilPalace councilPalace;
	public Market market;
	public HarvestAndProductionArea harvestArea;
	public HarvestAndProductionArea productionArea;
	public Dice blackDice;
	public Dice whiteDice;
	public Dice orangeDice;
	public Card[] deck;
	
	
	public Board(){
		Tower territoryTower= new Tower("territory", territory1, territory2, territory3);
		Tower buildingTower= new Tower("building", building1, building2, building3);
		Tower characterTower= new Tower("character", character1, character2, character3);
		Tower ventureTower= new Tower("venture", venture1, venture2, venture3);
		councilPalace= new CouncilPalace();
		
		market= new Market();
		
		harvestArea= new HarvestAndProductionArea();
		productionArea= new HarvestAndProductionArea();
		
		blackDice= new Dice(BLACK);
		whiteDice= new Dice(WHITE);
		orangeDice= new Dice(ORANGE);
		
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
	}
	
	public ArrayList<Card> createDeck(int period, String type){
			for(Card c:deck){
				if (c.getType().equals(type) && c.getPeriod()==period){
					ArrayList<Card> newDeck= new ArrayList<Card>();
					newDeck.add(c);
					}
			}
		}
	
	public void 
		

}
