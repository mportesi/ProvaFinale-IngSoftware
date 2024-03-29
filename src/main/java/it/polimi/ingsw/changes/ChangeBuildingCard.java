package it.polimi.ingsw.changes;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.GC_40.Player;
import it.polimi.ingsw.cards.BuildingCard;
import it.polimi.ingsw.client.ClientModel;
import it.polimi.ingsw.colors.ColorPlayer;
/**
 * @author Sara
 * To modify the player's building cards on the client.
 */
public class ChangeBuildingCard implements Change {
	private Player player;
	private ArrayList<BuildingCard> buildingCard;
	
	
	public ChangeBuildingCard(Player player, ArrayList<BuildingCard> buildingCard){
		this.player=player;
		this.buildingCard=buildingCard;
	}


	@Override
	public void applyChange(ClientModel client) {
		if(client.getPlayer().getName().equals(player.getName())){
			client.getPlayer().setBuilding(buildingCard);
		}
		
	}

}
