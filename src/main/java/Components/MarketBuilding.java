package Components;

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
	
	public void giveBonus(Player player){ //TODO finish method
		
	}
	public void setOccupied(){
		isOccupied=true;
	}
	public void setFree(){
		isOccupied= false;
	}
}
