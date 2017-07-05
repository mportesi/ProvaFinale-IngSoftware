package it.polimi.ingsw.changes;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.GC_40.Player;
import it.polimi.ingsw.client.ClientModel;

public class ChangeNotApplicable implements Change {
	private Player player;
	private String string;
	
	public ChangeNotApplicable(Player player, String string){
		this.player=player;
		this.string=string;
	}

	@Override
	public void applyChange(ClientModel client)
			throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		if(client.getPlayer().getMatch()==player.getMatch() && client.getPlayer().getName().equals(player.getName())){
			System.out.println("The action did by " + player.getName() + " wasn't correct because: " + string);
			client.setCurrentPlayer(player);
			client.actionNotApplicable();
		}

	}

}
