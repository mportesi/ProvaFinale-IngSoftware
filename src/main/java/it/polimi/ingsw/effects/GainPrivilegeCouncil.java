package it.polimi.ingsw.effects;

import it.polimi.ingsw.GC_40.Player;
import it.polimi.ingsw.components.PrivilegeCouncil;

public class GainPrivilegeCouncil extends Effect {
	int privilegeCouncil;
	String resource;
	
	public GainPrivilegeCouncil(int privilegeCouncil, String resource){
		this.privilegeCouncil=privilegeCouncil;
		this.resource = resource;
	}

	@Override
	public void apply(Player player) {
		// Resource resource = chooseResource();
		PrivilegeCouncil.applyEffect(player, resource);
		
	//metto uno switch e incremento a seconda del case

	}

	public void apply(Player player, String resource) {
		// TODO Auto-generated method stub
		
	}


}
