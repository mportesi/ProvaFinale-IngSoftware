package it.polimi.ingsw.changes;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.GC_40.Player;
import it.polimi.ingsw.client.ClientModel;
import it.polimi.ingsw.components.Relative;
/**
 * @author Sara
 * To set on the player the relative that is already used.
 */
public class ChangeOccupiedRelative implements Change {
	private Player player;
	private Relative relative;

	
	public ChangeOccupiedRelative(Player player, Relative relative){
		this.player=player;
		this.relative=relative;
		
	}

	@Override
	public void applyChange(ClientModel client)
			throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		if(this.player.getName().equals(client.getPlayer().getName())){
			client.getPlayer().setOccupiedRelative(relative);
			client.getPlayer().removeRelative(relative);
			System.out.println("For this round you cannot use anymore the relative " + relative.getColor());
		}

	}

}
