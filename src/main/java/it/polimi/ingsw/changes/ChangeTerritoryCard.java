package it.polimi.ingsw.changes;

import java.util.ArrayList;

import it.polimi.ingsw.GC_40.Player;
import it.polimi.ingsw.cards.TerritoryCard;
import it.polimi.ingsw.client.ClientModel;
import it.polimi.ingsw.colors.ColorPlayer;

public class ChangeTerritoryCard implements Change {
	private Player player;
	private ArrayList<TerritoryCard> territoryCard;
	
	public ChangeTerritoryCard(Player player, ArrayList<TerritoryCard> territoryCard){
		this.player=player;
		this.territoryCard=territoryCard;
	}

	@Override
	public void applyChange(ClientModel client) {
		if(client.getPlayer().equals(client)){
			player.setTerritoryCard(territoryCard);
		}
		/*for (Player p : client.getPlayers()) {
			if (player.equals(p)) {
				p.setTerritoryCard(territoryCard);
			}
		}*/

	}

}
