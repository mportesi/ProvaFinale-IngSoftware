package it.polimi.ingsw.actions;

import java.io.FileNotFoundException;

import java.io.IOException;
import java.io.Serializable;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.GC_40.Observable;
import it.polimi.ingsw.GC_40.Play;
import it.polimi.ingsw.changes.Change;

/**This class represents the generic action. All action will inherited its methods.
 * 
 * @author Chiara
 * 
 *
 */

public abstract interface Action extends Serializable {
	
	/**
	 * This is the generic method to apply the actions. The controller associated to the right match will apply it with the method update() once it will be notified of it.
	 * @author Chiara
	 *
	 */
	
	public abstract void apply(Play play) throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException;

	
	/**This method return the match to which the action is associated, so that it will be applied only on the right match.
	 * 
	 * @author Chiara
	 * 
	 *
	 */
	public abstract int getMatch();

	

}
