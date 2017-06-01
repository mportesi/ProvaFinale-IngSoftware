package it.polimi.ingsw.effects;

import java.util.Map;

import it.polimi.ingsw.GC_40.Player;
import it.polimi.ingsw.areas.Floor;
import it.polimi.ingsw.areas.Tower;

public class GetCard extends Effect {
	private Tower tower;
	private int value;
	private Map<String, Integer> discount;
	
	
	public GetCard(Tower tower, int value, Map<String, Integer> discount, Floor floor){
		this.card=card;
		this.value=value;
		this.discount=discount;
		this.floor=floor;
	}
	
	

	@Override
	public void apply(Player player) {
		/*switch(card){

			case "characterCard": player.chooseCharacterCard(value, discount);
			case "ventureCard": player.chooseVentureCard(value, discount);
			case "territoryCard": player.chooseTerritoryCard(value);
			case "buildingCard": player.chooseBuildingCard(value, discount);
			case "anyone": player.chooseCard(value);*/

	}

	public Card chooseCard(Tower tower, int floor){
		return tower.getFloor(floor).getCard();
	}

}
