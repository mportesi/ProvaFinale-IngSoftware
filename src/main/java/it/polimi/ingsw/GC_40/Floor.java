package it.polimi.ingsw.GC_40;

public class Floor {
	private int cost;
	private Card currentCard;
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
