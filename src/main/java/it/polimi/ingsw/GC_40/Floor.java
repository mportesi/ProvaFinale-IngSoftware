package it.polimi.ingsw.GC_40;

import java.util.Random;

public class Floor {
	private int cost;
	public Card currentCard;
	private Pieces bonus;
	private Player player;
	private boolean isFree = true; 
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
	
	public void setPlayer(Player player){
		this.player= player;
		isFree= false;
	}
	public void setFree(){
		isFree= true;
	}
	public boolean isFree(){
		return isFree;
	}
}
