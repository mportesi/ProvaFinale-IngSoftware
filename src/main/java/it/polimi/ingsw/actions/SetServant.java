package it.polimi.ingsw.actions;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.GC_40.Play;
import it.polimi.ingsw.GC_40.Player;
import it.polimi.ingsw.components.Relative;

public class SetServant implements Action {
	private int servant;
	private Player player;
	private Relative relative;
	
	public SetServant(int servant, Player player, Relative relative){
		this.servant=servant;
		this.player=player;
		this.relative=relative;
	}
	
	@Override
	public void apply(Play play)
			throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		for(Player p: play.getPlayers()){
			if(p.getName().equals(player.getName())){
				player.decrementServant(servant, play);
				player.getRelative(relative).setValueServant(servant);
			}
		}

	}

}
