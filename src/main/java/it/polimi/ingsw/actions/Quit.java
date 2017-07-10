package it.polimi.ingsw.actions;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.GC_40.Play;
import it.polimi.ingsw.GC_40.Player;

/**This class represents the action made when a player decides to exit.
 * @author Chiara
 * 
 *
 */

public class Quit implements Action {
	private Player player;
	int match;
	
	public Quit (Player player, int match){
		this.player=player;
		this.match = match;
	}

	/**When a player click "exit", he/she will be added to the list of disconnected players.It will be removed from the match and from the currentTurn order, so that the other player can continue to play.
	 * The boolean attribute "quit" of the player will be set on "true".
	 * @author Chiara
	 * 
	 *
	 */
	
	@Override
	public void apply(Play play)
			throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		play.getDisconnectedPlayers().add(player);
		play.removePlayer(player);
		player.setQuit(true);
		

	}

	@Override
	public int getMatch() {
		// TODO Auto-generated method stub
		return match;
	}
	
	

}
