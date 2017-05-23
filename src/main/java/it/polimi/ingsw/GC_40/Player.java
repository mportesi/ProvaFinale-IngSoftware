package it.polimi.ingsw.GC_40;

import Components.Building;
import Components.Card;
import Components.LeaderTile;
import Components.Territory;
import Components.Venture;
import Components.Character;

public class Player {
	private ColorPlayer color;
	private int coin;
	private int wood;
	private int stone;
	private int servant;
	private int faithPoint;
	private int victoryPoint;
	private int militaryPoint;
	private Territory[] territory;
	private Character[] character;
	private Building[] building;
	private Venture[] venture;
	private LeaderTile[] leader;
	private boolean blackRelative;
	private boolean whiteRelative;
	private boolean orangeRelative;
	private boolean neutralRelative;
	
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
	public Card[] getTerritory() {
		return territory;
	}
	public Card[] getCharacter() {
		return character;
	}
	public Card[] getBuilding() {
		return building;
	}
	public Card[] getVenture() {
		return venture;
	}
	public LeaderTile[] getLeader() {
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
		if(type.equals(building)){
		   for(Card card:building){ 
			if (card!=null){ i+=1;}
		   }
		}
		if(type.equals(territory)){
			for(Card card:territory){ 
				if (card!=null){ i+=1;}
			}
		}
		if(type.equals(venture)){
			   for(Card card:venture){ 
				if (card!=null){ i+=1;}
			}
		}
		if(type.equals(character)){
			   for(Card card:character){ 
				if (card!=null){ i+=1;}
			}
		} 
		return i;
	}
	
	
}
