package Components;

import it.polimi.ingsw.GC_40.ColorDice;

public class Relative {
	
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
	
	
}
