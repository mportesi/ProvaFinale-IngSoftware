package it.polimi.ingsw.changes;

import java.util.ArrayList;

import it.polimi.ingsw.GC_40.Observable;
import it.polimi.ingsw.GC_40.Player;
import it.polimi.ingsw.cards.CharacterCard;
import it.polimi.ingsw.client.ClientModel;
import it.polimi.ingsw.colors.ColorPlayer;
/**
 * @author Sara
 * To modify the player's character cards  on the client.
 */
public class ChangeCharacterCard implements Change {
	private Player player;
	private ArrayList<CharacterCard> characterCard;
	
	public ChangeCharacterCard(Player player, ArrayList<CharacterCard> characterCard){
		this.player=player;
		this.characterCard=characterCard;
	}


	@Override
	public void applyChange(ClientModel client) {
		if(client.getPlayer().getName().equals(player.getName())){
			client.getPlayer().setCharacter(characterCard);
		}
		
		
	}

}
