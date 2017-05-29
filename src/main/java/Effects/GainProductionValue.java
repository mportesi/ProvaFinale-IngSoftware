package Effects;

import it.polimi.ingsw.GC_40.Player;

public class GainProductionValue extends Effect {
	int productionValue;

	
	public GainProductionValue(int productionValue){
		this.productionValue=productionValue;
	}

	@Override
	public void apply(Player player) {
		// TODO Auto-generated method stub
	player.personalBonusTile.applyProductionEffect(player);	

	}

}
