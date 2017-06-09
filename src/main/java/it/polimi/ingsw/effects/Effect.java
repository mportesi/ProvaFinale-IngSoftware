package it.polimi.ingsw.effects;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.GC_40.Player;

public abstract class Effect implements Serializable {
	
	public abstract void apply(Player player) throws FileNotFoundException, NullPointerException, IOException, ParseException;

	
}
