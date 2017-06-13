package it.polimi.ingsw.GC_40;

import java.io.FileNotFoundException;
import java.io.IOException;
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
import it.polimi.ingsw.changes.Change;
import it.polimi.ingsw.changes.ChangeCoin;
import it.polimi.ingsw.changes.ChangeColor;
import it.polimi.ingsw.changes.ChangeCouncilPalace;
import it.polimi.ingsw.changes.ChangeInitializeBoard;
import it.polimi.ingsw.changes.ChangeInitializePlay;
import it.polimi.ingsw.changes.ChangeNewPlayer;
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
import it.polimi.ingsw.effects.GainVictoryPointForTerritoryCard;

public class Play extends Observable<Change> implements Observer<Change> {
	private ArrayList<Player> players;
	private Dice blackDice;
	private Dice whiteDice;
	private Dice orangeDice;
	private Player currentPlayer;
	private Board board;
	private int period;
	private int round;
	private ArrayList<Player> currentTurnOrder;

	// costruttore
	public Play() throws FileNotFoundException, NullPointerException, IOException, ParseException {
		this.players = new ArrayList<Player>();
		/*
		 * this.board=new Board(); this.players=new ArrayList<Player>();
		 * this.round=0; this.period=0;
		 */
	}

	public void initializeBoard()
			throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		// this.players = new ArrayList<Player>();
		this.board = new Board(this);
		// System.out.println("ho inizializzato la board");
		this.round = 0;
		this.period = 0;
		changePeriod();
		// System.out.println("ho fatto change period");
		changeRound();
		System.out.println(board);
		// ChangePlayer changePlayer= new ChangePlayer(this.currentPlayer);
		// this.notifyObserver(changePlayer);
		ChangeInitializeBoard changeInitializeBoard = new ChangeInitializeBoard(board, currentPlayer);
		this.notifyObserver(changeInitializeBoard);

	}

	public void giveStartingCoin(ArrayList<Player> currentTurnOrder)
			throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		int coin = 5;
		for (Player p : currentTurnOrder) {
			p.incrementCoin(coin);

			ChangeCoin changeCoin = new ChangeCoin(p, p.getCoin());
			this.notifyObserver(changeCoin);
			coin++;
		}

	}

	public void initializePlayer(ArrayList<Player> currentTurnOrder)
			throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		currentTurnOrder = createTurnOrder(players);
		this.currentPlayer = currentTurnOrder.get(0);
		ColorPlayer[] colors = ColorPlayer.values();
		System.out.println("Giocatore 1: " + currentTurnOrder.get(0));
		System.out.println("Giocatore 2: " + currentTurnOrder.get(1));
		for (int i = 0; i < currentTurnOrder.size(); i++) {
			System.out.println(currentTurnOrder.get(i));
			currentTurnOrder.get(i).setColor(colors[i]);
			System.out.println(currentTurnOrder.get(i).getColor());
			ChangeColor changeColor = new ChangeColor(currentTurnOrder.get(i), colors[i]);
			this.notifyObserver(changeColor);
		}
		for (Player p : currentTurnOrder) {
			p.setCoin(0);
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

		for (Player checkedPlayer : councilPalaceOrder) {
			nextTurnOrder.add(checkedPlayer);

			for (Player nowPlayer : currentTurnOrder) {
				if (nowPlayer.equals(checkedPlayer)) {
					currentTurnOrder.remove(nowPlayer);
				}

			}

		}

		for (Player p : currentTurnOrder) {
			nextTurnOrder.add(p);
			currentTurnOrder.remove(p);
		}

		currentTurnOrder.addAll(nextTurnOrder);
		nextTurnOrder.clear();

		ChangeTurnOrder changeTurnOrder = new ChangeTurnOrder(currentTurnOrder);

		this.notifyObserver(changeTurnOrder);
	}

	public void changeCurrentPlayer()
			throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		int i = 0;
		int n = 0;

		while (currentTurnOrder.get(i) != currentPlayer) {
			i++;
		}
		if (i == (currentTurnOrder.size() - 1)) {
			currentPlayer = currentTurnOrder.get(0);
			n++;
		} else {
			currentPlayer = currentTurnOrder.get(i + 1);
		}

		ChangePlayer changePlayer = new ChangePlayer(currentPlayer);

		this.notifyObserver(changePlayer);

		if (n == 4) {
			changeRound();
		}
	}

	public void changeRound()
			throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		if (round == 2 || round == 4 || round == 6) {
			if (period == 3) {
				changePeriod();
				return;
			} else
				changePeriod();

		}
		if (round != 0) {
			changeTurnOrder();
		}
		round += 1;

		System.out.println(board);

		// refresh tower( place new card and remove family member)
		board.getTerritoryTower().refreshTower(period);
		board.getBuildingTower().refreshTower(period);
		board.getCharacterTower().refreshTower(period);
		board.getVentureTower().refreshTower(period);
		// System.out.println(board);
		// refresh harvest and production area

		board.getHarvestArea().refresh();
		// System.out.println("HarvestArea: "+ board.getHarvestArea());
		board.getProductionArea().refresh();
		// System.out.println("ProductionArea: "+ board.getProductionArea());
		// refresh market
		board.getMarket(0).setFree();
		// System.out.println("Market1 " + board.getMarket(0));
		board.getMarket(1).setFree();
		// System.out.println("Market2 " + board.getMarket(1));
		board.getMarket(2).setFree();
		// System.out.println("Market3 " + board.getMarket(2));
		board.getMarket(3).setFree();
		// System.out.println("Market4 " + board.getMarket(3));

		// refresh council palace
		board.getCouncilPalace().refresh();

		System.out.println("roll dice");
		board.getBlackDice().setValue();
		board.getOrangeDice().setValue();
		board.getWhiteDice().setValue();

		System.out.println("ho settato il valore dei dadi");
		for (Player p : players) {
			p.getBlackRelative().setValue(board.getBlackDice().getValue());
			System.out.println("Il valore del black è" + p.getBlackRelative().getValue());
			p.getWhiteRelative().setValue(board.getWhiteDice().getValue());
			System.out.println("Il valore del white è" + p.getWhiteRelative().getValue());
			p.getOrangeRelative().setValue(board.getOrangeDice().getValue());
			System.out.println("Il valore del orange è" + p.getOrangeRelative().getValue());

		}

		ChangeRound changeRound = new ChangeRound(round, players);
		this.notifyObserver(changeRound);
	}

	public void changePeriod()
			throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		period++;

		if (period == 4) {
			checkWinner(); // TODO define checkwinner
		} else {
			ChangePeriod changePeriod = new ChangePeriod(period);
		}

	}

	/*
	 * public Map <int, Player> militaryPointForPlayer(){ LinkedHashMap <int,
	 * Player> pointForPlayer = null; for (Player p : players){
	 * pointForPlayer.put(p.getMilitaryPoint(), p); } return pointForPlayer; }
	 * 
	 * public List <Player> militaryPointRank(){ Map
	 * pointForPlayer=militaryPointForPlayer(); int max=0; ArrayList<Player>
	 * players; List <Player> keys; for(Player p: pointForPlayer.keySet()){
	 * keys.add(p); if(pointForPlayer.get(p)>=max){ max=pointForPlayer.get(p);
	 * players.add(p); } }
	 * 
	 * }
	 * 
	 * 
	 * 
	 * 
	 * public void giveFinalPoint(){
	 * 
	 * int victoryPointForMilitaryFirst = JSon.victoryPointForTheFirst; int
	 * victoryPointForMilitarySecond = JSon.victoryPointForTheSecond; for
	 * (Player p : players){ if (p == militaryPointRank().get(0)){
	 * p.incrementVictoryPoint(victoryPointForMilitaryFirst); } if (p ==
	 * militaryPointRank().get(1)){
	 * p.incrementVictoryPoint(victoryPointForMilitarySecond); }
	 * 
	 * for (FinalVictoryPoint f : JSon.finalVictoryPointArray){ String type =
	 * f.getType(); switch (type){ case "victoryPointForTerritory" : { Set list
	 * = JSon.finalVictoryPointGain.keySet(); Iterator iter = list.iterator();
	 * 
	 * while(iter.hasNext()) { int key = (int)(iter.next()); int value =
	 * (int)(JSon.finalVictoryPointGain.get(key)); int numberOfTerritoryCard =
	 * p.counter("territoryCard"); if (numberOfTerritoryCard >= key){
	 * p.incrementVictoryPoint(value); break; }}} case
	 * "victoryPointForCharacter" : { Set list =
	 * JSon.finalVictoryPointGain.keySet(); Iterator iter = list.iterator();
	 * 
	 * while(iter.hasNext()) { int key = (int)(iter.next()); int value =
	 * (int)(JSon.finalVictoryPointGain.get(key)); int numberOfTerritoryCard =
	 * p.counter("characterCard"); if (numberOfTerritoryCard >= key){
	 * p.incrementVictoryPoint(value); break; }}}
	 * 
	 * case "victoryPointForResource" : { Set list =
	 * JSon.finalVictoryPointGain.keySet(); Iterator iter = list.iterator();
	 * 
	 * while(iter.hasNext()) { int key = (int)(iter.next()); int value =
	 * (int)(JSon.finalVictoryPointGain.get(key)); int numberOfResource =
	 * p.resourceCounter(); p.incrementVictoryPoint(numberOfResource/5); break;
	 * }}
	 * 
	 * } }}
	 * 
	 * 
	 * 
	 * }
	 */

	public void endGame() {
		// restituisce la classifica e il vincitore
	}

	public void checkWinner()
			throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		ArrayList<Player> winners = new ArrayList<>();
		int max = 0;
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
	public void update() {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Change c)
			throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		System.out.println("ho ricevuto il cambiamento");
		this.notifyObserver(c);
	}

	public void createNewPlayer(String name)
			throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		if (players == null) {
			this.players = new ArrayList<Player>();
		}
		Player player = new Player(UUID.randomUUID(), this, name);
		players.add(player);
		notifyObserver(new ChangeNewPlayer(player));

		if (players.size() >= 2) {
			verifyNumberOfPlayer();
			return;
		}

	}

	public void verifyNumberOfPlayer()
			throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		if (players.size() >= 2 && players.size() < 4) {

			Timer timer = new Timer();
			timer.schedule(new TimerTask() {

				@Override
				public void run() {

					System.out.println("sono entrato nel run");
					try {
						initializePlay();

					} catch (NullPointerException | IOException | ParseException e) {

					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}

			}, 10 * 1000);// TODO IMPORTARE DA JSON

		}

		else if (players.size() == 4) {

			initializePlay();
			return;

		}
			  }

	}

	public void initializePlay()
			throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		initializePlayer(players);
		ChangeInitializePlay changeInitializePlay = new ChangeInitializePlay(players.size());
		this.notifyObserver(changeInitializePlay);
	}

	public Board getBoard() {
		return board;
	}

}
