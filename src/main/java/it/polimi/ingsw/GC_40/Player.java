package it.polimi.ingsw.GC_40;

import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;
import java.util.UUID;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.cards.BuildingCard;
import it.polimi.ingsw.cards.Card;
import it.polimi.ingsw.cards.CharacterCard;
import it.polimi.ingsw.cards.TerritoryCard;
import it.polimi.ingsw.cards.VentureCard;
import it.polimi.ingsw.changes.*;
import it.polimi.ingsw.colors.ColorDice;
import it.polimi.ingsw.colors.ColorPlayer;
import it.polimi.ingsw.components.LeaderTile;
import it.polimi.ingsw.components.PersonalBonusTile;
import it.polimi.ingsw.components.Relative;

public class Player extends Observable<Change> implements Serializable {
	private UUID ID;
	private String name;
	private ColorPlayer color;
	private int coin;
	private int wood;
	private int stone;
	private int servant;
	private int faithPoint;
	private int victoryPoint;
	private int militaryPoint;
	private ArrayList<TerritoryCard> territoryCard;
	private ArrayList<CharacterCard> characterCard;
	private ArrayList<BuildingCard> buildingCard;
	private ArrayList<VentureCard> ventureCard;
	private ArrayList<LeaderTile> leader;
	private PersonalBonusTile personalBonusTile;
	private Relative blackRelative;
	private Relative whiteRelative;
	private Relative orangeRelative;
	private Relative neutralRelative;
	private boolean hasBlackRelative;
	private boolean hasWhiteRelative;
	private boolean hasOrangeRelative;
	private boolean hasNeutralRelative;
	//private Play play;

	public Player(UUID ID, Play play, String name) {
		this.ID = ID;
		this.name = name;
		blackRelative= new Relative(ColorDice.BLACK, this);
		whiteRelative= new Relative(ColorDice.WHITE, this);
		orangeRelative= new Relative(ColorDice.ORANGE, this);
		neutralRelative= new Relative(null, this);
		territoryCard= new ArrayList<>();
		buildingCard= new ArrayList<>();
		ventureCard= new ArrayList<>();
		characterCard=new ArrayList<>();
		hasBlackRelative = true;
		hasWhiteRelative = true;
		hasOrangeRelative = true;
		hasNeutralRelative = true;
	//	this.play=play;
		registerObserver(play);
		System.out.println("Registro" + play);
	}

	
	
	@Override
	public String toString(){
		return ("The player is\n " + "Name: " + name +  "\nColor: " + color + "\nCoin: " +coin + "\nWood: "+ wood +"\nStone: "+ stone + "\nServant: "+ servant + "\nFaithPoint: " + faithPoint + "\nMilitaryPoint: "+ militaryPoint + "\nVictoryPoint: "+ victoryPoint+ "\nTerritoryCard: " + territoryCard + "\nCharacterCard: "
				+ characterCard + "\nVentureCard: " + ventureCard + "\nBuildingCard: "+ buildingCard + "\nLeaderTile: "+ leader);
	}

	public int resourceCounter() {
		return coin + wood + stone + servant;
	}

	public int getCoin() {
		return coin;
	}

	public int getWood() {
		return wood;
	}

	public int getStone() {
		return stone;
	}

	public int getServant() {
		return servant;
	}

	public ColorPlayer getColor() {
		return color;
	}

	public int getFaithPoint() {
		return faithPoint;
	}

	public int getVictoryPoint() {
		return victoryPoint;
	}

	public int getMilitaryPoint() {
		return militaryPoint;
	}

	public ArrayList<TerritoryCard> getTerritory() {
		return territoryCard;
	}

	public ArrayList<CharacterCard> getCharacter() {
		return characterCard;
	}

	public ArrayList<BuildingCard> getBuilding() {
		return buildingCard;
	}

	public ArrayList<VentureCard> getVenture() {
		return ventureCard;
	}

	public ArrayList<LeaderTile> getLeader() {
		return leader;
	}

	public void incrementCoin(int n) throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		coin += n;
		//registerObserver(play);
		ChangeCoin changeCoin = new ChangeCoin(this, coin);
		System.out.println("SONO IN PLAYER notifico il change coin");
		this.notifyObserver(changeCoin);

	}

	public void decrementCoin(int n) throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		coin -= n;
		//registerObserver(play);
		ChangeCoin changeCoin = new ChangeCoin(this, coin);
		System.out.println("SONO IN PLAYER MANDO IL CHANGE AL PLAY");
		this.notifyObserver(changeCoin);
	}

	public void incrementWood(int n) throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		wood += n;
		//registerObserver(play);
		ChangeWood changeWood = new ChangeWood(this, wood);
		System.out.println("SONO IN PLAYER MANDO IL CHANGE AL PLAY");
		this.notifyObserver(changeWood);
	}

	public void decrementWood(int n) throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		wood -= n;
		ChangeWood changeWood = new ChangeWood(this, wood);
		this.notifyObserver(changeWood);

	}

	public void incrementStone(int n) throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		stone += n;
		//registerObserver(play);
		ChangeStone changeStone = new ChangeStone(this, stone);
		System.out.println("SONO IN PLAYER MANDO IL CHANGE AL PLAY");
		this.notifyObserver(changeStone);
	}

	public void decrementStone(int n) throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		stone -= n;
		ChangeStone changeStone = new ChangeStone(this, stone);
		this.notifyObserver(changeStone);
	}

	public void incrementServant(int n)
			throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		servant += n;
		//registerObserver(play);
		ChangeServant changeServant = new ChangeServant(this, servant);
		System.out.println("SONO IN PLAYER MANDO IL CHANGE AL PLAY");
		this.notifyObserver(changeServant);
	}

	public void decrementServant(int n)
			throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		servant -= n;
	//	registerObserver(play);
		ChangeServant changeServant = new ChangeServant(this, servant);
		this.notifyObserver(changeServant);
	}

	public void incrementMilitaryPoint(int n)
			throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		militaryPoint += n;
		//registerObserver(play);
		ChangeMilitaryPoint changeMilitaryPoint = new ChangeMilitaryPoint(this, militaryPoint);
		System.out.println("SONO IN PLAYER MANDO IL CHANGE AL PLAY");
		this.notifyObserver(changeMilitaryPoint);

	}

	public void decrementMilitaryPoint(int n)
			throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		militaryPoint -= n;
		ChangeMilitaryPoint changeMilitaryPoint = new ChangeMilitaryPoint(this, militaryPoint);
		this.notifyObserver(changeMilitaryPoint);
	}

	public void incrementFaithPoint(int n)
			throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		faithPoint += n;
		//registerObserver(play);
		ChangeFaithPoint changeFaithPoint = new ChangeFaithPoint(this, faithPoint);
		System.out.println("SONO IN PLAYER MANDO IL CHANGE AL PLAY");
		this.notifyObserver(changeFaithPoint);
	}

	public void decrementFaithPoint(int n)
			throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		faithPoint -= n;
		ChangeFaithPoint changeFaithPoint = new ChangeFaithPoint(this, faithPoint);
		this.notifyObserver(changeFaithPoint);
	}

	public void incrementVictoryPoint(int n)
			throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		victoryPoint += n;
		//registerObserver(play);
		ChangeVictoryPoint changeVictoryPoint = new ChangeVictoryPoint(this, victoryPoint);
		System.out.println("SONO IN PLAYER MANDO IL CHANGE AL PLAY");
		this.notifyObserver(changeVictoryPoint);
	}

	public void decrementVictoryPoint(int n)
			throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		victoryPoint-= n;
		ChangeVictoryPoint changeVictoryPoint = new ChangeVictoryPoint(this, victoryPoint);
		this.notifyObserver(changeVictoryPoint);
	}

	public int counter(String cardType) {
		int i = 0;
		if (cardType.equals("buildingCard")) {
			for (Card card : buildingCard) {
				if (card != null) {
					i += 1;
				}
			}
		}
		if (cardType.equals("territoryCard")) {
			for (Card card : territoryCard) {
				if (card != null) {
					i += 1;
				}
			}
		}
		if (cardType.equals("ventureCard")) {
			for (Card card : ventureCard) {
				if (card != null) {
					i += 1;
				}
			}
		}
		if (cardType.equals("characterCard")) {
			for (Card card : characterCard) {
				if (card != null) {
					i += 1;
				}
			}
		}
		return i;
	}

	public void addCard(Card card) throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		String type = card.getType();
		switch (type) {
		case "territoryCard": {
			if(territoryCard.size()<6){
			territoryCard.add((TerritoryCard) card);
			ChangeTerritoryCard changeTerritoryCard = new ChangeTerritoryCard(this, territoryCard);
			this.notifyObserver(changeTerritoryCard);}
			break;
		}
		case "buildingCard": {
			if(buildingCard.size()<6){
			buildingCard.add((BuildingCard) card);
			ChangeBuildingCard changeBuildingCard = new ChangeBuildingCard(this, buildingCard);
			this.notifyObserver(changeBuildingCard);}
			break;
		}
		case "characterCard": {
			if(characterCard.size()<6){
			characterCard.add((CharacterCard) card);
			ChangeCharacterCard changeCharacterCard = new ChangeCharacterCard(this, characterCard);
			this.notifyObserver(changeCharacterCard);}
			break;
		}
		case "ventureCard": {
			if(ventureCard.size()<6){
			ventureCard.add((VentureCard) card);
			ChangeVentureCard changeVentureCard = new ChangeVentureCard(this, ventureCard);
			this.notifyObserver(changeVentureCard);}
			break;
		}
		}

	}

	public void chooseCharacterCard(int value, Map<String, Integer> discount) {

	}

	public void setCoin(int i) {
		coin = i;
	}

	public void setWood(int i) {
		wood = i;
	}

	public void setServant(int i) {
		servant = i;
	}

	public void setStone(int i) {
		stone = i;
	}

	public void setMilitaryPoint(int i) {
		militaryPoint = i;
	}

	public void setVictoryPoint(int i) {
		victoryPoint = i;
	}

	public void setFaithPoint(int i) {
		faithPoint = i;
	}

	public void setColor(ColorPlayer colorPlayer) {
		color = colorPlayer;
	}

	public UUID getID() {
		return ID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ID == null) ? 0 : ID.hashCode());
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		if (ID == null) {
			if (other.ID != null)
				return false;
		} else if (!ID.equals(other.ID))
			return false;
		if (color != other.color)
			return false;
		return true;
	}

	public void setBuilding(ArrayList<BuildingCard> buildingCard) {
		this.buildingCard = buildingCard;
	}

	public void setCharacter(ArrayList<CharacterCard> characterCard) {
		this.characterCard = characterCard;
	}

	public void setTerritoryCard(ArrayList<TerritoryCard> territoryCard) {
		this.territoryCard = territoryCard;
	}

	public void setVentureCard(ArrayList<VentureCard> ventureCard) {
		this.ventureCard = ventureCard;
	}

	public String getName() {
		return name;
	}

	public Relative getBlackRelative() {
		return blackRelative;
	}
	
	public Relative getWhiteRelative() {
		return whiteRelative;
	}
	
	public Relative getOrangeRelative() {
		return orangeRelative;
	}
	
	public Relative getNeutralRelative() {
		return neutralRelative;
	}

	public PersonalBonusTile getPersonalBonusTile() {
	
		return personalBonusTile;
	}

	public void setOccupiedRelative(Relative relative) throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		if(relative.equals(blackRelative)){
			hasBlackRelative=false;
			ChangeOccupiedRelative changeOccupiedRelative= new ChangeOccupiedRelative(this, relative);
			this.notifyObserver(changeOccupiedRelative);
		}
		if(relative.equals(whiteRelative)){
			hasWhiteRelative=false;
			ChangeOccupiedRelative changeOccupiedRelative= new ChangeOccupiedRelative(this, relative);
			this.notifyObserver(changeOccupiedRelative);
		}
		if(relative.equals(orangeRelative)){
			hasOrangeRelative=false;
			ChangeOccupiedRelative changeOccupiedRelative= new ChangeOccupiedRelative(this, relative);
			this.notifyObserver(changeOccupiedRelative);
		}
		if(relative.equals(orangeRelative)){
			hasNeutralRelative=false;
			ChangeOccupiedRelative changeOccupiedRelative= new ChangeOccupiedRelative(this, relative);
			this.notifyObserver(changeOccupiedRelative);
		}
		
	}

	public boolean getBooleanRelative(Relative relative) {
		if(relative.equals(blackRelative)){
			return hasBlackRelative;
		}
		if(relative.equals(whiteRelative)){
			return hasWhiteRelative;
		}
		if(relative.equals(orangeRelative)){
			return hasOrangeRelative;
		}
		if(relative.equals(orangeRelative)){
			return hasNeutralRelative;
		}
		return false;
	}



	public void setFreeRelative(Relative relative) {
		// TODO Auto-generated method stub
		System.out.println(relative);
		System.out.println(blackRelative);
		if(relative.equals(blackRelative)){
			hasBlackRelative=true;
		}
		if(relative.equals(whiteRelative)){
			hasWhiteRelative=true;
		}
		if(relative.equals(orangeRelative)){
			hasOrangeRelative=true;
			
		}
		if(relative.equals(orangeRelative)){
			hasNeutralRelative=true;
			
		}
	}
	



}
