package it.polimi.ingsw.actions;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.GC_40.Play;

/**This class represents the action made when the currentPlayer has to change.
 * @author Chiara
 * 
 *
 */

public class ShiftPlayer implements Action {
	private int match;
	
	public ShiftPlayer(int match){
		this.match = match;
	}
	
	/**The next player in the currentTurnOrder will be chosen as the new currentPlayer.
	 * @author Chiara
	 * 
	 *
	 */
	
	@Override
	public void apply(Play play)
			throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		play.changeCurrentPlayer();
	}

	public int getMatch() {
		return match;
	}



}
