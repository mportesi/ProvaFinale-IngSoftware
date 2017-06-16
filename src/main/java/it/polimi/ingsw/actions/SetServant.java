package it.polimi.ingsw.actions;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.GC_40.Play;
import it.polimi.ingsw.GC_40.Player;

public class SetServant implements Action {
	private int servant;
	private Player player;
	
	public SetServant(int servant, Player player){
		this.servant=servant;
		this.player=player;
	}
	
	@Override
	public void apply(Play play)
			throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		for(Player p: play.getPlayers()){
			if(p.getName().equals(player.getName())){
				player.decrementServant(servant, play);
			}
		}

	}

}
