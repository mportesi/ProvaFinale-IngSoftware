package it.polimi.ingsw.changes;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.areas.MarketBuilding;
import it.polimi.ingsw.client.ClientModel;
import it.polimi.ingsw.colors.ColorPlayer;
import it.polimi.ingsw.components.Relative;

public class ChangeMarket implements Change {
	
	private Relative relative;
	private MarketBuilding market;
	
	public ChangeMarket(Relative relative, MarketBuilding market){
		
		this.relative=relative;
		this.market=market;
	}

	@Override
	public void applyChange(ClientModel client) throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		client.setMarket(market, relative);
	}

}
