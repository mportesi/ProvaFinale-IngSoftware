package it.polimi.ingsw.changes;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.GC_40.Player;
import it.polimi.ingsw.client.ClientModel;

public class ChangeNotApplicable implements Change {
	private Player player;
	
	public ChangeNotApplicable(Player player){
		this.player=player;
	}

	@Override
	public void applyChange(ClientModel client)
			throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		// TODO Auto-generated method stub
		if(client.getPlayer().getName().equals(player.getName())){
			System.out.println("The action did by " + player.getName() + "wasn't correct!");
			client.setCurrentPlayer(player);
		}

	}

}
