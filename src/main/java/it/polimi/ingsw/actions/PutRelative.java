package it.polimi.ingsw.actions;

import it.polimi.ingsw.changes.*;
import it.polimi.ingsw.GC_40.Observable;

public interface PutRelative {
	
	public abstract boolean isApplicable();
	
	public abstract void apply();

}
