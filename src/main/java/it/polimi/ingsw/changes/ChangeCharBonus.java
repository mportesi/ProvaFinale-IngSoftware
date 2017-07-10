package it.polimi.ingsw.changes;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.GC_40.Observable;
import it.polimi.ingsw.GC_40.Play;
import it.polimi.ingsw.GC_40.Player;
import it.polimi.ingsw.client.ClientModel;
import it.polimi.ingsw.colors.ColorPlayer;
/**
 * @author Sara
 * To modify the player's attributes that he gains for the permanent effects on the client.
 */
public class ChangeCharBonus implements Change {
	
	private int charBonus;
	private Player player;
	
	public ChangeCharBonus(Player player, int charBonus){
		this.player=player;
		this.charBonus=charBonus;
	}

	@Override
	public void applyChange(ClientModel client)
			throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		if (client.getName().equals(player.getName())){
			client.getPlayer().setCharCardBonus(charBonus);;
		}
	}

}
