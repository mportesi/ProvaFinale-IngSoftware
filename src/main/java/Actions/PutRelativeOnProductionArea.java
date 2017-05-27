package Actions;
import Components.Relative;
import Components.HarvestAndProductionArea;
import Effects.GainProductionValue;
import it.polimi.ingsw.GC_40.Player;
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
				GainProductionValue gainProductionValue=new GainProductionValue(1); //??
				gainProductionValue.apply(player);
			}
			else{
				productionArea.setRightPlayer(player);
				GainProductionValue gainProductionValue=new GainProductionValue(-3);
				gainProductionValue.apply(player);
			}
		}

	}

}
