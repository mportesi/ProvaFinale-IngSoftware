package it.polimi.ingsw.GC_40;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import it.polimi.ingsw.changes.Change;
import it.polimi.ingsw.changes.ChangeCoin;
import it.polimi.ingsw.changes.ChangePeriod;
import it.polimi.ingsw.changes.ChangePlayer;
import it.polimi.ingsw.changes.ChangeRound;
import it.polimi.ingsw.changes.ChangeServant;
import it.polimi.ingsw.changes.ChangeStone;
import it.polimi.ingsw.changes.ChangeTurnOrder;
import it.polimi.ingsw.changes.ChangeWinners;
import it.polimi.ingsw.changes.ChangeWood;
import it.polimi.ingsw.colors.ColorPlayer;

public class Play extends Observable<Change>
{
	private static ArrayList<Player> players;
	private Player currentPlayer;
	private Board board;
	private int period;
	private int round;
	private ArrayList<Player> currentTurnOrder;
	
	public Play(){
		this.board=new Board();
		this.players=new ArrayList<Player>();
		this.round=0;
		this.period=0;
	}
	
	public void initializeGame(ArrayList<Player> players){
		this.players=players;
		ArrayList<Player> currentTurnOrder=createTurnOrder(players);
		initializePlayer(currentTurnOrder);
		this.currentPlayer = currentTurnOrder.get(0);
		changePeriod();
		changeRound();
	}
	
	public void giveStartingCoin(ArrayList<Player> currentTurnOrder){
		int coin=5;
		for(Player p:currentTurnOrder){
			p.incrementCoin(coin);
			coin++;
			ChangeCoin changeCoin= new ChangeCoin(p.getColor(), p.getCoin());
			this.notifyObserver(changeCoin);
		}
		
		
	}
	
	public void initializePlayer(ArrayList<Player> currentTurnOrder){
		int i=0;
		for(Player p:currentTurnOrder){
			p.setCoin(0);
			p.setWood(2);
			ChangeWood changeWood= new ChangeWood(p.getColor(), p.getWood());
			this.notifyObserver(changeWood);
			p.setServant(3);
			ChangeServant changeServant= new ChangeServant(p.getColor(), p.getServant());
			this.notifyObserver(changeServant);
			p.setStone(2);
			ChangeStone changeStone= new ChangeStone(p.getColor(), p.getStone());
			this.notifyObserver(changeStone);
			p.setMilitaryPoint(0);
			p.setVictorypoint(0);
			p.setFaithPoint(0);
			i++;
		}
		
		giveStartingCoin(currentTurnOrder);
		
	}
	
	public static ArrayList<Player> createTurnOrder(ArrayList<Player> players) {
		Collections.shuffle(players);
		ChangeTurnOrder changeTurnOrder= new ChangeTurnOrder(players);
		return players;
	}
	
	public void changeTurnOrder() {

		ArrayList<Player> nextTurnOrder = new ArrayList<Player>();
		ArrayList<Player> councilPalaceOrder = Board.councilPalace.getOrder();

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
		
		ChangeTurnOrder changeTurnOrder= new ChangeTurnOrder(currentTurnOrder);
		
		this.notifyObserver(changeTurnOrder);
	}

	public void changeCurrentPlayer() {
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
		
		ChangePlayer changePlayer= new ChangePlayer(currentPlayer);
		
		this.notifyObserver(changePlayer);

		if (n == 4) {
			changeRound();
		}
	}

	public void changeRound() {
		if (round == 2 || round == 4 || round == 6) {
			if(period==3){
				changePeriod();
				return;
			}
			else changePeriod();
			
		}
		round += 1;
		changeTurnOrder();

		// refresh tower( place new card and remove family member)
		Board.territoryTower.refreshTower(period);
		Board.buildingTower.refreshTower(period);
		Board.characterTower.refreshTower(period);
		Board.ventureTower.refreshTower(period);

		// refresh harvest and production area
		Board.harvestArea.refresh();
		Board.productionArea.refresh();
		// refresh market
		Board.market1.setFree();
		Board.market2.setFree();
		Board.market3.setFree();
		Board.market4.setFree();

		// refresh council palace
		Board.councilPalace.refresh();

		// roll dice
		Board.blackDice.setValue();
		Board.orangeDice.setValue();
		Board.whiteDice.setValue();
		
		ChangeRound changeRound= new ChangeRound(round);
		this.notifyObserver(changeRound);
	}

	public void changePeriod() {
		period++;
		
		if (period == 4) {
			checkWinner(); // TODO define checkwinner
		}
		else {
			ChangePeriod changePeriod= new ChangePeriod(period);
		}
		

	}
	
	public void giveFinalPoint(){
		//assegna i punti a ciascun player
	}
	
	public void endGame(){
		//restituisce la classifica e il vincitore
	}

	public void checkWinner() {
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
		ChangeWinners changeWinners= new ChangeWinners(winners);
		this.notifyObserver(changeWinners);

	}
	
	
	
	
	

}
