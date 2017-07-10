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

/**
 * @author Chiara
 * This class represents the play and has all the methods to manage the game.
 *
 */

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
	
	
	public Play(int match) throws FileNotFoundException, NullPointerException, IOException, ParseException {
		this.players = new ArrayList<Player>();
		this.disconnectedPlayers = new ArrayList <Player>();
		changeRound=0;
		this.initializing = true;
	}

	/**
	 * @author Chiara
	 * This method initializes the board when the game starts and when the turn or the period changes.
	 * All the players will be notified that the board has changed.
	 */
	
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
	
	/**
	 * @author Chiara
	 * This method gives the starting coins to all players.
	 *
	 */

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

	/**
	 * @author Chiara
	 * This method initializes all the players with a color and the resources, and create a currentTurnOrder.
	 *
	 */
	
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

	/**
	 * @author Chiara
	 * This method changes the turn order.
	 *
	 */
	
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
		
		
	}

	/**
	 * @author Chiara
	 * This method changes the currentPlayer and invokes the change of the round.
	 *
	 */
	
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

	
	/**
	 * @author Chiara
	 * This method changes the round and the period.
	 *
	 */
	
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

	
	/**
	 * @author Chiara
	 * This method sorted all players in base of their military points.
	 *
	 */
	
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

	
	/**
	 * @author Chiara
	 * This method gives the final victory points to all the players.
	 *
	 */
	
	public void giveFinalPoint()
			throws FileNotFoundException, IOException, ParseException, NullPointerException, InterruptedException {
		JsonFinalVictoryPoint finalVictoryPoint = new JsonFinalVictoryPoint();
		finalVictoryPoint.importVictoryPoint();
		ArrayList<FinalVictoryPoint> list = finalVictoryPoint.getFinalVictoryPointList();

		for (Player p : players) {
			for (VentureCard v : p.getVenture()) {
				int victory = v.getVictory();
				p.incrementVictoryPoint(victory, this);
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

	/**
	 * @author Chiara
	 * This method ends the game.
	 *
	 */
	
	public void endGame() throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		ChangeEndGame changeEndGame= new ChangeEndGame(match);
		notifyObserver(changeEndGame);
	}

	/**
	 * @author Chiara
	 * This method checks who is the winner.
	 *
	 */
	
	public void checkWinner()
			throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
	
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
	
	/**
	 * @author Chiara
	 * This method create a new player.
	 *
	 */

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
			Thread.sleep((long) timeOutStartPlay *100);
			System.out.println("E' scaduto il timeout!");}
			initializePlay(match);
		}

	}

	/**
	 * @author Chiara
	 * This method initializes the play.
	 *
	 */
	
	private void initializePlay(int match)
			throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		this.initializing = false;
		initializePlayer(match);
		initializeBoard(match);
		ChangeTurnOrder changeTurnOrder = new ChangeTurnOrder (currentTurnOrder);
		this.notifyObserver(changeTurnOrder);
		
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

	/**
	 * @author Chiara
	 * This method manages the disconnection of a player.
	 *
	 */
	
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
	
		return disconnectedPlayers;
	}

	public ArrayList<Player> getCurrentTurnOrder() {
		
		return currentTurnOrder;
	}

	/**
	 * @author Chiara
	 * This method reconnects a player.
	 *
	 */
	
	public void reconnect(Player player) throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		players.add(player);
		disconnectedPlayers.remove(player);
		System.out.println(currentTurnOrder);
		ChangeTurnOrder changeCurrentTurnOrder = new ChangeTurnOrder(currentTurnOrder);
		try {
			notifyObserver(changeCurrentTurnOrder);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (NullPointerException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		
		
	}

	public int getMatch() {
		return match;
	}


}
