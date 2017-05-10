package it.polimi.ingsw.GC_40;

public class Player {
	private int coin;
	private int wood;
	private int stone;
	private int servant;
	private ColorPlayer color;
	private int faithPoint;
	private int victoryPoint;
	private int militaryPoint;
	private Card[] territory;
	private Card[] character;
	private Card[] building;
	private Card[] venture;
	private LeaderTile[] leader;
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
	
	
}
