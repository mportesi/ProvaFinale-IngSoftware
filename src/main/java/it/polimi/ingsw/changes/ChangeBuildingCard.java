package it.polimi.ingsw.changes;

import java.util.ArrayList;

import it.polimi.ingsw.GC_40.Player;
import it.polimi.ingsw.cards.BuildingCard;
import it.polimi.ingsw.client.ClientModel;
import it.polimi.ingsw.colors.ColorPlayer;

public class ChangeBuildingCard implements Change {
	private Player player;
	private ArrayList<BuildingCard> buildingCard;
	
	
	public ChangeBuildingCard(Player player, ArrayList<BuildingCard> buildingCard){
		this.player=player;
		this.buildingCard=buildingCard;
	}


	@Override
	public void applyChange(ClientModel client) {
		if(client.getPlayer().equals(client)){
			player.setBuilding(buildingCard);
		}
		
		/*for(Player p: client.getPlayers()){
			if(player.equals(p)){
				player.setBuilding(buildingCard);
			}
		}*/

	}

}
