package it.polimi.ingsw.actions;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.GC_40.Play;
import it.polimi.ingsw.GC_40.Player;

public class Quit implements Action {
	private Player player;
	int match;
	
	public Quit (Player player, int match){
		this.player=player;
		this.match = match;
	}

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
