package it.polimi.ingsw.changes;

import java.io.Serializable;

import it.polimi.ingsw.GC_40.Play;
import it.polimi.ingsw.client.ClientModel;

public abstract interface Change extends Serializable {
	
	public abstract void applyChange(ClientModel client);

}
