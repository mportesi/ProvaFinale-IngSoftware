package it.polimi.ingsw.changes;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.GC_40.Observable;
import it.polimi.ingsw.client.ClientModel;
import it.polimi.ingsw.colors.ColorPlayer;
import it.polimi.ingsw.components.Relative;

public class ChangeHarvestLeftArea implements Change {
	//private Player player;
	private Relative relative;
	
	public ChangeHarvestLeftArea(Relative relative){
		//this.player=player;
		this.relative=relative;
	}

	@Override
	public void applyChange(ClientModel client) throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		client.setHarvestLeftArea(relative);
	}

}
