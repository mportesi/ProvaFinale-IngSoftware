package it.polimi.ingsw.changes;

import java.util.ArrayList;

import it.polimi.ingsw.cards.CharacterCard;
import it.polimi.ingsw.colors.ColorPlayer;

public class ChangeCharacterCard implements Change {
	private ColorPlayer color;
	private ArrayList<CharacterCard> characterCard;
	
	public ChangeCharacterCard(ColorPlayer color, ArrayList<CharacterCard> characterCard){
		this.color=color;
		this.characterCard=characterCard;
	}
	
	


	@Override
	public void applyChange() {
		// TODO Auto-generated method stub

	}

}
