package Components;

import Effects.GainPrivilegeCouncil;
import it.polimi.ingsw.GC_40.Player;

public class MarketBuilding extends Market{
	private Piece bonus;
	private boolean isOccupied;
	private int cost;
	
	public Piece getBonus(){
		return bonus;
	}
	
	public boolean IsOccupied(){
		return isOccupied;
	}
	
	public int getCost(){
		return cost;
	}
	
	public void giveBonus(Player player, MarketBuilding market){
		if (market.equals(market1)){
			player.incrementCoin(5);
		}
		if (market.equals(market2)){
			player.incrementServant(5);
		}
		if(market.equals(market3)){
			player.incrementMilitaryPoint(3);
			player.incrementCoin(2);
		}
		if(market.equals(market4)){
			GainPrivilegeCouncil gainPrivilegeCouncil= new GainPrivilegeCouncil(2);
			gainPrivilegeCouncil.apply(player);
		}
		
	}
	public void setOccupied(){
		isOccupied=true;
	}
	public void setFree(){
		isOccupied= false;
	}
}

