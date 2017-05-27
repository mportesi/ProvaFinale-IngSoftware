package Components;

import java.util.ArrayList;
import java.util.Arrays;

import it.polimi.ingsw.GC_40.Player;

public class CouncilPalace {
	private ArrayList<Player> order=new ArrayList<Player>();
	private int orderIndex=0;
	
	
	public void giveBonus(Piece r, Player player){
		player.incrementCoin(1);
		PrivilegeCouncil.giveBonus(r, player);
	}

	public ArrayList<Player> getOrder() {
		return order;
	}
	
	public void refresh(){
		order.clear();
		orderIndex=0;
	}
	
	public void addPlayer(Player player) {
		order.add(orderIndex, player);
		orderIndex+=1;
	}
	

}
