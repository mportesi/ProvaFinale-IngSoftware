package Actions;
import Components.Relative;
import Components.HarvestAndProductionArea;
import Effects.GainProductionValue;
public class PutRelativeOnProductionArea extends PutRelative {
	Relative relative;
	HarvestAndProductionArea productionArea;
	Player player;
	
	@Override
	public boolean isApplicable() {
		if(relative.getValue()>=productionArea.getCost()){
		return true;}
		else{ return false;} 
	}

	@Override
	public void apply() {
		if(isApplicable()){
			if(productionArea.getLeftPlayer()==null){
				productionArea.setLeftPlayer(player);
				GainProductionValue.apply();
			}
			else{
				productionArea.setRightPlayer(player);
				GainProductionValue.apply();
			}
		}

	}

}
