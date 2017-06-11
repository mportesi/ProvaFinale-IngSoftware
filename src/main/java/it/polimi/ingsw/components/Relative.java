package it.polimi.ingsw.components;

import it.polimi.ingsw.colors.ColorDice;

import java.io.Serializable;

import it.polimi.ingsw.GC_40.Player;

import it.polimi.ingsw.colors.ColorDice;


public class Relative implements Serializable{
	
	private Player player;
	private ColorDice color;
	private int value;
	
	public Relative(ColorDice color, Player player){
		this.color = color;
		this.player=player;
	}
	
	
	public ColorDice getColor() {
		return color;
	}
	
	public int getValue() {
		return value;
	}
	
	public void setValueServant(int n){
		this.value+= n;
	}
	
	public void setValue(int value){
		this.value= value;
		System.out.println("The relative has the value" + value + "  with color  " + color);
	}


	public Player getPlayer() {
		return player;
	}


	
	
	
}
