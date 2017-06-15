package it.polimi.ingsw.effects;

import java.util.Map;

import it.polimi.ingsw.GC_40.Play;
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
	public void apply(Player player, Play play) throws InterruptedException {
		
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
	
	@Override
	public String toString(){
		return ("Effect: gain a card of type " + card + " with a value of " + value + " and a discount of " + discount );
	}

}
