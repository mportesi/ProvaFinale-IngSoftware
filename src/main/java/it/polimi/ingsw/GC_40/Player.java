package it.polimi.ingsw.GC_40;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Map;
import java.util.UUID;

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

public class Player extends Observable<Change>{
	private UUID ID;
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
	/*public ArrayList<Relative> relatives;*/
	public Relative blackRelative;
	public Relative whiteRelative;
	public Relative orangeRelative;
	public Relative neutralRelative;
	public PersonalBonusTile personalBonusTile;
	public boolean hasBlackRelative;
	public boolean hasWhiteRelative;
	public boolean hasOrangeRelative;
	public boolean hasNeutralRelative;
	
	
	public Player (UUID ID){
		this.ID=ID;
		Relative blackRelative= new Relative(ColorDice.BLACK);
		Relative whiteRelative= new Relative(ColorDice.WHITE);
		Relative orangeRelative= new Relative(ColorDice.ORANGE);
		Relative neutralRelative= new Relative(null);
		/*relatives.add(blackRelative);
		relatives.add(whiteRelative);
		relatives.add(orangeRelative);
		relatives.add(neutralRelative);*/
		hasBlackRelative=true;
		hasWhiteRelative=true;
		hasOrangeRelative=true;
		hasNeutralRelative=true;
	}
	
	public Player(){
		Relative blackRelative= new Relative(ColorDice.BLACK);
		Relative whiteRelative= new Relative(ColorDice.WHITE);
		Relative orangeRelative= new Relative(ColorDice.ORANGE);
		Relative neutralRelative= new Relative(null);
		/*relatives.add(blackRelative);
		relatives.add(whiteRelative);
		relatives.add(orangeRelative);
		relatives.add(neutralRelative);*/
		hasBlackRelative=true;
		hasWhiteRelative=true;
		hasOrangeRelative=true;
		hasNeutralRelative=true;
	}
	//non va fatta qui
	/*public String chooseResource(){
		Scanner in= new Scanner(System.in);
		System.out.println("Scegli tra: 1: WoodAndStone, 2: Servant ecc" );
				return nextInt();
	}*/
	
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

	public void incrementCoin(int n){
		coin+=n;
		ChangeCoin changeCoin= new ChangeCoin(this, coin);
		this.notifyObserver(changeCoin);
		
	}
	public void decrementCoin(int n){
		coin-=n;
		ChangeCoin changeCoin= new ChangeCoin(this, coin);
		this.notifyObserver(changeCoin);
	}
	public void incrementWood(int n){
		coin+=n;
		ChangeWood changeWood= new ChangeWood(this, coin);
		this.notifyObserver(changeWood);
	}
	public void decrementWood(int n){
		coin-=n;
		ChangeWood changeWood= new ChangeWood(this, coin);
		this.notifyObserver(changeWood);
		
	}
	public void incrementStone(int n){
		coin+=n;
		ChangeStone changeStone= new ChangeStone(this, coin);
		this.notifyObserver(changeStone);
	}
	public void decrementStone(int n){
		coin-=n;
		ChangeStone changeStone= new ChangeStone(this, coin);
		this.notifyObserver(changeStone);
	}
	public void incrementServant(int n){
		coin+=n;
		ChangeServant changeServant= new ChangeServant(this, coin);
		this.notifyObserver(changeServant);
	}
	public void decrementServant(int n){
		coin-=n;
		ChangeServant changeServant= new ChangeServant(this, coin);
		this.notifyObserver(changeServant);
	}
	public void incrementMilitaryPoint(int n){
		coin+=n;
		ChangeMilitaryPoint changeMilitaryPoint= new ChangeMilitaryPoint(this, coin);
		this.notifyObserver(changeMilitaryPoint);
		
	}
	public void decrementMilitaryPoint(int n){
		coin-=n;
		ChangeMilitaryPoint changeMilitaryPoint= new ChangeMilitaryPoint(this, coin);
		this.notifyObserver(changeMilitaryPoint);
	}
	public void incrementFaithPoint(int n){
		coin+=n;
		ChangeFaithPoint changeFaithPoint= new ChangeFaithPoint(this, coin);
		this.notifyObserver(changeFaithPoint);
	}
	public void decrementFaithPoint(int n){
		coin-=n;
		ChangeFaithPoint changeFaithPoint= new ChangeFaithPoint(this, coin);
		this.notifyObserver(changeFaithPoint);
	}
	public void incrementVictoryPoint(int n){
		coin+=n;
		ChangeVictoryPoint changeVictoryPoint= new ChangeVictoryPoint(this, coin);
		this.notifyObserver(changeVictoryPoint);
	}
	public void decrementVictoryPoint(int n){
		coin-=n;
		ChangeVictoryPoint changeVictoryPoint= new ChangeVictoryPoint(this, coin);
		this.notifyObserver(changeVictoryPoint);
	}
	
	public int counter(String cardType){
		int i=0;
		if(cardType.equals("buildingCard")){
		   for(Card card:buildingCard){ 
			if (card!=null){ i+=1;}
		   }
		}
		if(cardType.equals("territoryCard")){
			for(Card card:territoryCard){ 
				if (card!=null){ i+=1;}
			}
		}
		if(cardType.equals("ventureCard")){
			   for(Card card:ventureCard){ 
				if (card!=null){ i+=1;}
			}
		}
		if(cardType.equals("characterCard")){
			   for(Card card:characterCard){ 
				if (card!=null){ i+=1;}
			}
		} 
		return i;
	}
	
	public void addCard(Card card){
		String type=card.getType();
		switch(type){
		case "territoryCard": {
			territoryCard.add((TerritoryCard) card);
			ChangeTerritoryCard changeTerritoryCard= new ChangeTerritoryCard(this, territoryCard);
			this.notifyObserver(changeTerritoryCard);
			break;
		}
		case "buildingCard": {
			buildingCard.add((BuildingCard) card);
			ChangeBuildingCard changeBuildingCard= new ChangeBuildingCard(this, buildingCard);
			this.notifyObserver(changeBuildingCard);
			break;
		}
		case "characterCard": {
			characterCard.add((CharacterCard) card);
			ChangeCharacterCard changeCharacterCard= new ChangeCharacterCard(this, characterCard);
			this.notifyObserver(changeCharacterCard);
			break;
		}
		case "ventureCard": {
			ventureCard.add((VentureCard) card);
			ChangeVentureCard changeVentureCard= new ChangeVentureCard(this, ventureCard);
			this.notifyObserver(changeVentureCard);
			break;
		}
		}
		
	}
	
	public void chooseCharacterCard(int value, Map<String, Integer> discount){
		
		
	}


	public void setCoin(int i) {
		coin = i;
	}


	public void setWood(int i) {
		wood=i;
	}


	public void setServant(int i) {
		servant=i;
	}


	public void setStone(int i) {
		stone=i;
	}


	public void setMilitaryPoint(int i) {
		militaryPoint=i;
	}


	public void setVictoryPoint(int i) {
		victoryPoint=i;
	}


	public void setFaithPoint(int i) {
		faithPoint=i;
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
		this.buildingCard=buildingCard;
	}

	public void setCharacter(ArrayList<CharacterCard> characterCard) {
		this.characterCard=characterCard;
	}

	public void setTerritoryCard(ArrayList<TerritoryCard> territoryCard) {
		this.territoryCard=territoryCard;
	}

	public void setVentureCard(ArrayList<VentureCard> ventureCard) {
		this.ventureCard=ventureCard;
		
	}

	
}

