package it.polimi.ingsw.actions;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.GC_40.Play;
import it.polimi.ingsw.GC_40.Player;

public class ReconnectExit implements Action {
	private int match;
	private String name;
	
	
	public ReconnectExit (int match, String name){
		this.match = match;
		this.name =name;
	}
	
	@Override
	public void apply(Play play)
			throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		
		//play.reconnect(player);
		//player.setQuit(false);

	}

	@Override
	public int getMatch() {
		// TODO Auto-generated method stub
		return 0;
	}

}
