package it.polimi.ingsw.areas;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.Random;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.GC_40.Observable;
import it.polimi.ingsw.GC_40.Play;
import it.polimi.ingsw.GC_40.Player;
import it.polimi.ingsw.cards.Card;
import it.polimi.ingsw.changes.Change;
import it.polimi.ingsw.changes.ChangeTower;
import it.polimi.ingsw.components.Relative;
import it.polimi.ingsw.effects.Effect;

/**
 * @author Sara
 * The class that implements all floors of the towers.
 * Every floor has a type that corrisponds to the type of the tower,
 * it has a card, some floors have some bonus.
 * In every floor it is possible to put a relative and to take the card.
 */

public class Floor implements Serializable {
	
	private String type;
	private int cost;
	public Card currentCard;
	private Player player;
	private Relative relative;
	public Effect bonusEffect;
	private boolean isFree;

	public Floor(String type, int cost, Effect bonusEffect) {
		this.bonusEffect = bonusEffect;
		this.type = type;
		this.cost = cost;
		setRelative(null);
		player = null;
		isFree = true;
	}
	
	public Floor(Floor floor, Play play){
		this.bonusEffect=floor.getBonusEffect();
		this.type=floor.getType();
		this.cost=floor.getCost();
		setRelative(null);
		player = null;
		isFree = true;
	}

	private String getType() {
		return type;
	}

	public Effect getBonusEffect() {
		return bonusEffect;
	}

	public int getCost() {
		return cost;
	}

	/**
	 * @author Sara
	 * This method is necessary to return the card that is on this floor of the tower.
	 */
	public Card giveCard() {
		Card current = currentCard;
		currentCard = null;
		return current;
	}


	public Player getPlayer() {
		return player;
	}

	/**
	 * @author Sara
	 * To set the player when it is done an action that implies this floor.
	 */

	public void setPlayer(Player player, Relative relative, Tower tower, int floor) throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		this.player = player;
		this.relative=relative;
		isFree = false;
	}

	/**
	 * @author Sara
	 * To remove the player and the relative from the floor when the round is finish.
	 */
	public void setFree() {
		this.player=null;
		this.relative=null;
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
					+ "\n The floor is occupied by: " + player.getName() + " with the relative " + relative.getColor());
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

	public Relative getRelative() {
		return relative;
	}

	public void setRelative(Relative relative) {
		this.relative = relative;
	}

}
