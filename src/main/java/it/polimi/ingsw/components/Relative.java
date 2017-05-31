package it.polimi.ingsw.components;

import it.polimi.ingsw.colors.ColorDice;
import it.polimi.ingsw.GC_40.Player;

import it.polimi.ingsw.colors.ColorDice;


public class Relative {
	
	private Player player;
	private ColorDice color;
	private int value;
	
	public Relative(ColorDice color){
		this.color = color;
	}
	
	
	public ColorDice getColor() {
		return color;
	}
	
	public int getValue() {
		return value;
	}
	
	public void setValue(int n){
		this.value+=n;
	}


	public Player getPlayer() {
		return player;
	}


	
	
	
}
