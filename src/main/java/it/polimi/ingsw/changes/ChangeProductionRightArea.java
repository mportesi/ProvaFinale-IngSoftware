package it.polimi.ingsw.changes;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.client.ClientModel;
import it.polimi.ingsw.components.Relative;

public class ChangeProductionRightArea implements Change {
private Relative relative;
	
	public ChangeProductionRightArea(Relative relative){
		this.relative=relative;
	}
	

	@Override
	public void applyChange(ClientModel client) throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		client.setProductionRightArea(relative);
		System.out.println("\nThe board is changed!\n" + client.getBoard());

	}

}
