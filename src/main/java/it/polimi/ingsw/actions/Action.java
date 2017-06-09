package it.polimi.ingsw.actions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.GC_40.Observable;
import it.polimi.ingsw.GC_40.Play;
import it.polimi.ingsw.changes.Change;

public abstract interface Action extends Serializable {
	
	public abstract void apply(Play play) throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException;

}
