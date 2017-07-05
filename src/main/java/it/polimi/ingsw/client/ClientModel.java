package it.polimi.ingsw.client;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Timer;

import org.json.simple.parser.ParseException;

import gui.BoardController;
import it.polimi.ingsw.GC_40.Board;
import it.polimi.ingsw.GC_40.Player;
import it.polimi.ingsw.GC_40.TimerAction;
import it.polimi.ingsw.actions.Quit;
import it.polimi.ingsw.actions.ShiftPlayer;
import it.polimi.ingsw.areas.CouncilPalace;
import it.polimi.ingsw.areas.HarvestAndProductionArea;
import it.polimi.ingsw.areas.MarketBuilding;
import it.polimi.ingsw.areas.Tower;
import it.polimi.ingsw.cards.Card;
import it.polimi.ingsw.components.Dice;
import it.polimi.ingsw.components.Relative;
import it.polimi.ingsw.json.JsonTimeOut;
import it.polimi.ingsw.serverRMI.ServerRMIConnectionViewRemote;

public class ClientModel implements Serializable {
	private Player player;
	private BufferedReader in;
	private String name;
	private volatile Player currentPlayer;
	private Board board;
	private int period;
	private int round;
	private ArrayList<Player> currentTurnOrder;
	private ArrayList<ClientModel> clients;
	private boolean endGame;
	private boolean quit = false;
	private ServerRMIConnectionViewRemote serverStub;
	private Thread action;
	private boolean gui;
	private boolean cli;
	private BoardController boardControllerGUI;
	private Timer timer = new Timer();
	
	public ClientModel(ServerRMIConnectionViewRemote serverStub){
		in = new BufferedReader(new InputStreamReader(System.in));
		this.serverStub=serverStub;
		this.gui=true;
	
	}

	public void setCouncilPalace(Player player, Relative relative)
			throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		board.getCouncilPalace().addPlayer(player, relative);
		board.getCouncilPalace().getRelatives().add(relative);
		if(gui){
			boardControllerGUI.setCouncilPalace(player, relative);
		}
	}

	public void setPeriod(int period) {
		this.period = period;
	}

	public void setCurrentPlayer(Player currentPlayer) {
		this.currentPlayer = currentPlayer;
		
		// chiamo cli in un thread
		// scatta timer thread a null
		System.out.println("The EG is: " +endGame);
		if (!endGame && currentPlayer.getName().equals(player.getName())) {
			JsonTimeOut jsonTimeOut = null;
			try {
				jsonTimeOut = new JsonTimeOut();
			} catch (IOException | ParseException e1) {
				e1.printStackTrace();
			}
			int timeOutAction = jsonTimeOut.getTimeOutAction();
			timer = new Timer();
			
			action = new Thread(() -> {
				try {

					CommandLineInterface commandLineInterface = new CommandLineInterface(this, serverStub, timer);
					
						if (action != null) {
							
							commandLineInterface.input();
						
					}
				} catch (Exception e) {
					e.printStackTrace();
				}

			});
			action.start();
			timer.schedule(new TimerAction(serverStub) {
				public void run() {
					System.out.println("It ran out of time!");
					
							try {
								try {
									timer.cancel();
									serverStub.notifyObserver(new Quit(player, player.getMatch()));
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							} catch (FileNotFoundException e3) {
								// TODO Auto-generated catch block
								e3.printStackTrace();
							} catch (NullPointerException e3) {
								// TODO Auto-generated catch block
								e3.printStackTrace();
							} catch (RemoteException e3) {
								// TODO Auto-generated catch block
								e3.printStackTrace();
							} catch (IOException e3) {
								// TODO Auto-generated catch block
								e3.printStackTrace();
							} catch (ParseException e3) {
								// TODO Auto-generated catch block
								e3.printStackTrace();
							}
					
						setQuit(true);
						
						
						
						
						int input0;
						try {
							input0 = Integer.parseInt(in.readLine());
							switch(input0){
							case 0: 
								System.out.println("reconnect");
								try {
									try {
										serverStub.notifyObserver(new Reconnect(player, player.getMatch()));
									} catch (InterruptedException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
								} catch (FileNotFoundException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								} catch (NullPointerException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								} catch (RemoteException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								} catch (ParseException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								
							break;
							}
						} catch (NumberFormatException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					
					
					ShiftPlayer shiftPlayer = new ShiftPlayer(player.getMatch());
					

					//action=null;
					try {
						serverStub.notifyObserver(shiftPlayer);
						timer.cancel();
						
					} catch (NullPointerException | IOException | ParseException | InterruptedException e) {
						e.printStackTrace();
					}
					}
				
			}, (long) (timeOutAction) * 1000);
}
		
		if(gui){
			boardControllerGUI.setCurrentPlayer();
		}

	}
		

	public void setRound(int round) {
		this.round = round;
	}

	public void setCurrentTurnOrder(ArrayList<Player> currentTurnOrder) {
		this.currentTurnOrder = currentTurnOrder;
		if(gui){
			boardControllerGUI.giveCurrentTurnOrder(currentTurnOrder);
		}

	}

	public void setHarvestLeftArea(Relative relative)
			throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		board.getHarvestArea().setLeftRelativeOnHarvest(relative);
		if(gui){
			boardControllerGUI.setHarvestLeftArea(relative);
		}
	}


	public void setProductionLeftArea(Relative relative) throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		board.getProductionArea().setLeftRelativeOnProduction(relative);
		if(gui){
			boardControllerGUI.setProductionLeftArea(relative);
		}
	}

	public void setProductionRightArea(Relative relative)
			throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		board.getProductionArea().setRightRelativeOnProduction(relative);
		if(gui){
			boardControllerGUI.setProductionRightArea(relative);
		}
	}

	

	public void setHarvestRightArea(Relative relative) throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		board.getHarvestArea().setRightRelativeOnHarvest(relative);
		if(gui){
			boardControllerGUI.setHarvestRightArea(relative);
		}
		
	}

	public void setTower(Tower tower, int floor, Player player, Relative relative)
			throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		if (tower.getType().equals("territory")) {
			board.getTerritoryTower().getFloor(floor).setPlayer(player, relative, tower, floor);
		}
		if (tower.getType().equals("building")) {
			board.getBuildingTower().getFloor(floor).setPlayer(player, relative, tower, floor);
		}
		if (tower.getType().equals("character")) {
			board.getCharacterTower().getFloor(floor).setPlayer(player, relative, tower, floor);
		}
		if (tower.getType().equals("venture")) {
			board.getVentureTower().getFloor(floor).setPlayer(player, relative, tower, floor);
		}
		if(gui){
			boardControllerGUI.setTower(tower, floor, player, relative);
		}
	}

	public void setMarket(MarketBuilding market, Player player, Relative relative)
			throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		for (MarketBuilding m : board.getMarket()) {
			if (m.getType().equals(market.getType())) {
				m.setOccupied(player, relative, m);
			}
		}
		if(gui){
			boardControllerGUI.setMarket(market, player, relative);
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

	public Timer getTimer(){
		return timer;
	}
	
	public MarketBuilding getMarket(int i) {

		return board.getMarket(i);
	}

	

	public void setBoard(Board board) {
		this.board=board;
		if(gui){
			boardControllerGUI.setBoard();
		}
		
	}
	
	public void initializeBoard(Board board) {
		this.board=board;
		if(gui){
			boardControllerGUI.initializeBoard(this);
		}
		
	}

	public Board getBoard() {
		return board;
	}

	public void setPlayer(Player player) {
		this.player = player;
		if(gui){
			boardControllerGUI.setPlayer(player);
		}

	}

	public Player getPlayer() {
		return player;
	}

	public Player getCurrentPlayer() {
		return currentPlayer;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setEndGame() {
		endGame = true;
	}

	public boolean getEndGame() {
		return endGame;
	}

	public void setQuit(boolean b) {
		quit = b;
	}

	public boolean getQuit() {
		return quit;
	}


	public int getMatch() {
		return player.getMatch();
	}


	public void setCli(boolean b) {
		cli=b;
	}
	public void setGui(boolean b) {
		gui=b;
	}


	public void setBoardController(BoardController boardController) {
		System.out.println(boardController);
		this.boardControllerGUI=boardController;
		System.out.println(boardControllerGUI);
	}


	public String getCurrentTurnOrder() {
		return currentTurnOrder.toString();
	}

	public void actionNotApplicable() {
		if(gui){
			boardControllerGUI.actionNotApplicable();
		}
		
	}

	

}
