package it.polimi.ingsw.areas;

import java.io.Serializable;
import java.util.Random;

import it.polimi.ingsw.GC_40.Player;
import it.polimi.ingsw.cards.Card;
import it.polimi.ingsw.components.Relative;
import it.polimi.ingsw.effects.Effect;

public class Floor implements Serializable {
	
	private String type;
	private int cost;
	public Card currentCard;
	// private Piece bonus;
	private Player player;
	private Relative relative;
	public Effect bonusEffect;
	private boolean isFree;

	public Floor(String type, int cost, Effect bonusEffect) {
		this.bonusEffect = bonusEffect;
		this.type = type;
		this.cost = cost;
		relative = null;
		player = null;
		isFree = true;
	}

	public int getCost() {
		return cost;
	}

	public Card giveCard() {
		Card current = currentCard;
		currentCard = null;
		return current;
	}

	/*
	 * public Piece getBonus(){ return bonus; }
	 */

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
		isFree = false;
	}

	public void setFree() {
		isFree = true;
	}

	public boolean isFree() {
		return isFree;
	}

	public Card getCard() {
		return currentCard;
	}

	@Override
	public String toString() {
		if (isFree) {
			return ("Cost: " + cost + "\n Bonus: " + bonusEffect + "\n Card" + currentCard + "\n The floor is free!");
		} else {
			return ("Cost: " + cost + "\n Bonus: " + bonusEffect + "\n Card" + currentCard
					+ "\n The floor is occupied by: " + player);
		}
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bonusEffect == null) ? 0 : bonusEffect.hashCode());
		result = prime * result + cost;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Floor other = (Floor) obj;
		if (bonusEffect == null) {
			if (other.bonusEffect != null)
				return false;
		} else if (!bonusEffect.equals(other.bonusEffect))
			return false;
		if (cost != other.cost)
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

}
