package it.polimi.ingsw.actions;

import it.polimi.ingsw.changes.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.GC_40.Observable;
import it.polimi.ingsw.GC_40.Play;

/**This class represents the generic action of type "putRelative", that is called when a player put its relative on an area on the board. 
 * 
 * @author Chiara
 * 
 *
 */
public abstract interface PutRelative extends Action {
	
	/**First, it will be check that the action is properly applicable. In particular, it has to be verified that the relative has enough value or that the area is free. 
	 * If that is not, the action cannot be applied and the player will be notified that the action is not available.
	 * 
	 * @author Chiara
	 * 
	 *
	 */
	
	public abstract boolean isApplicable() throws FileNotFoundException, IOException, ParseException;
	/**
	 * 
	 * This method executed the action chosen by the player. All the actions correspond to an area on the board.
	 * If the action is accepted, the relative of the player occupy the area and activate the effect associated to it, that usually consist in gain some resources.
	 * If the action is correct, all the observers will be notified, and the change arrives to the client that set the new changes.
	 * @author Chiara
	 *
	 */
	public abstract void apply(Play play) throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException;

}
