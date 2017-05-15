package it.polimi.ingsw.GC_40;

public class Dice {
	private Color color;
	private int value;
	
	public Color getColor() {
		return color;
	}
	public int getValue() {
		return value;
	}
	
	public int roll(){
		return (int) (Math.random()*6)+1;
	}
}
