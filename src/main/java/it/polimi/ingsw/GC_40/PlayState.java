package it.polimi.ingsw.GC_40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import javax.swing.text.html.HTMLDocument.Iterator;

import it.polimi.ingsw.areas.CouncilPalace;
import it.polimi.ingsw.changes.Change;

public class PlayState extends Observable<Change> {
	private int period;
	private int round;
	private Player currentPlayer;
	private ArrayList<Player> currentTurnOrder;

	public PlayState(int period, int round, ArrayList<Player> currentTurnOrder) {
		this.period = period;
		this.round = round;
		this.currentTurnOrder = currentTurnOrder;
		currentPlayer = currentTurnOrder.get(0);
	}

	public void changeTurnOrder() {
		ChangeTurnOrder changeTurnOrder;

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
	}

	public void changePeriod() {
		period++;
		if (period == 4) {
			checkWinner(); // TODO define checkwinner
		}

	}

	public ArrayList<Player> checkWinner() {
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
		return winners;

	}
}
