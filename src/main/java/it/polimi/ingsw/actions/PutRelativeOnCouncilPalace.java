 package it.polimi.ingsw.actions;

import it.polimi.ingsw.GC_40.Player;
import it.polimi.ingsw.changes.*;
import it.polimi.ingsw.GC_40.Observable;
import it.polimi.ingsw.areas.CouncilPalace;
import it.polimi.ingsw.components.Relative;

public class PutRelativeOnCouncilPalace extends Observable<Change> implements PutRelative {

	Relative relative;
	Player player;
	CouncilPalace councilPalace;
	
	
	public PutRelativeOnCouncilPalace(Player player, Relative relative){
		this.player=player;
		this.relative=relative;

	}
	
	

	@Override
	public boolean isApplicable() {
		// the required value is 1 to put a relative on the CouncilPalace
		if (relative.getValue() >= 1) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void apply() {
		if (isApplicable()) {
			// The player puts a relative on the councilPalace
			councilPalace.addPlayer(player);
			ChangeCouncilPalace changeCouncilPalace = new ChangeCouncilPalace(councilPalace);
			this.notifyObserver(changeCouncilPalace);
			// The player receive the bonus
			// TODO give player the council privilege bonus choice
			councilPalace.applyEffect(player);
		}

	}

}
