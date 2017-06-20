package it.polimi.ingsw.changes;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.client.ClientModel;

public class ChangeEndGame implements Change {

	@Override
	public void applyChange(ClientModel client)
			throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		client.setEndGame();
		System.out.println("The game is finished! Bye bye");
		

	}

}
