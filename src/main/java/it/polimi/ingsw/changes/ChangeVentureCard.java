package it.polimi.ingsw.changes;

import java.util.ArrayList;

import it.polimi.ingsw.cards.VentureCard;
import it.polimi.ingsw.colors.ColorPlayer;

public class ChangeVentureCard implements Change {
	private ColorPlayer color;
	private ArrayList<VentureCard> ventureCard;
	
	public ChangeVentureCard(ColorPlayer color, ArrayList<VentureCard> ventureCard){
		this.color=color;
		this.ventureCard=ventureCard;
	}


	@Override
	public void applyChange() {
		// TODO Auto-generated method stub

	}

}
