package it.polimi.ingsw.components;

<<<<<<< HEAD:src/main/java/Components/Relative.java
import it.polimi.ingsw.GC_40.ColorDice;
import it.polimi.ingsw.GC_40.Player;
=======
import it.polimi.ingsw.colors.ColorDice;
>>>>>>> Sara:src/main/java/it/polimi/ingsw/components/Relative.java

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
