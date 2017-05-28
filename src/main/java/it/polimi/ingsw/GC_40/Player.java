package it.polimi.ingsw.GC_40;

import java.util.ArrayList;

import Components.BuildingCard;
import Components.Card;
import Components.LeaderTile;
import Components.Relative;
import Components.TerritoryCard;
import Components.VentureCard;
import Components.CharacterCard;

public class Player {
	
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
	public Relative blackRelative;
	public Relative whiteRelative;
	public Relative orangeRelative;
	public Relative neutralRelative;
	
	
	
	public Player (ColorPlayer color){
		this.color=color;
		Relative blackRelative= new Relative(ColorDice.BLACK);
		Relative whiteRelative= new Relative(ColorDice.WHITE);
		Relative orangeRelative= new Relative(ColorDice.ORANGE);
		Relative neutralRelative= new Relative(null);
		
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

	public void incrementCoin(int n){
		coin+=n;
	}
	public void decrementCoin(int n){
		coin-=n;
	}
	public void incrementWood(int n){
		coin+=n;
	}
	public void decrementWood(int n){
		coin-=n;
	}
	public void incrementStone(int n){
		coin+=n;
	}
	public void decrementStone(int n){
		coin-=n;
	}
	public void incrementServant(int n){
		coin+=n;
	}
	public void decrementServant(int n){
		coin-=n;
	}
	public void incrementMilitaryPoint(int n){
		coin+=n;
	}
	public void decrementMilitaryPoint(int n){
		coin-=n;
	}
	public void incrementFaithPoint(int n){
		coin+=n;
	}
	public void decrementFaithPoint(int n){
		coin-=n;
	}
	public void incrementVictoryPoint(int n){
		coin+=n;
	}
	public void decrementVictoryPoint(int n){
		coin-=n;
	}
	
	public int counter(Card c){
		String type=c.getType();
		int i=0;
		if(type.equals(buildingCard)){
		   for(Card card:buildingCard){ 
			if (card!=null){ i+=1;}
		   }
		}
		if(type.equals(territoryCard)){
			for(Card card:territoryCard){ 
				if (card!=null){ i+=1;}
			}
		}
		if(type.equals(ventureCard)){
			   for(Card card:ventureCard){ 
				if (card!=null){ i+=1;}
			}
		}
		if(type.equals(characterCard)){
			   for(Card card:characterCard){ 
				if (card!=null){ i+=1;}
			}
		} 
		return i;
	}
	
	public void getCard(Card card){
		String type=card.getType();
		switch(type){
		case "territoryCard": {
			territoryCard.add((TerritoryCard) card);
			break;
		}
		case "buildingCard": {
			buildingCard.add((BuildingCard) card);

			break;
		}
		case "characterCard": {
			characterCard.add((CharacterCard) card);
			break;
		}
		case "ventureCard": {
			ventureCard.add((VentureCard) card);
			break;
		}
		}
		
		}
	}

