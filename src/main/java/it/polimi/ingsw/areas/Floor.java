package it.polimi.ingsw.components;

import java.util.Random;

import it.polimi.ingsw.GC_40.Player;
import it.polimi.ingsw.effects.Effect;

public class Floor {
	private String type;
	private int cost;
	public Card currentCard;
//	private Piece bonus;
	private Player player;
	public Effect bonusEffect;
	private boolean isFree = true; 
	public int getCost(){
		return cost;
	}
	
	public Floor (String type, int cost, Effect bonusEffect){
		this.bonusEffect=bonusEffect;
		this.type=type;
		this.cost=cost;
	}
	
	
	public Card giveCard(){
		Card current= currentCard;
		currentCard= null;
		return current;
	}
	
	/*public Piece getBonus(){
		return bonus;
	}*/
	
	
	
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
