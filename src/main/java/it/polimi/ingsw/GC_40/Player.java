package it.polimi.ingsw.GC_40;

public class Player {
	private ColorPlayer color;
	private int coin;
	private int wood;
	private int stone;
	private int servant;
	private int faithPoint;
	private int victoryPoint;
	private int militaryPoint;
	private TerritoryCard[] territory;
	private CharacterCard[] character;
	private BuildingCard[] building;
	private VentureCard[] venture;
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
		   for(each card:building[]){ 
			if (building[]!=null){ i+=1;}
		   }
		}
		if(type.equals(territory)){
			   for(each card:territory[]){ 
				if (territory[]!=null){ i+=1;}
			}
		}
		if(type.equals(venture)){
			   for(each card:venture[]){ 
				if (venture[]!=null){ i+=1;}
			}
		}
		if(type.equals(character)){
			   for(each card:character[]){ 
				if (character[]!=null){ i+=1;}
			}
		} 
	}
	
	
}
