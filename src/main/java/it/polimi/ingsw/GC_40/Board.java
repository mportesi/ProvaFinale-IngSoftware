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

public class Board extends Observable<Change> implements Serializable {
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
	private int numberOfPlayers;
	

	public Board(Play play, int numberOfPlayers)
			throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		this.numberOfPlayers = numberOfPlayers;
		JsonCard jsonCard = new JsonCard();
		jsonCard.importCards();
		deck = new ArrayList<Card>();
		create(jsonCard);
		ArrayList<Card> territory1 = createDeck(1, "territoryCard");
		ArrayList<Card> territory2 = createDeck(2, "territoryCard");
		ArrayList<Card> territory3 = createDeck(3, "territoryCard");
		ArrayList<Card> building1 = createDeck(1, "buildingCard");
		ArrayList<Card> building2 = createDeck(2, "buildingCard");
		ArrayList<Card> building3 = createDeck(3, "buildingCard");
		ArrayList<Card> character1 = createDeck(1, "characterCard");
		ArrayList<Card> character2 = createDeck(2, "characterCard");
		ArrayList<Card> character3 = createDeck(3, "characterCard");
		ArrayList<Card> venture1 = createDeck(1, "ventureCard");
		ArrayList<Card> venture2 = createDeck(2, "ventureCard");
		ArrayList<Card> venture3 = createDeck(3, "ventureCard");

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
		ArrayList<Floor> territoryFloorJson = jsonFloor.getTerritoryFloors();
		ArrayList<Floor> territoryFloor = new ArrayList<>();
		for (int i = territoryFloorJson.size()-1; i>=0; i--){
			territoryFloor.add(new Floor(territoryFloorJson.get(i), play));
		}
		territoryTower = new Tower("territory", territory1, territory2, territory3, territoryFloor, play);
		
		ArrayList<Floor> buildingFloorJson = jsonFloor.getBuildingFloors();
		ArrayList<Floor> buildingFloor = new ArrayList<>();
		for (int i = territoryFloorJson.size()-1; i>=0; i--){
			buildingFloor.add(new Floor(buildingFloorJson.get(i), play));
		}
		buildingTower = new Tower("building", building1, building2, building3, buildingFloor, play);
		
		ArrayList<Floor> characterFloorJson = jsonFloor.getCharacterFloors();
		ArrayList<Floor> characterFloor = new ArrayList<>();
		for (int i = characterFloorJson.size()-1; i>=0; i--){
			characterFloor.add(new Floor(characterFloorJson.get(i), play));
		}
		characterTower = new Tower("character", character1, character2, character3, characterFloor, play);
	
		ArrayList<Floor> ventureFloorJson = jsonFloor.getTerritoryFloors();
		ArrayList<Floor> ventureFloor = new ArrayList<>();
		for (int i = ventureFloorJson.size()-1; i>=0; i--){
			ventureFloor.add(new Floor(ventureFloorJson.get(i), play));
		}
		ventureTower = new Tower("venture", venture1, venture2, venture3, ventureFloor, play);

		JsonCouncilPalace jsonCouncil = new JsonCouncilPalace();
		jsonCouncil.importCouncilPalace();
		CouncilPalace councilPalaceJson = jsonCouncil.getCouncilPalace();
		councilPalace = new CouncilPalace(councilPalaceJson, play);

		JsonPrivilegeCouncil jsonPrivilegeCouncil = new JsonPrivilegeCouncil();
		jsonPrivilegeCouncil.importPrivilegeCouncil();
		privilegeCouncil = jsonPrivilegeCouncil.getPrivilegeCouncil();

		// lista di market
		if (numberOfPlayers == 4) {
			market = new ArrayList<MarketBuilding>();
			JsonMarket jsonMarket = new JsonMarket();
			jsonMarket.importMarket();
			ArrayList<MarketBuilding> marketJson = new ArrayList<>();
			for (int i = 0; i < 4; i++) {
				marketJson.add(i, jsonMarket.getMarketBuilding(i));
				market.add(i, new MarketBuilding(marketJson.get(i), play));
			}
		} else {
			market = new ArrayList<MarketBuilding>();
			JsonMarket jsonMarket = new JsonMarket();
			jsonMarket.importMarket();
			
			ArrayList<MarketBuilding> marketJson = new ArrayList<>();
			for (int i = 0; i <= 1; i++) {
				marketJson.add(i, jsonMarket.getMarketBuilding(i));
				market.add(i, new MarketBuilding(marketJson.get(i), play));
			}

		}

		

		if (numberOfPlayers >= 3) {
			JsonHarvestAndProduction jsonHarvestAndProduction = new JsonHarvestAndProduction();
			jsonHarvestAndProduction.importHarvestAndProduction();

			HarvestAndProductionArea harvestAreaJson = jsonHarvestAndProduction.getHarvest();
			HarvestAndProductionArea productionAreaJson = jsonHarvestAndProduction.getProduction();
			harvestArea = new HarvestAndProductionArea(harvestAreaJson, play);
			productionArea = new HarvestAndProductionArea(productionAreaJson, play);
		} else {
			JsonHarvestAndProduction jsonHarvestAndProduction = new JsonHarvestAndProduction();
			jsonHarvestAndProduction.importHarvestAndProductionWith3Players();

			HarvestAndProductionArea harvestAreaJson = jsonHarvestAndProduction.getHarvest();
			HarvestAndProductionArea productionAreaJson = jsonHarvestAndProduction.getProduction();
			harvestArea = new HarvestAndProductionArea(harvestAreaJson, play);
			productionArea = new HarvestAndProductionArea(productionAreaJson, play);

		}

		blackDice = new Dice(ColorDice.BLACK);
		whiteDice = new Dice(ColorDice.WHITE);
		orangeDice = new Dice(ColorDice.ORANGE);

	}

	public void create(JsonCard jsonCard) {
		for (Card card : jsonCard.getCharacterDeck()) {
			deck.add(card);
		}
		for (Card card : jsonCard.getBuildingDeck()) {
			deck.add(card);
		}
		for (Card card : jsonCard.getTerritoryDeck()) {
			deck.add(card);
		}
		for (Card card : jsonCard.getVentureDeck()) {
			deck.add(card);
		}
	}

	public ArrayList<Card> createDeck(int period, String type)
			throws FileNotFoundException, NullPointerException, IOException, ParseException {

		ArrayList<Card> newDeck = new ArrayList<Card>();
		for (Card c : deck) {
			if (c.getType().equals(type) && c.getPeriod() == period) {
				newDeck.add(c);

			}
		}
		
		return newDeck;

	}

	@Override
	public String toString() {
		if(numberOfPlayers==4){
		return ("Board" + "\n" + territoryTower + "\n" + buildingTower + "\n" + characterTower + "\n" + ventureTower
				+ "\n" + councilPalace + "\n" + market.get(0) + "\n" + market.get(1) + "\n" + market.get(2) + "\n"
				+ market.get(3) + "\n" + harvestArea + "\n" + productionArea + "\n" + blackDice + "\n" + whiteDice
				+ "\n" + orangeDice + "\nNumber of players: "+ numberOfPlayers);}
		else{
			return("Board" + "\n" + territoryTower + "\n\n" + buildingTower + "\n\n" + characterTower + "\n\n" + ventureTower
					+ "\n\n\n" + councilPalace + "\n\n\n" + market.get(0) + "\n\n" + market.get(1) + "\n\n\n" + harvestArea + "\n\n" + productionArea + "\n\n\n" + blackDice + "\n" + whiteDice
					+ "\n" + orangeDice + "\nNumber of players: "+ numberOfPlayers);
		}
	}

	public CouncilPalace getCouncilPalace() {
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

	public int getNumberOfPlayers() {
		return numberOfPlayers;
	}

	public void remove(Player player) {
		if(councilPalace.isAlreadyPresent(player)){
			councilPalace.removePlayer(player);
		}
		for(MarketBuilding m: market){
			if(m.isOccupied() && m.getPlayer().getID().equals(player.getID())){
				m.setFree();
			}
		}
		for(Floor f: buildingTower.getFloors()){
			if(!f.isFree() && f.getPlayer().getID().equals(player.getID())){
				f.setFree();
			}
		}
		for(Floor f: territoryTower.getFloors()){
			if(!f.isFree() && f.getPlayer().getID().equals(player.getID())){
				f.setFree();
			}
		}
		for(Floor f: characterTower.getFloors()){
			if(!f.isFree() && f.getPlayer().getID().equals(player.getID())){
				f.setFree();
			}
		}
		for(Floor f: ventureTower.getFloors()){
			if(!f.isFree() && f.getPlayer().getID().equals(player.getID())){
				f.setFree();
			}
		}
		if(harvestArea.isAlreadyPresent(player)){
			if(harvestArea.getLeftRelative().getPlayer().getID().equals(player.getID())){
				try {
					harvestArea.setLeftRelativeOnHarvest(null);
				} catch (NullPointerException | IOException | ParseException | InterruptedException e) {
					e.printStackTrace();
				}
			}
			Relative relativeToRemove=null;
			for(Relative r: harvestArea.getRightRelatives()){
				if(r.getPlayer().getID().equals(player.getID())){
					relativeToRemove=r;
				}
			}
			harvestArea.getRightRelatives().remove(relativeToRemove);
		}
		if(productionArea.isAlreadyPresent(player)){
			if(productionArea.getLeftRelative().getPlayer().getID().equals(player.getID())){
				try {
					harvestArea.setLeftRelativeOnProduction(null);
				} catch (NullPointerException | IOException | ParseException | InterruptedException e) {
					e.printStackTrace();
				}
			}
			Relative relativeToRemove=null;
			for(Relative r: productionArea.getRightRelatives()){
				if(r.getPlayer().getID().equals(player.getID())){
					relativeToRemove=r;
				}
			}
			productionArea.getRightRelatives().remove(relativeToRemove);
		}
		
	}

	

}
