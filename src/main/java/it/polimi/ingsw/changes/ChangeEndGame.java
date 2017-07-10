package it.polimi.ingsw.changes;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.client.ClientModel;
/**
 * @author Sara
 * To set the end of the game on the client.
 */
public class ChangeEndGame implements Change {
	private int match;
	
	public ChangeEndGame(int match){
		this.match=match;
	}

	@Override
	public void applyChange(ClientModel client)
			throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		if(client.getPlayer().getMatch()==match){
		client.setEndGame();
		System.out.println("The game is finished! Wait for the rank ");
		}

	}

}
