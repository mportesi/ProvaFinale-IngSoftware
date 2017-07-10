package it.polimi.ingsw.actions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.UUID;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.GC_40.Observable;
import it.polimi.ingsw.GC_40.Play;
import it.polimi.ingsw.GC_40.Player;
import it.polimi.ingsw.changes.Change;
import it.polimi.ingsw.changes.ChangeNewPlayer;

/**This class represents the action made at the beginning of the game, when a player gives his/her name to sign up to a match.
 * 
 * @author Chiara
 * 
 *
 */

public class RegisterClient extends Observable<Change> implements Action {
	private String name;
	private int match;
	
	public RegisterClient(String name, int match){
		this.name=name;
		this.match = match;
	}
	
	
	/**The new player will be registered with his/her name, and will attend that there are enough players to start a match.
	 * 
	 * 
	 * @author Chiara
	 * 
	 *
	 */
	@Override
	public void apply(Play play) throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		play.createNewPlayer(name, match);
		
	}

	@Override
	public int getMatch() {
		// TODO Auto-generated method stub
		return match;
	}

}
