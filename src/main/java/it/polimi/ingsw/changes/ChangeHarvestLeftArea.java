package it.polimi.ingsw.changes;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.GC_40.Observable;
import it.polimi.ingsw.client.ClientModel;
import it.polimi.ingsw.colors.ColorPlayer;
import it.polimi.ingsw.components.Relative;
/**
 * @author Sara
 * To set the modified left harvest area on every client.
 */
public class ChangeHarvestLeftArea implements Change {
	private Relative relative;
	
	public ChangeHarvestLeftArea(Relative relative){
		this.relative=relative;
	}

	@Override
	public void applyChange(ClientModel client) throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		if(client.getPlayer().getMatch()==relative.getPlayer().getMatch()){
		client.setHarvestLeftArea(relative);
		System.out.println("\nThe board is changed!\n" + client.getBoard());}
	}

}
