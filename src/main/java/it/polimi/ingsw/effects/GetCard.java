package it.polimi.ingsw.effects;

import java.util.Map;

import it.polimi.ingsw.GC_40.Player;
import it.polimi.ingsw.areas.Floor;
import it.polimi.ingsw.areas.Tower;
import it.polimi.ingsw.cards.Card;

public class GetCard extends Effect {
	private String card;
	private int value;
	private Map<String, Integer> discount;
	
	
	public GetCard(String card, int value, Map<String, Integer> discount){
		this.card=card;
		this.value=value;
		this.discount=discount;
		
	}
	
	

	@Override
	public void apply(Player player) {
		
		Card card=//qualcosa chooseCard(value, discount);
		applyCard(player, this.card );
		
	}
	//TODO
	Card applyCard(Player player,String card){
		if (card.equals("lorenzo")){
			Card card2= new Card("building", "lorenzo", 1);
			return card2;
		}
		return null;
	}

}
