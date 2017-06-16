package it.polimi.ingsw.changes;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.GC_40.Player;
import it.polimi.ingsw.client.ClientModel;
import it.polimi.ingsw.components.Relative;

public class ChangeGiveBackServants implements Change {
	private Player player;
	private Relative relative;
	private int servants;
	
	public ChangeGiveBackServants(Player player, Relative relative, int servants){
		this.player=player;
		this.relative=relative;
		this.servants=servants;
	}

	@Override
	public void applyChange(ClientModel client)
			throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		if (client.getName().equals(player.getName())){
			client.getPlayer().getRelative(relative).setValueServant(servants);
		}

	}

}
