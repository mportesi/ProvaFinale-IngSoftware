package it.polimi.ingsw.changes;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.client.ClientModel;
import it.polimi.ingsw.components.Relative;
/**
 * @author Sara
 * To set the modified right harvest area on every client.
 */
public class ChangeHarvestRightArea implements Change {
	private Relative relative;
	
	public ChangeHarvestRightArea(Relative relative){
		this.relative=relative;
	}
	

	@Override
	public void applyChange(ClientModel client) throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		if(client.getPlayer().getMatch()==relative.getPlayer().getMatch()){
		client.setHarvestRightArea(relative);
		System.out.println("\nThe board is changed!\n" + client.getBoard());}
	}

}
