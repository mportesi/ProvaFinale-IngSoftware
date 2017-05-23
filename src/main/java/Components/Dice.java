package Components;

import it.polimi.ingsw.GC_40.ColorDice;

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
	
	public int roll(){
		return (int) (Math.random()*6)+1;
	}
}
