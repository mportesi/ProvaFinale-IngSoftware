package it.polimi.ingsw.changes;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.client.ClientModel;
import it.polimi.ingsw.colors.ColorPlayer;
import it.polimi.ingsw.components.Relative;
/**
 * @author Sara
 * To modify the updated left production area on the client.
 */
public class ChangeProductionLeftArea implements Change {
	
	private Relative relative;
	
	public ChangeProductionLeftArea(Relative relative){
		this.relative=relative;
	}

	@Override
	public void applyChange(ClientModel client) throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		if(client.getPlayer().getMatch()==relative.getPlayer().getMatch()){
		client.setProductionLeftArea(relative);
		System.out.println("\nThe board is changed!\n" + client.getBoard());
	}
	}

}
