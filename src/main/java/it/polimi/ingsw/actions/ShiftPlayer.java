package it.polimi.ingsw.actions;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.GC_40.Play;

public class ShiftPlayer implements Action {
	
	private int match;
	
	public ShiftPlayer (int match){
		this.match = match;
	}
	@Override
	public void apply(Play play)
			throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		play.changeCurrentPlayer();

	}
	@Override
	public int getPlay() {
		// TODO Auto-generated method stub
		return match;
	}

}
