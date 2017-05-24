package Components;

import it.polimi.ingsw.GC_40.Player;
import java.util.ArrayList;
import java.util.List;
public class HarvestAndProductionArea {
	private Player leftPlayer;
	private List<Player> rightPlayer= new ArrayList<Player>();
	private int cost;
	private int penalty;
	private int type;
	
	public Player getLeftPlayer() {
		return leftPlayer;
	}
	public List<Player> getRightPlayer() {
		return rightPlayer;
	}
	public void setLeftPlayer(Player player){
		leftPlayer= player;
	}
	public void setRightPlayer(Player player){
		rightPlayer.add(player); 
	}
	public int getCost() {
		return cost;
	}
	public int getPenalty() {
		return penalty;
	}
	public int getType() {
		return type;
	}
	public void refresh() {
		leftPlayer= null;
		rightPlayer.clear();
	}

}
