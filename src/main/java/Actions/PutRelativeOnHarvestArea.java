package Actions;
import Components.Relative;
import Components.HarvestAndProductionArea;
import Effects.GainHarvestValue;
import Effects.GainProductionValue;

public class PutRelativeOnMarket extends PutRelative {

	Relative relative;
	HarvestAndProductionArea harvestArea;
	Player player;
	
	@Override
	public boolean isApplicable() {
		if(relative.getValue()>=harvestArea.getCost()){
		return true;}
		else{ return false;} 
	}

	@Override
	public void apply() {
		if(isApplicable()){
			if(harvestArea.getLeftPlayer()==null){
				harvestArea.setLeftPlayer(player);
				GainProductionValue.apply();
			}
			else{
				harvestArea.setRightPlayer(player);
				GainProductionValue.apply();
			}
		}
	}

}
