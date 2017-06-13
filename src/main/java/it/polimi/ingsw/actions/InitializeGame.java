package it.polimi.ingsw.actions;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.GC_40.Play;

public class InitializeGame implements Action {
	

	@Override
	public void apply(Play play) throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		play.initializeBoard();
		//System.out.println("Sto facendo initializeGame.apply()");
		play.initializePlayer();
	}

}
