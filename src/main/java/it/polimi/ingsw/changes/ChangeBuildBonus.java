package it.polimi.ingsw.changes;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.GC_40.Observable;
import it.polimi.ingsw.GC_40.Play;
import it.polimi.ingsw.GC_40.Player;
import it.polimi.ingsw.client.ClientModel;
import it.polimi.ingsw.colors.ColorPlayer;

public class ChangeBuildBonus implements Change {
	
	private int buildBonus;
	private Player player;
	
	public ChangeBuildBonus(Player player, int buildBonus){
		this.player=player;
		this.buildBonus=buildBonus;
	}

	@Override
	public void applyChange(ClientModel client)
			throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		if (client.getName().equals(player.getName())){
			client.getPlayer().setBuildCardBonus(buildBonus);;
		}
	}

}
