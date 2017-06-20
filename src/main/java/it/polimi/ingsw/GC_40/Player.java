package it.polimi.ingsw.GC_40;

import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.rmi.AlreadyBoundException;
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

public class Player implements Serializable {
	private UUID ID;
	private int match;
	private String name;
	private ColorPlayer color;
	private int coin;
	private int wood;
	private int stone;
	private int servant;
	private int faithPoint;
	private int victoryPoint;
	private int militaryPoint;
	private ArrayList <Relative> activeRelatives;
	private ArrayList<TerritoryCard> territoryCard;
	private ArrayList<CharacterCard> characterCard;
	private ArrayList<BuildingCard> buildingCard;
	private ArrayList<VentureCard> ventureCard;
	private ArrayList<LeaderTile> leader;
	private PersonalBonusTile personalBonusTileSimple;
	private PersonalBonusTile personalBonusTileAdvcanced;
	private Relative blackRelative;
	private Relative whiteRelative;
	private Relative orangeRelative;
	private Relative neutralRelative;
	private boolean hasBlackRelative;
	private boolean hasWhiteRelative;
	private boolean hasOrangeRelative;
	private boolean hasNeutralRelative;

	public Player(UUID ID, String name, int match) {
		this.ID = ID;
		this.match=match;
		this.name = name;
		
		blackRelative= new Relative(ColorDice.BLACK, this);
		whiteRelative= new Relative(ColorDice.WHITE, this);
		orangeRelative= new Relative(ColorDice.ORANGE, this);
		neutralRelative= new Relative(null, this);
		activeRelatives = new ArrayList <Relative>();
	/*	activeRelatives.add(blackRelative);
		activeRelatives.add(neutralRelative);
		activeRelatives.add(orangeRelative);
		activeRelatives.add(whiteRelative);*/
		territoryCard= new ArrayList<>();
		buildingCard= new ArrayList<>();
		ventureCard= new ArrayList<>();
		characterCard=new ArrayList<>();
		hasBlackRelative = true;
		hasWhiteRelative = true;
		hasOrangeRelative = true;
		hasNeutralRelative = true;
	}

	
	
	@Override
	public String toString(){
		return ("The player is\n " + "Name: " + name +  "\nColor: " + color + "\nCoin: " +coin + "\nWood: "+ wood +"\nStone: "+ stone + "\nServant: "+ servant + "\nFaithPoint: " + faithPoint + "\nMilitaryPoint: "+ militaryPoint + "\nVictoryPoint: "+ victoryPoint+ "\nTerritoryCard: " + territoryCard + "\nCharacterCard: "
				+ characterCard + "\nVentureCard: " + ventureCard + "\nBuildingCard: "+ buildingCard + "\nLeaderTile: "+ leader + "\nThe active relative are: " +activeRelatives);
	}
	
	public void removeRelative (Relative relative){
		activeRelatives.remove(relative);
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

	public void incrementCoin(int n, Play play) throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		coin += n;
		ChangeCoin changeCoin = new ChangeCoin(this, coin);
		play.notifyObserver(changeCoin);

	}

	public void decrementCoin(int n, Play play) throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		coin -= n;
		ChangeCoin changeCoin = new ChangeCoin(this, coin);
		play.notifyObserver(changeCoin);
	}

	public void incrementWood(int n,Play play) throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		wood += n;
		ChangeWood changeWood = new ChangeWood(this, wood);
		play.notifyObserver(changeWood);
	}

	public void decrementWood(int n, Play play) throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException{
		wood -= n;
		ChangeWood changeWood = new ChangeWood(this, wood);
		play.notifyObserver(changeWood);

	}

	public void incrementStone(int n, Play play) throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException{
		stone += n;
		ChangeStone changeStone = new ChangeStone(this, stone);
		play.notifyObserver(changeStone);
	}

	public void decrementStone(int n, Play play) throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException{
		stone -= n;
		ChangeStone changeStone = new ChangeStone(this, stone);
		play.notifyObserver(changeStone);
	}

	public void incrementServant(int n, Play play)
			throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException{
		servant += n;
		ChangeServant changeServant = new ChangeServant(this, servant);
		play.notifyObserver(changeServant);
	}

	public void decrementServant(int n, Play play)
			throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		servant -= n;
		ChangeServant changeServant = new ChangeServant(this, servant);
		play.notifyObserver(changeServant);
	}

	public void incrementMilitaryPoint(int n, Play play)
			throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException{
		militaryPoint += n;
		ChangeMilitaryPoint changeMilitaryPoint = new ChangeMilitaryPoint(this, militaryPoint);
		play.notifyObserver(changeMilitaryPoint);

	}

	public void decrementMilitaryPoint(int n, Play play)
			throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException{
		militaryPoint -= n;
		ChangeMilitaryPoint changeMilitaryPoint = new ChangeMilitaryPoint(this, militaryPoint);
		play.notifyObserver(changeMilitaryPoint);
	}

	public void incrementFaithPoint(int n, Play play)
			throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException{
		faithPoint += n;
		ChangeFaithPoint changeFaithPoint = new ChangeFaithPoint(this, faithPoint);
		play.notifyObserver(changeFaithPoint);
	}

	public void decrementFaithPoint(int n, Play play)
			throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException{
		faithPoint -= n;
		ChangeFaithPoint changeFaithPoint = new ChangeFaithPoint(this, faithPoint);
		play.notifyObserver(changeFaithPoint);
	}

	public void incrementVictoryPoint(int n, Play play)
			throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException{
		victoryPoint += n;
		ChangeVictoryPoint changeVictoryPoint = new ChangeVictoryPoint(this, victoryPoint);
		play.notifyObserver(changeVictoryPoint);
	}

	public void decrementVictoryPoint(int n, Play play)
			throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		victoryPoint-= n;
		ChangeVictoryPoint changeVictoryPoint = new ChangeVictoryPoint(this, victoryPoint);
		play.notifyObserver(changeVictoryPoint);
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

	public void addCard(Card card, Play play) throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException{
		String type = card.getType();
		switch (type) {
		case "territoryCard": {
			if(territoryCard.size()<6){
			territoryCard.add((TerritoryCard) card);
			ChangeTerritoryCard changeTerritoryCard = new ChangeTerritoryCard(this, territoryCard);
			play.notifyObserver(changeTerritoryCard);}
			else play.notifyObserver(new ChangeNotApplicable(this, "you have too much territory cards!"));
			break;
		}
		case "buildingCard": {
			if(buildingCard.size()<6){
			buildingCard.add((BuildingCard) card);
			ChangeBuildingCard changeBuildingCard = new ChangeBuildingCard(this, buildingCard);
			play.notifyObserver(changeBuildingCard);}
			else play.notifyObserver(new ChangeNotApplicable(this, "you have too much building cards!"));
			break;
		}
		case "characterCard": {
			if(characterCard.size()<6){
			characterCard.add((CharacterCard) card);
			ChangeCharacterCard changeCharacterCard = new ChangeCharacterCard(this, characterCard);
			play.notifyObserver(changeCharacterCard);}
			else play.notifyObserver(new ChangeNotApplicable(this, "you have too much character cards!"));
			break;
		}
		case "ventureCard": {
			if(ventureCard.size()<6){
			ventureCard.add((VentureCard) card);
			ChangeVentureCard changeVentureCard = new ChangeVentureCard(this, ventureCard);
			play.notifyObserver(changeVentureCard);}
			else play.notifyObserver(new ChangeNotApplicable(this, "you have too much venture cards!"));
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


	public void setOccupiedRelative(Relative relative) throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		if(relative.equals(blackRelative)){
			hasBlackRelative=false;
			
		}
		if(relative.equals(whiteRelative)){
			hasWhiteRelative=false;
		}
		if(relative.equals(orangeRelative)){
			hasOrangeRelative=false;
		}
		if(relative.equals(neutralRelative)){
			hasNeutralRelative=false;
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
		if(relative.equals(neutralRelative)){
			return hasNeutralRelative;
		}
		return false;
	}



	public void setFreeRelative(Relative relative) {
		if(relative.equals(blackRelative)){
			hasBlackRelative=true;
		}
		if(relative.equals(whiteRelative)){
			hasWhiteRelative=true;
		}
		if(relative.equals(orangeRelative)){
			hasOrangeRelative=true;
			
		}
		if(relative.equals(neutralRelative)){
			hasNeutralRelative=true;
			
		}
	}



	public void setPersonalBonusTile(PersonalBonusTile personalBonusTileSimple, PersonalBonusTile personalBonusTileAdvanced) {
		this.personalBonusTileSimple = personalBonusTileSimple;
		this.personalBonusTileAdvcanced = personalBonusTileAdvanced;
		
	}



	public PersonalBonusTile getPersonalBonusTileSimple() {
		return personalBonusTileSimple;
	}



	public void setFreeAllRelatives() {
		hasBlackRelative=true;
		hasOrangeRelative=true;
		hasWhiteRelative=true;
		hasNeutralRelative=true;
		activeRelatives.add(blackRelative);
		activeRelatives.add(neutralRelative);
		activeRelatives.add(orangeRelative);
		activeRelatives.add(whiteRelative);
		
	}



	public Relative getRelative(Relative relative) {
		if(relative.equals(blackRelative)){
			return blackRelative;
		}
		if(relative.equals(whiteRelative)){
			return whiteRelative;
		}
		if(relative.equals(orangeRelative)){
			return orangeRelative;
			
		}
		if(relative.equals(neutralRelative)){
			return neutralRelative;
			
		}
		return null;
	}



	
	



}
