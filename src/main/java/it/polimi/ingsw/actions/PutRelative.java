package it.polimi.ingsw.actions;

import it.polimi.ingsw.changes.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.GC_40.Observable;
import it.polimi.ingsw.GC_40.Play;

public abstract interface PutRelative extends Action {
	
	public abstract boolean isApplicable() throws FileNotFoundException, IOException, ParseException;
	
	public abstract void apply(Play play) throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException;
	
	public abstract Play getPlay();

}
