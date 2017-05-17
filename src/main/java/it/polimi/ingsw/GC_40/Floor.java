package it.polimi.ingsw.GC_40;

import java.util.Random;

public class Floor {
	private int cost;
	public Card currentCard;
	private Pieces bonus;
	private Player player;
	
	public int getCost(){
		return cost;
	}
	
	public Card giveCard(){
		Card current= currentCard;
		currentCard= null;
		return current;
	}
	
	public Pieces getBonus(){
		return bonus;
	}
	
	public Player getPlayer(){
		return player;
	}
	
	

}
