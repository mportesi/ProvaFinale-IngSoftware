package Components;

import java.util.Arrays;

import it.polimi.ingsw.GC_40.Player;

public class CouncilPalace {
	private Player[] order;
	
	public void setOrder(){
		order= new Player[4];
	}
	public void giveBonus(String r, Player player){
		player.incrementCoin(1);
		PrivilegeCouncil.giveBonus(r, player);
	}

	public Player[] getOrder() {
		return order;
	}
	public void refresh(){
		Arrays.fill(order, 0);
	}
	

}
