package it.polimi.ingsw.changes;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.GC_40.Observable;
import it.polimi.ingsw.GC_40.Player;
import it.polimi.ingsw.areas.CouncilPalace;
import it.polimi.ingsw.client.ClientModel;
import it.polimi.ingsw.components.Relative;

public class ChangeCouncilPalace implements Change {
	private Player player;
	private Relative relative;
	
	public ChangeCouncilPalace(Player player, Relative relative){
		this.relative=relative;
		this.player=player;
	}

	@Override
	public void applyChange(ClientModel client) throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		if(client.getPlayer().getMatch()==player.getMatch()){
		client.setCouncilPalace(player, relative);
		System.out.println("\nThe board is changed!\n" + client.getBoard());}
	}
	

}
