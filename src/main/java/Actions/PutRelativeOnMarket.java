package Actions;
import Components.Relative;
import Components.MarketBuilding;

public class PutRelativeOnMarket extends PutRelative {

	Relative relative;
	MarketBuilding market;
	Player player;
	
	@Override
	public boolean isApplicable() {
		if(market.IsOccupied()){
			return false;
		}
		else if(relative.getValue() >= market.getCost()){
			return true;
		}
	}

	@Override
	public void apply() {
		if(isApplicable()){
			market.setOccupied();
			market.giveBonus(player);
		}
	}

}
