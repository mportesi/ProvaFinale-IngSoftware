package it.polimi.ingsw.changes;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.GC_40.Player;
import it.polimi.ingsw.areas.MarketBuilding;
import it.polimi.ingsw.client.ClientModel;
import it.polimi.ingsw.colors.ColorPlayer;
import it.polimi.ingsw.components.Relative;
/**
 * @author Sara
 * To modify the updated market on the client.
 */
public class ChangeMarket implements Change {
	private Player player;
	private Relative relative;
	private MarketBuilding market;
	
	public ChangeMarket(Player player, Relative relative, MarketBuilding market){
		this.player=player;
		this.relative=relative;
		this.market=market;
	}

	@Override
	public void applyChange(ClientModel client) throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		if(client.getPlayer().getMatch()==player.getMatch()){
		client.setMarket(market, player, relative);
		System.out.println("\nThe board is changed!\n" + client.getBoard());}
	}

}
