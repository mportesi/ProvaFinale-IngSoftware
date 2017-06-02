package it.polimi.ingsw.changes;

import java.util.ArrayList;

import it.polimi.ingsw.cards.BuildingCard;
import it.polimi.ingsw.colors.ColorPlayer;

public class ChangeBuildingCard implements Change {
	private ColorPlayer color;
	private ArrayList<BuildingCard> buildingCard;
	
	public ChangeBuildingCard(ColorPlayer color, ArrayList<BuildingCard> buildingCard){
		this.color=color;
		this.buildingCard=buildingCard;
	}


	@Override
	public void applyChange() {
		// TODO Auto-generated method stub

	}

}
