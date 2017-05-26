package Components;

import java.util.Arrays;

import it.polimi.ingsw.GC_40.Player;

public class CouncilPalace {
	private Player[] order;
	private int orderIndex=0;
	
	public void setOrder(){
		order= new Player[4];
	}
	public void giveBonus(Piece r, Player player){
		player.incrementCoin(1);
		PrivilegeCouncil.giveBonus(r, player);
	}

	public Player[] getOrder() {
		return order;
	}
	public void refresh(){
		Arrays.fill(order, 0);
		orderIndex=0;
	}
	
	public void addPlayer(Player player) {
		order[orderIndex]=player;
		orderIndex+=1;
	}
	

}
