package it.polimi.ingsw.actions;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.GC_40.Observable;
import it.polimi.ingsw.GC_40.Play;
import it.polimi.ingsw.changes.Change;

public class InitializeGame extends Observable<Change> implements Action {
	private int match;
	
	public InitializeGame(int match){
		this.match = match;
	}

	@Override
	public void apply(Play play) throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		play.initializePlayer();
		play.initializeBoard();
		
	}

	public int getMatch() {
		return match;
	}

	

}
