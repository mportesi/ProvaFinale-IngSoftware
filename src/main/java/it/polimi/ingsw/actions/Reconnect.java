package it.polimi.ingsw.actions;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.GC_40.Play;
import it.polimi.ingsw.GC_40.Player;

/**This class represents the action made when a player decides to reconnect.
 * @author Chiara
 * 
 *
 */

public class Reconnect implements Action {
	
	private int match;
	private Player player;
	
	public Reconnect (Player player, int match){
		this.match = match;
		this.player = player;
	}
	
	/**The player will be added to the match.
	 * @author Chiara
	 * 
	 *
	 */
	
	@Override
	public void apply(Play play)
			throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		
		play.reconnect(player);
		player.setQuit(false);

	}

	@Override
	public int getMatch() {
		
		return match;
	}

}
