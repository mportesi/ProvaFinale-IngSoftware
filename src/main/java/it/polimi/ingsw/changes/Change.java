package it.polimi.ingsw.changes;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.GC_40.Play;
import it.polimi.ingsw.client.ClientModel;
/**
 * @author Sara
 * This interface is necessary to notify the changes that happens on the server to the client.
 * It is applied by the view of the client that is an observer of the changes of the server view.
 * The model notify the server view that there are some changes and the server view update the client view that do the apply.
 */
public abstract interface Change extends Serializable {
	
	public abstract void applyChange(ClientModel client) throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException;

}
