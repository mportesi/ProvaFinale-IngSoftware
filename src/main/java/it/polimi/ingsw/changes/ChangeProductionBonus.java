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
 * To modify the bonus due to the permanent effects on the client.
 */
public class ChangeProductionBonus implements Change {
	
	private int productionBonus;
	private Player player;
	
	public ChangeProductionBonus(Player player, int productionBonus){
		this.player=player;
		this.productionBonus=productionBonus;
	}

	@Override
	public void applyChange(ClientModel client)
			throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		if (client.getName().equals(player.getName())){
			client.getPlayer().setProductionBonus(productionBonus);;
		}
	}

}
