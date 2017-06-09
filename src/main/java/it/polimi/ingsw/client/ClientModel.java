package it.polimi.ingsw.client;

import java.io.Serializable;
import java.util.ArrayList;

import it.polimi.ingsw.GC_40.Board;
import it.polimi.ingsw.GC_40.Player;
import it.polimi.ingsw.areas.CouncilPalace;
import it.polimi.ingsw.areas.HarvestAndProductionArea;
import it.polimi.ingsw.areas.MarketBuilding;
import it.polimi.ingsw.areas.Tower;
import it.polimi.ingsw.components.Dice;
import it.polimi.ingsw.components.Relative;

public class ClientModel implements Serializable{
	private Player player;
	private Player currentPlayer;
	private Board board;
	private Tower territoryTower;
	private Tower buildingTower;
	private Tower ventureTower;
	private Tower characterTower;
	private ArrayList<MarketBuilding> market;
	private CouncilPalace councilPalace;
	private HarvestAndProductionArea harvestArea;
	private HarvestAndProductionArea productionArea;
	public static Dice blackDice;
	public static Dice whiteDice;
	public static Dice orangeDice;
	private int period;
	private int round;
	private ArrayList<Player> currentTurnOrder;
	private boolean startPlay;
	
	
	public ClientModel(){
		//players= new ArrayList<Player>();
		currentTurnOrder= new ArrayList<Player>();
		
	}
	
	/*public ArrayList<Player> getPlayers() {
		
		return players;
	}*/


	public void setCouncilPalace(Relative relative) {
		councilPalace.addPlayer(relative.getPlayer());
		
	}


	/*public void addPlayer(Player player) {
		players= new ArrayList<Player>();
		players.add(player);
		this.player=player;
		for(int i=0; i<players.size(); i++){
		System.out.println("I giocatori sono:" + players.get(i).getName());}
		
		
	}*/

	public void setPeriod(int period) {
		this.period=period;
	}


	public void setCurrentPlayer(Player currentPlayer) {
		this.currentPlayer=currentPlayer;
		
	}


	public void setRound(int round) {
		this.round=round;
	}


	public void setCurrentTurnOrder(ArrayList<Player> currentTurnOrder) {
		this.currentTurnOrder=currentTurnOrder;
		
	}


	public void setHarvestLeftArea(Relative relative) {
		harvestArea.setLeftRelative(relative);
	}


	public void setProductionLeftArea(Relative relative) {
		productionArea.setLeftRelative(relative);
		
	}
	
	public void setProductionRightArea(Relative relative) {
		productionArea.setRightRelative(relative);
		
	}


	public void setHarvestRightArea(Relative relative) {
		harvestArea.setRightRelative(relative);
		
	}


	public void setTower(Tower tower, int floor, Relative relative) {
		if(tower.equals(territoryTower)){
			tower.getFloor(floor).setPlayer(relative.getPlayer());
		}
		if(tower.equals(buildingTower)){
			tower.getFloor(floor).setPlayer(relative.getPlayer());
		}
		if(tower.equals(characterTower)){
			tower.getFloor(floor).setPlayer(relative.getPlayer());
		}
		if(tower.equals(ventureTower)){
			tower.getFloor(floor).setPlayer(relative.getPlayer());
		}
		
	}


	public void setMarket(MarketBuilding market, Relative relative) {
		for(MarketBuilding m: this.market){
			if(m.equals(market)){
				market.setOccupied();
				market.setPlayer(relative.getPlayer());
			}
		}
		
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


	public MarketBuilding getMarket(int i) {
		
		return market.get(i);
	}


	public void setBoard(Board board) {
		this.board=board;
		System.out.println(board);
		//players= new ArrayList<Player>();
		
	}

	public Board getBoard() {
		// TODO Auto-generated method stub
		return board;
	}

	public void setPlayer(Player player) {
		// TODO Auto-generated method stub
		this.player=player;
		
	}

	public Player getPlayer() {
		// TODO Auto-generated method stub
		return player;
	}

	public void setStartPlay(boolean b) {
		// TODO Auto-generated method stub
		startPlay=true;
		
	}

	public boolean getStartPlay() {
		// TODO Auto-generated method stub
		return startPlay;
	}

	/*public Player getPlayer(int i) {
		// TODO Auto-generated method stub
		return players.get(i);
	}
	*/
	
	
	

}
