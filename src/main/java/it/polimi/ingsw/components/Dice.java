package it.polimi.ingsw.components;

import it.polimi.ingsw.colors.ColorDice;

public class Dice {
	private ColorDice color;
	private int value;
	
	public Dice(ColorDice color){
		this.color=color;
	}
	
	public ColorDice getColor() {
		return color;
	}
	public int getValue() {
		return value;
	}
	
	//to throw the dices when the round is finished
	public int roll(){
		return (int) (Math.random()*6)+1;
	}

	public void setValue(){
		value= roll();
	}
}