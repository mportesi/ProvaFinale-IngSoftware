package it.polimi.ingsw.changes;

import it.polimi.ingsw.GC_40.Play;
import it.polimi.ingsw.client.ClientModel;

public abstract interface Change {
	
	public abstract void applyChange(ClientModel client);

}
