package it.polimi.ingsw.components;

import java.util.ArrayList;
import java.util.Arrays;

import it.polimi.ingsw.GC_40.Player;

public class CouncilPalace {
	private ArrayList<Player> order = new ArrayList<Player>();
	private int orderIndex = 0;

	// to give the bonus when a player put a relative and choose a piece
	public void giveBonus(Piece r, Player player) {
		player.incrementCoin(1);
		PrivilegeCouncil.giveBonus(r, player);
	}

	public ArrayList<Player> getOrder() {
		return order;
	}

	// to empty the council palace at the end of the round
	public void refresh() {
		order.clear();
		orderIndex = 0;
	}

	// to add a player on the council palace
	public void addPlayer(Player player) {
		order.add(orderIndex, player);
		orderIndex += 1;
	}

}
