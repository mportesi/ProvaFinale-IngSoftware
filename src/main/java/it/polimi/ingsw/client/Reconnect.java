package it.polimi.ingsw.client;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.GC_40.Play;
import it.polimi.ingsw.GC_40.Player;
import it.polimi.ingsw.actions.Action;

public class Reconnect implements Action {
	
	private int match;
	private Player player;
	
	public Reconnect (Player player, int match){
		this.match = match;
		this.player = player;
	}
	
	@Override
	public void apply(Play play)
			throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		
		play.reconnect(player);
		player.setQuit(false);

	}

	@Override
	public int getMatch() {
		// TODO Auto-generated method stub
		return 0;
	}

}
