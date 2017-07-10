package it.polimi.ingsw.components;

import java.util.Map;

/**
 * @author Chiara
 * This class represents the final victory points to give to each player for each card/resource at the end of the game.
 *
 */

public class FinalVictoryPoint {
	private String type;
	private int finalVictoryPointForOne;
	private int finalVictoryPointForTwo;
	private int finalVictoryPointForThree;
	private int finalVictoryPointForFour;
	private int finalVictoryPointForFive;
	private int finalVictoryPointForSix;
	
	public FinalVictoryPoint(String type, int finalVictoryPointForOne, int finalVictoryPointForTwo, int finalVictoryPointForThree, int finalVictoryPointForFour, int finalVictoryPointForFive, int finalVictoryPointForSix){
		this.finalVictoryPointForOne = finalVictoryPointForOne;
		this.finalVictoryPointForTwo = finalVictoryPointForTwo;
		this.finalVictoryPointForThree = finalVictoryPointForThree;
		this.finalVictoryPointForFour = finalVictoryPointForFour;
		this.finalVictoryPointForFive = finalVictoryPointForFive;
		this.finalVictoryPointForSix = finalVictoryPointForSix;
		this.type = type;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getFinalVictoryPointForOne() {
		return finalVictoryPointForOne;
	}
	public void setFinalVictoryPointForOne(int finalVictoryPointForOne) {
		this.finalVictoryPointForOne = finalVictoryPointForOne;
	}
	public int getFinalVictoryPointForTwo() {
		return finalVictoryPointForTwo;
	}
	public void setFinalVictoryPointForTwo(int finalVictoryPointForTwo) {
		this.finalVictoryPointForTwo = finalVictoryPointForTwo;
	}
	public int getFinalVictoryPointForThree() {
		return finalVictoryPointForThree;
	}
	public void setFinalVictoryPointForThree(int finalVictoryPointForThree) {
		this.finalVictoryPointForThree = finalVictoryPointForThree;
	}
	public int getFinalVictoryPointForFour() {
		return finalVictoryPointForFour;
	}
	public void setFinalVictoryPointForFour(int finalVictoryPointForFour) {
		this.finalVictoryPointForFour = finalVictoryPointForFour;
	}
	public int getFinalVictoryPointForFive() {
		return finalVictoryPointForFive;
	}
	public void setFinalVictoryPointForFive(int finalVictoryPointForFive) {
		this.finalVictoryPointForFive = finalVictoryPointForFive;
	}
	public int getFinalVictoryPointForSix() {
		return finalVictoryPointForSix;
	}
	public void setFinalVictoryPointForSix(int finalVictoryPointForSix) {
		this.finalVictoryPointForSix = finalVictoryPointForSix;
	}
}
