package it.polimi.ingsw.GC_40;

import java.util.ArrayList;
import java.util.Map;

import it.polimi.ingsw.cards.BuildingCard;
import it.polimi.ingsw.cards.Card;
import it.polimi.ingsw.cards.CharacterCard;
import it.polimi.ingsw.cards.TerritoryCard;
import it.polimi.ingsw.cards.VentureCard;
import it.polimi.ingsw.colors.ColorDice;
import it.polimi.ingsw.colors.ColorPlayer;
import it.polimi.ingsw.components.LeaderTile;
import it.polimi.ingsw.components.PersonalBonusTile;
import it.polimi.ingsw.components.Relative;

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
	
	
	public Player (ColorPlayer color){
		this.color=color;
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
	
	public String chooseResource(){
		Scanner in= new Scanner(System.in);
		System.out.println("Scegli tra: 1: WoodAndStone, 2: Servant ecc" );
				return nextInt();
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


	public void setVictorypoint(int i) {
		victoryPoint=i;
	}


	public void setFaithPoint(int i) {
		faithPoint=i;
	}


	public void setColor(ColorPlayer colorPlayer) {
		color = colorPlayer;
	}
}

