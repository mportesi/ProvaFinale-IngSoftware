package it.polimi.ingsw.changes;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.GC_40.Play;
import it.polimi.ingsw.client.ClientModel;

public abstract interface Change extends Serializable {
	
	public abstract void applyChange(ClientModel client) throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException;

}
