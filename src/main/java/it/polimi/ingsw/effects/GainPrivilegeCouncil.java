package it.polimi.ingsw.effects;

import it.polimi.ingsw.GC_40.Player;
import it.polimi.ingsw.components.PrivilegeCouncil;

public class GainPrivilegeCouncil extends Effect {
	int privilegeCouncil;
	
	public GainPrivilegeCouncil(int privilegeCouncil){
		this.privilegeCouncil=privilegeCouncil;
		
	}

	@Override
	public void apply(Player player) {
		String resource; // =controller chooseResource(se privilegeCouncil>1 sceglie due cose diverse);
		PrivilegeCouncil.applyEffect(player, resource);
		
	
		
		

	}


}
