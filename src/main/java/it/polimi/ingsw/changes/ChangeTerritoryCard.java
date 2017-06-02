package it.polimi.ingsw.changes;

import java.util.ArrayList;

import it.polimi.ingsw.cards.TerritoryCard;
import it.polimi.ingsw.colors.ColorPlayer;

public class ChangeTerritoryCard implements Change {
	private ColorPlayer color;
	private ArrayList<TerritoryCard> territoryCard;
	
	public ChangeTerritoryCard(ColorPlayer color, ArrayList<TerritoryCard> territoryCard){
		this.color=color;
		this.territoryCard=territoryCard;
	}

	@Override
	public void applyChange() {
		// TODO Auto-generated method stub

	}

}
