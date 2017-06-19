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
	private Dice blackDice;
	private Dice whiteDice;
	private Dice orangeDice;
	private Player currentPlayer;
	private Board board;
	private int period;
	private int round;
	private ArrayList<Player> currentTurnOrder;
	private int changeRound;

	// costruttore
	public Play() throws FileNotFoundException, NullPointerException, IOException, ParseException {
		this.players = new ArrayList<Player>();
		changeRound=0;
	}

	public void initializeBoard()
			throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		this.board = new Board(this, players.size());
		board.registerObserver(this);
		
		this.round = 6;
		this.period = 3;
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

	public void initializePlayer()
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

	public void changeCurrentPlayer()
			throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		int i = 0;

		while (currentTurnOrder.get(i) != currentPlayer && i<currentTurnOrder.size()-1) {
			i++;
		}
		if (i == (currentTurnOrder.size() - 1)) {
			currentPlayer = currentTurnOrder.get(0);
			changeRound++;
		} else {
			currentPlayer = currentTurnOrder.get(i + 1);
		}
		System.out.println(changeRound);
		ChangePlayer changePlayer = new ChangePlayer(currentPlayer);

		this.notifyObserver(changePlayer);

		if (changeRound == 4) {
			changeRound();
			changeRound = 0;
		}
	}

	public void changeRound()
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
		ChangeRound changeRound = new ChangeRound(round, board);
		this.notifyObserver(changeRound);
		
		if (round-1 == 2 || round-1 == 4 || round-1 == 6) {
			if (period == 3) {
				changePeriod();
				return;
			} else
				changePeriod();
			}
		
	}

	public void changePeriod()
			throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		period++;
		System.out.println("il periodo è : " + period );

		if (period == 4) {
			checkWinner();
		} else {
			
			ChangePeriod changePeriod = new ChangePeriod(period);
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

	public void endGame() {
		ChangeEndGame changeEndGame= new ChangeEndGame();
		// restituisce la classifica e il vincitore
	}

	public void checkWinner()
			throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		System.out.println("Sono nel checkWinner()");
		ArrayList<Player> winners = new ArrayList<Player>();
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
	public void update(Change c)
			throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		this.notifyObserver(c);
	}

	public void createNewPlayer(String name)
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
			Player player = new Player(UUID.randomUUID(), this, name);
			players.add(player);
			player.setPersonalBonusTile(personalBonusTileSimple, personalBonusTileAdvanced);
			player.registerObserver(this);
			notifyObserver(new ChangeNewPlayer(player, this));

			if (players.size() == 2) {
				Thread.sleep((long) timeOutStartPlay );
				System.out.println("E' scaduto il timeout!");
				initializePlay();
			}
		} else if (players.size() == 4) {
			this.players = new ArrayList<Player>();
		
			if (players.size() < 4) {
				Player player = new Player(UUID.randomUUID(), this, name);
				players.add(player);
				player.registerObserver(this);
				notifyObserver(new ChangeNewPlayer(player, this));

				if (players.size() == 2) {
					Thread.sleep((long) timeOutStartPlay * 1000);
					System.out.println("E' scaduto il timeout");
					initializePlay();
				}
			}
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

	private void initializePlay()
			throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		initializePlayer();
		initializeBoard();
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

	public void removePlayer(Player player) {
		Player playerToRemove=null;
		for(int i=0; i<players.size(); i++){
			if (players.get(i).getID().equals(player.getID())){
				playerToRemove=players.get(i);
			}
		}
		players.remove(playerToRemove);
		board.remove(player);
		if(players.size()==1){
			endGame();
		}
		try {
			notifyObserver(new ChangeNumberOfPlayers(players.size(), player, board));
		} catch (NullPointerException | IOException | ParseException | InterruptedException e) {
			e.printStackTrace();
		}
		
	}


}
