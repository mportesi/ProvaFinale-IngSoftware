package Actions;
import Components.Relative;
import Components.HarvestAndProductionArea;
import Effects.GainHarvestValue;
import Effects.GainProductionValue;
import it.polimi.ingsw.GC_40.Player;

public class PutRelativeOnHarvestArea extends PutRelative {

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
				GainHarvestValue gainHarvestValue= new GainHarvestValue(1); //???
				gainHarvestValue.apply(player);
			}
			else{
				harvestArea.setRightPlayer(player);
				GainHarvestValue gainHarvestValue= new GainHarvestValue(-3); //???
				gainHarvestValue.apply(player);
			}
		}
	}

}
