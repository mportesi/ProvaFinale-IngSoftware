package it.polimi.ingsw.areas;

import java.util.ArrayList;
import java.util.Arrays;

import it.polimi.ingsw.GC_40.Player;
import it.polimi.ingsw.components.Piece;
import it.polimi.ingsw.components.PrivilegeCouncil;

public class CouncilPalace {
	int bonusPrivilegeCouncil;
	int bonusCoin;
	int cost;
	
	private ArrayList<Player> order = new ArrayList<Player>();
	private int orderIndex = 0;

	
	public CouncilPalace(int bonusPrivilegeCouncil, int bonusCoin, int cost){
		this.bonusPrivilegeCouncil = bonusPrivilegeCouncil;
		this.bonusCoin = bonusCoin;
		this.cost = cost;
	}
	
	
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
