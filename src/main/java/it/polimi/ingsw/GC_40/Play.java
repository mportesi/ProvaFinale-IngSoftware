package it.polimi.ingsw.GC_40;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.rmi.AlreadyBoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.actions.Action;
import it.polimi.ingsw.actions.RegisterClient;
import it.polimi.ingsw.areas.Floor;
import it.polimi.ingsw.areas.MarketBuilding;
import it.polimi.ingsw.cards.VentureCard;
import it.polimi.ingsw.changes.Change;
import it.polimi.ingsw.changes.ChangeCoin;
import it.polimi.ingsw.changes.ChangeColor;
import it.polimi.ingsw.changes.ChangeCouncilPalace;
import it.polimi.ingsw.changes.ChangeEndGame;
import it.polimi.ingsw.changes.ChangeInitializeBoard;
import it.polimi.ingsw.changes.ChangeInitializePlay;
import it.polimi.ingsw.changes.ChangeNewPlayer;
import it.polimi.ingsw.changes.ChangeNotApplicable;
import it.polimi.ingsw.changes.ChangeNumberOfPlayers;
import it.polimi.ingsw.changes.ChangePeriod;
import it.polimi.ingsw.changes.ChangePlayer;
import it.polimi.ingsw.changes.ChangeRound;
import it.polimi.ingsw.changes.ChangeServant;
import it.polimi.ingsw.changes.ChangeStone;
import it.polimi.ingsw.changes.ChangeTurnOrder;
import it.polimi.ingsw.changes.ChangeWinners;
import it.polimi.ingsw.changes.ChangeWood;
import it.polimi.ingsw.client.ClientModel;
import it.polimi.ingsw.colors.ColorDice;
import it.polimi.ingsw.colors.ColorPlayer;
import it.polimi.ingsw.components.Dice;
import it.polimi.ingsw.components.FinalVictoryPoint;
import it.polimi.ingsw.components.PersonalBonusTile;
import it.polimi.ingsw.effects.GainVictoryPointForTerritoryCard;
import it.polimi.ingsw.json.JsonFinalVictoryPoint;
import it.polimi.ingsw.json.JsonPersonalBonusTiles;
import it.polimi.ingsw.json.JsonTimeOut;

public class Play extends Observable<Change> implements Observer<Change>, Serializable {
	private ArrayList<Player> players;
	private ArrayList <Player> disconnectedPlayers;
	private Dice blackDice;
	private Dice whiteDice;
	private Dice orangeDice;
	private Player currentPlayer;
	private Board board;
	private volatile int period = 0;
	private volatile int round;
	private ArrayList<Player> currentTurnOrder;
	private volatile int changeRound;
	private int match;
	private boolean initializing;
	
	// costruttore
	public Play(int match) throws FileNotFoundException, NullPointerException, IOException, ParseException {
		this.players = new ArrayList<Player>();
		this.disconnectedPlayers = new ArrayList <Player>();
		changeRound=0;
		this.initializing = true;
	}

	public void initializeBoard(int match)
			throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		this.board = new Board(this, players.size());
		this.match = match;
		board.registerObserver(this);
		
		this.round = 0;
		this.period = 0;
		changePeriod();
		changeRound();
		ChangeInitializeBoard changeInitializeBoard = new ChangeInitializeBoard(board, currentPlayer);
		this.notifyObserver(changeInitializeBoard);
	
		

	}

	public void giveStartingCoin(ArrayList<Player> currentTurnOrder)
			throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		int coin = 5;
		for (Player p : currentTurnOrder) {
			p.setCoin(coin);
			ChangeCoin changeCoin = new ChangeCoin(p, p.getCoin());
			this.notifyObserver(changeCoin);
			coin++;
		}

	}

	public void initializePlayer(int match)
			throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		
		
		currentTurnOrder = createTurnOrder(players);
		this.currentPlayer = currentTurnOrder.get(0);
		ColorPlayer[] colors = ColorPlayer.values();
		for (int i = 0; i < currentTurnOrder.size(); i++) {
			currentTurnOrder.get(i).setColor(colors[i]);
			ChangeColor changeColor = new ChangeColor(currentTurnOrder.get(i), colors[i]);
			this.notifyObserver(changeColor);
		}
		for (Player p : currentTurnOrder) {
			p.setWood(2);
			ChangeWood changeWood = new ChangeWood(p, p.getWood());
			this.notifyObserver(changeWood);
			p.setServant(3);
			ChangeServant changeServant = new ChangeServant(p, p.getServant());
			this.notifyObserver(changeServant);
			p.setStone(2);
			ChangeStone changeStone = new ChangeStone(p, p.getStone());
			this.notifyObserver(changeStone);
			p.setMilitaryPoint(0);
			p.setVictoryPoint(0);
			p.setFaithPoint(0);
			p.getNeutralRelative().setValue(0);
		}
		giveStartingCoin(currentTurnOrder);
	}

	public static ArrayList<Player> createTurnOrder(ArrayList<Player> players) {
		Collections.shuffle(players);
		ChangeTurnOrder changeTurnOrder = new ChangeTurnOrder(players);
		return players;
	}

	public void changeTurnOrder()
			throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {

		ArrayList<Player> nextTurnOrder = new ArrayList<Player>();
		ArrayList<Player> councilPalaceOrder = board.getCouncilPalace().getOrder();
		ArrayList<Player> currentTurnOrder2= new ArrayList<Player>();
		
		for (Player p : councilPalaceOrder){
			nextTurnOrder.add(p);
		}
		
		for (Player p : currentTurnOrder){
	
			if (!(board.getCouncilPalace().isAlreadyPresent(p))){
				nextTurnOrder.add(p);
			}
		}
		
		currentTurnOrder = nextTurnOrder;
		changeCurrentPlayer();
		
		ChangeTurnOrder changeTurnOrder = new ChangeTurnOrder(currentTurnOrder);
		this.notifyObserver(changeTurnOrder);
		
		/*for (Player player : currentTurnOrder){
		currentTurnOrder2.add(player);
		}
		
		
		
		for (Player checkedPlayer : councilPalaceOrder) {
			nextTurnOrder.add(checkedPlayer);

			for (Player nowPlayer : currentTurnOrder2) {
				if (nowPlayer.equals(checkedPlayer)) {
					currentTurnOrder.remove(nowPlayer);
				}

			}

		}

		for (Player p : currentTurnOrder) {
			nextTurnOrder.add(p);
		}
		currentTurnOrder.clear();
		currentTurnOrder.addAll(nextTurnOrder);
		nextTurnOrder.clear();

		ChangeTurnOrder changeTurnOrder = new ChangeTurnOrder(currentTurnOrder);

		this.notifyObserver(changeTurnOrder);
	}*/
	}

	public synchronized void changeCurrentPlayer()
			throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		int i = 0;
		System.out.println("The round is: " + changeRound);
		while (currentTurnOrder.get(i) != currentPlayer && i<currentTurnOrder.size()-1) {
			i++;
		}
		if (i == (currentTurnOrder.size() - 1)) {
			currentPlayer = currentTurnOrder.get(0);
			changeRound++;
		} else {
			currentPlayer = currentTurnOrder.get(i + 1);
		}
		
		
		

		if (changeRound == 4) {
			changeRound = 0;
			
			changeRound();
			
		}
		
		ChangePlayer changePlayer = new ChangePlayer(currentPlayer);

		this.notifyObserver(changePlayer);
	}

	public synchronized void changeRound()
			throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		
		if (round != 0) {
			changeTurnOrder();
		}
		round += 1;
		
		// refresh tower( place new card and remove family member)
		board.getTerritoryTower().refreshTower(period);
		board.getBuildingTower().refreshTower(period);
		board.getCharacterTower().refreshTower(period);
		board.getVentureTower().refreshTower(period);

		// refresh harvest and production area
		board.getHarvestArea().refresh();
		board.getProductionArea().refresh();

		// refresh market
		board.getMarket(0).setFree();
		board.getMarket(1).setFree();
		if (players.size() == 4) {
			board.getMarket(2).setFree();
			board.getMarket(3).setFree();
		}

		// refresh council palace
		board.getCouncilPalace().refresh();

	
		board.getBlackDice().setValue();
		board.getOrangeDice().setValue();
		board.getWhiteDice().setValue();

		for (Player p : players) {
			
			p.setFreeAllRelatives();
			p.getBlackRelative().setValue(board.getBlackDice().getValue());
			p.getWhiteRelative().setValue(board.getWhiteDice().getValue());
			p.getOrangeRelative().setValue(board.getOrangeDice().getValue());
		}
		
		ChangeRound changeRound = new ChangeRound(round, board, match);
		this.notifyObserver(changeRound);
		
		if ((round-1) == 1 || (round-1) == 3 || (round-1) == 5) {
			changePeriod();
	}}

	public synchronized void changePeriod()
			throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		period++;
		

		if (period == 4) {
			checkWinner();
		} else {
			
			ChangePeriod changePeriod = new ChangePeriod(period,match);
			this.notifyObserver(changePeriod);
		}

	}

	public static ArrayList<Player> militaryPointRank(ArrayList<Player> players) {
		ArrayList<Player> ordinata = new ArrayList<>();
		ordinata.addAll(players);
		for (int i = 0; i < ordinata.size(); i++) {
			for (int j = i; j < ordinata.size(); j++) {
				if (ordinata.get(i).getMilitaryPoint() < ordinata.get(j).getMilitaryPoint()) {
					System.out.println("scambio" + i + "e" + j);
					Collections.swap(ordinata, i, j);
				}
			}
		}
		return ordinata;
	}

	public void giveFinalPoint()
			throws FileNotFoundException, IOException, ParseException, NullPointerException, InterruptedException {
		JsonFinalVictoryPoint finalVictoryPoint = new JsonFinalVictoryPoint();
		finalVictoryPoint.importVictoryPoint();
		ArrayList<FinalVictoryPoint> list = finalVictoryPoint.getFinalVictoryPointList();

		for (Player p : players) {
			for (VentureCard v : p.getVenture()) {
				// TO DO:PERMANENT EFFECT SONO I VICTORY POINT, DA USARE POI PER
				// LA CLASSIFICA
			}

			for (FinalVictoryPoint f : list) {
				String type = f.getType();
				switch (type) {
				case "victoryPointForTerritory": {
					int numberOfTerritoryCard = p.counter("territoryCard");
					System.out.println("The player " + p + "has " + numberOfTerritoryCard +" territoryCard");
					if (numberOfTerritoryCard >= 1) {
						p.incrementVictoryPoint(f.getFinalVictoryPointForOne(), this);

					}
					if (numberOfTerritoryCard >= 2) {
						p.incrementVictoryPoint(f.getFinalVictoryPointForTwo(), this);

					}
					if (numberOfTerritoryCard >= 3) {
						p.incrementVictoryPoint(f.getFinalVictoryPointForThree(), this);

					}
					if (numberOfTerritoryCard >= 4) {
						p.incrementVictoryPoint(f.getFinalVictoryPointForFour(), this);

					}
					if (numberOfTerritoryCard >= 5) {
						p.incrementVictoryPoint(f.getFinalVictoryPointForFive(), this);

					}
					if (numberOfTerritoryCard >= 6) {
						p.incrementVictoryPoint(f.getFinalVictoryPointForSix(), this);

					}
					break;
				}

				case "victoryPointForCharacter": {
					int numberOfCharacterCard = p.counter("characterCard");
					System.out.println("The player " + p + "has " + numberOfCharacterCard +" characterCard");
					if (numberOfCharacterCard >= 1) {
						p.incrementVictoryPoint(f.getFinalVictoryPointForOne(), this);

					}
					if (numberOfCharacterCard >= 2) {
						p.incrementVictoryPoint(f.getFinalVictoryPointForTwo(), this);

					}
					if (numberOfCharacterCard >= 3) {
						p.incrementVictoryPoint(f.getFinalVictoryPointForThree(), this);

					}
					if (numberOfCharacterCard >= 4) {
						p.incrementVictoryPoint(f.getFinalVictoryPointForFour(), this);

					}
					if (numberOfCharacterCard >= 5) {
						p.incrementVictoryPoint(f.getFinalVictoryPointForFive(), this);

					}
					if (numberOfCharacterCard >= 6) {
						p.incrementVictoryPoint(f.getFinalVictoryPointForSix(), this);

					}
					break;
				}

				case "victoryPointForResource": {
					int numberOfResource = p.resourceCounter();
					System.out.println("The player " + p + "has " + numberOfResource +" resources");
					p.incrementVictoryPoint(f.getFinalVictoryPointForFive() * (numberOfResource / 5), this);
					break;
				}

				case "victoryPointForMilitaryRecord": {
					if (p == militaryPointRank(players).get(0)) {
						p.incrementVictoryPoint(f.getFinalVictoryPointForOne(), this);
					}
					if (p == militaryPointRank(players).get(1)) {
						p.incrementVictoryPoint(f.getFinalVictoryPointForTwo(), this);
					}
					break;

				}
				}
			}
		}
	}

	public void endGame() throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		ChangeEndGame changeEndGame= new ChangeEndGame(match);
		// restituisce la classifica e il vincitore
		notifyObserver(changeEndGame);
	}

	public void checkWinner()
			throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		System.out.println("Sono nel checkWinner()");
	/*	ChangeEndGame changeEndGame = new ChangeEndGame(match);
		notifyObserver(changeEndGame);*/
		ArrayList<Player> winners = new ArrayList<Player>();
		int max = 0;
		giveFinalPoint();
		for (Player p : currentTurnOrder) {
			if (p.getVictoryPoint() > max) {
				max = p.getVictoryPoint();
				winners.clear();
				winners.add(p);
			} else if (p.getVictoryPoint() == max) {
				winners.add(p);
			}
		}
		ChangeWinners changeWinners = new ChangeWinners(winners);
		this.notifyObserver(changeWinners);

	}

	@Override
	public void update(Change c)
			throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		this.notifyObserver(c);
	}

	public void createNewPlayer(String name, int match)
			throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		JsonTimeOut jsonTimeOut = new JsonTimeOut();
		int timeOutStartPlay = jsonTimeOut.getTimeOutStartPlay();
		if (players == null) {
			this.players = new ArrayList<Player>();
		}
		
		
		if (players!=null && players.size() < 4) {
			JsonPersonalBonusTiles jsonPersonalBonusTiles = new JsonPersonalBonusTiles();
			jsonPersonalBonusTiles.importPersonalBonusTiles();
			PersonalBonusTile personalBonusTileSimple = jsonPersonalBonusTiles.getPersonalBonusTiles(0);
			PersonalBonusTile personalBonusTileAdvanced = jsonPersonalBonusTiles.getPersonalBonusTiles(1);
			Player player = new Player(UUID.randomUUID(), this, name, match);
			players.add(player);
			player.setPersonalBonusTile(personalBonusTileSimple, personalBonusTileAdvanced);
			player.registerObserver(this);
			notifyObserver(new ChangeNewPlayer(player, match));
		
		}
		if (players.size() == 2) {
			if(players.size()!=4){
			Thread.sleep((long) timeOutStartPlay *50);
			System.out.println("E' scaduto il timeout!");}
			initializePlay(match);
		}

	}

	/*
	 * private void verifyNumberOfPlayer(String name) throws
	 * FileNotFoundException, NullPointerException, IOException, ParseException,
	 * InterruptedException { if (players.size() == 2 && players.size() < 4) {
	 * 
	 * 
	 * /* Timer timer = new Timer(); timer.schedule(new TimerTask() {
	 * 
	 * @Override public void run() {
	 * 
	 * System.out.println("sono entrato nel run"); try {
	 * 
	 * initializePlay();
	 * 
	 * }
	 * 
	 * catch (NullPointerException | IOException | ParseException e) {
	 * 
	 * } catch (InterruptedException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); }
	 * 
	 * }
	 * 
	 * }, 10 * 1000); // TODO IMPORTARE DA JSON }}
	 */

	// else if(players.size()==4)

	private void initializePlay(int match)
			throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		this.initializing = false;
		initializePlayer(match);
		initializeBoard(match);
		ChangeTurnOrder changeTurnOrder = new ChangeTurnOrder (currentTurnOrder);
		this.notifyObserver(changeTurnOrder);
		/*ChangeInitializePlay changeInitializePlay = new ChangeInitializePlay(players.size());
		this.notifyObserver(changeInitializePlay);*/
	}

	public Board getBoard() {
		return board;
	}

	@Override
	public void update() {
	}

	public ArrayList<Player> getPlayers() {
		return players;
	}

	public void removePlayer(Player player) throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		Player playerToRemove=null;
		
		for(int i=0; i<players.size(); i++){
			if (players.get(i).getID().equals(player.getID())){
				playerToRemove=players.get(i);
				players.remove(playerToRemove);
			}
		}
		try {
			notifyObserver(new ChangeNumberOfPlayers(players.size(), player, board));
		} catch (NullPointerException | IOException | ParseException | InterruptedException e) {
			e.printStackTrace();
		}
		currentTurnOrder.remove(player);
		if (currentTurnOrder.size()>1){
		ChangeTurnOrder changeCurrentTurnOrder = new ChangeTurnOrder(currentTurnOrder);
		notifyObserver(changeCurrentTurnOrder);
		changeCurrentPlayer();
	
		}
		
		if(players.size()==1){
			endGame();
			checkWinner();
			
		}
		
		
	}

	public boolean getInitializing() {
		// TODO Auto-generated method stub
		return initializing;
	}

	public ArrayList <Player> getDisconnectedPlayers() {
		// TODO Auto-generated method stub
		return disconnectedPlayers;
	}

	public ArrayList<Player> getCurrentTurnOrder() {
		// TODO Auto-generated method stub
		return currentTurnOrder;
	}

	public void reconnect(Player player) throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		players.add(player);
		disconnectedPlayers.remove(player);
		System.out.println(currentTurnOrder);
		ChangeTurnOrder changeCurrentTurnOrder = new ChangeTurnOrder(currentTurnOrder);
		try {
			notifyObserver(changeCurrentTurnOrder);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public int getMatch() {
		return match;
	}


}
