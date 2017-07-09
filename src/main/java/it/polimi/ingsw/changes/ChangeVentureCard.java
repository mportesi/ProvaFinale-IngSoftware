package it.polimi.ingsw.changes;

import java.util.ArrayList;

import it.polimi.ingsw.GC_40.Player;
import it.polimi.ingsw.cards.VentureCard;
import it.polimi.ingsw.client.ClientModel;
import it.polimi.ingsw.colors.ColorPlayer;
/**
 * @author Sara
 * To modify the player's venture cards on the client.
 */
public class ChangeVentureCard implements Change {
	private Player player;
	private ArrayList<VentureCard> ventureCard;
	
	public ChangeVentureCard(Player player, ArrayList<VentureCard> ventureCard){
		this.player=player;
		this.ventureCard=ventureCard;
	}


	@Override
	public void applyChange(ClientModel client) {
		if(client.getPlayer().getName().equals(player.getName())){
			client.getPlayer().setVentureCard(ventureCard);
		}

	}

}
