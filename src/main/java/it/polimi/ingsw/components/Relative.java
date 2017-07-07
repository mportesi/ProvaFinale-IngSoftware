package it.polimi.ingsw.components;

import it.polimi.ingsw.colors.ColorDice;

import java.io.Serializable;

import it.polimi.ingsw.GC_40.Player;

import it.polimi.ingsw.colors.ColorDice;


public class Relative implements Serializable{
	
	private Player player;
	private ColorDice color;
	private int value;
	private int servantsUsed;
	
	public Relative(ColorDice color, Player player){
		this.color = color;
		this.player=player;
		this.servantsUsed=0;
	}
	
	
	public ColorDice getColor() {
		return color;
	}
	
	public int getValue() {
		return value;
	}
	
	public void setValueServant(int n){
		this.value=value+n;
		this.servantsUsed=n;
	}
	
	public void setValue(int value){
		this.value= value;
	}


	public Player getPlayer() {
		return player;

	}

	@Override
	public String toString(){
		return ("Relative " + color +" of player " + player.getName());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((player == null) ? 0 : player.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Relative other = (Relative) obj;
		if (color != other.color)
			return false;
		if (player == null) {
			if (other.player != null)
				return false;
		} else if (!player.equals(other.player))
			return false;
		return true;
	}


	public int getServantsUsed() {
		return servantsUsed;
	}


	
	
	
}
