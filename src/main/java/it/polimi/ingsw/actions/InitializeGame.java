package it.polimi.ingsw.actions;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.GC_40.Observable;
import it.polimi.ingsw.GC_40.Play;
import it.polimi.ingsw.changes.Change;

public class InitializeGame extends Observable<Change> implements Action {
	

	@Override
	public void apply(Play play) throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		
		System.out.println("Sto facendo initializeGame.apply()");
		play.initializePlayer();
		play.initializeBoard();
		
	}

}
