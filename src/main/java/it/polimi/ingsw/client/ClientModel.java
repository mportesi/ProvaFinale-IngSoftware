package it.polimi.ingsw.client;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import org.json.simple.parser.ParseException;

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
	private String name;
	private volatile Player currentPlayer;
	private Board board;
	private int period;
	private int round;
	private ArrayList<Player> currentTurnOrder;
	//private boolean startPlay;
	private ArrayList<ClientModel> clients;
	
	
	public ClientModel(){
		//players= new ArrayList<Player>();
		//currentTurnOrder= new ArrayList<Player>();
		
	}
	
	/*public ArrayList<Player> getPlayers() {
		
		return players;
	}*/


	public void setCouncilPalace(Player player, Relative relative) throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		board.getCouncilPalace().addPlayer(player, relative);
		
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


	public void setHarvestLeftArea(Relative relative) throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		board.getHarvestArea().setLeftRelativeOnHarvest(relative);
	}


	public void setProductionLeftArea(Relative relative) throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		board.getProductionArea().setLeftRelativeOnProduction(relative);
		
	}
	
	public void setProductionRightArea(Relative relative) throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		board.getProductionArea().setRightRelativeOnProduction(relative);
		
	}


	public void setHarvestRightArea(Relative relative) throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		board.getHarvestArea().setRightRelativeOnHarvest(relative);
		
	}


	public void setTower(Tower tower, int floor, Player player, Relative relative) throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		if(tower.getType().equals("territory")){
			board.getTerritoryTower().getFloor(floor).setPlayer(player, relative, tower, floor);
		}
		if(tower.getType().equals("building")){
			board.getBuildingTower().getFloor(floor).setPlayer(player, relative, tower, floor);
		}
		if(tower.getType().equals("character")){
			board.getCharacterTower().getFloor(floor).setPlayer(player, relative, tower, floor);
		}
		if(tower.getType().equals("venture")){
			board.getVentureTower().getFloor(floor).setPlayer(player, relative, tower, floor);
		}
		
	}


	public void setMarket(MarketBuilding market, Player player, Relative relative) throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		for(MarketBuilding m: board.getMarket()){
			if(m.equals(market)){
				market.setOccupied(player, relative, m);
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
		//System.out.println(board);
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

	/*public void setStartPlay(boolean b) {
		startPlay=true;
		
	}

	public boolean getStartPlay() {
		// TODO Auto-generated method stub
		return startPlay;
	}*/

	public Player getCurrentPlayer() {
		// TODO Auto-generated method stub
		return currentPlayer;
	}

	public void setName(String name) {
		// TODO Auto-generated method stub
		this.name = name;
	}

	public String getName() {
		
		return name;
	}

	

}
