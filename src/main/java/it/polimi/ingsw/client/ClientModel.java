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
	private Dice blackDice;
	private Dice whiteDice;
	private Dice orangeDice;
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
		board.getCouncilPalace().addPlayer(relative.getPlayer());
		
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
		board.getHarvestArea().setLeftRelative(relative);
	}


	public void setProductionLeftArea(Relative relative) {
		board.getProductionArea().setLeftRelative(relative);
		
	}
	
	public void setProductionRightArea(Relative relative) {
		board.getProductionArea().setRightRelative(relative);
		
	}


	public void setHarvestRightArea(Relative relative) {
		board.getHarvestArea().setRightRelative(relative);
		
	}


	public void setTower(Tower tower, int floor, Relative relative) {
		if(tower.equals(board.getTerritoryTower())){
			tower.getFloor(floor).setPlayer(relative.getPlayer());
		}
		if(tower.equals(board.getBuildingTower())){
			tower.getFloor(floor).setPlayer(relative.getPlayer());
		}
		if(tower.equals(board.getCharacterTower())){
			tower.getFloor(floor).setPlayer(relative.getPlayer());
		}
		if(tower.equals(board.getVentureTower())){
			tower.getFloor(floor).setPlayer(relative.getPlayer());
		}
		
	}


	public void setMarket(MarketBuilding market, Relative relative) {
		for(MarketBuilding m: board.getMarket()){
			if(m.equals(market)){
				market.setOccupied();
				market.setPlayer(relative.getPlayer());
			}
		}
		
	}


	public Tower getTerritoryTower() {
		return board.getTerritoryTower();
	}


	public Tower getBuildingTower() {
		return board.getBuildingTower();
	}


	public Tower getCharacterTower() {
		return board.getCharacterTower();
	}
	
	public Tower getVentureTower() {
		return board.getVentureTower();
	}


	public MarketBuilding getMarket(int i) {
		
		return board.getMarket(i);
	}


	public void setBoard(Board board) {
		this.board=board;
		System.out.println(board);
		//players= new ArrayList<Player>();
		
	}

	public Board getBoard() {
		return board;
	}

	public void setPlayer(Player player) {
		this.player=player;
		
	}

	public Player getPlayer() {
		return player;
	}

	public void setStartPlay(boolean b) {
		startPlay=true;
		
	}

	public boolean getStartPlay() {
		// TODO Auto-generated method stub
		return startPlay;
	}

	

}
