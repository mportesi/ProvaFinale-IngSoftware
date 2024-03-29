package it.polimi.ingsw.areas;

import java.util.List;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.GC_40.Observable;
import it.polimi.ingsw.GC_40.Play;
import it.polimi.ingsw.GC_40.Player;
import it.polimi.ingsw.changes.Change;
import it.polimi.ingsw.changes.ChangeMarket;
import it.polimi.ingsw.components.Relative;
import it.polimi.ingsw.effects.Effect;
import it.polimi.ingsw.effects.GainCoin;
import it.polimi.ingsw.effects.GainFaithPoint;
import it.polimi.ingsw.effects.GainMilitaryPoint;
import it.polimi.ingsw.effects.GainPrivilegeCouncil;
import it.polimi.ingsw.effects.GainServant;
import it.polimi.ingsw.effects.GainStone;
import it.polimi.ingsw.effects.GainVictoryPoint;
import it.polimi.ingsw.effects.GainVictoryPointForBuildingCard;
import it.polimi.ingsw.effects.GainVictoryPointForCharacterCard;
import it.polimi.ingsw.effects.GainVictoryPointForMilitaryPoint;
import it.polimi.ingsw.effects.GainVictoryPointForTerritoryCard;
import it.polimi.ingsw.effects.GainVictoryPointForVentureCard;
import it.polimi.ingsw.effects.GainWood;

/**
 * @author Sara
 * The class for the different spaces of the market.
 * There are 4 spaces that have different bonus.
 */
public class MarketBuilding extends Observable<Change> implements Serializable{

	private String type;
	private boolean isOccupied;
	private int cost;
	private MarketListOfEffect marketEffect;
	private Player player;
	private Relative relative;
	private ArrayList<Effect> bonus;
	
	
	public MarketBuilding(String type, MarketListOfEffect marketEffect, int cost) throws FileNotFoundException, IOException, ParseException {
		this.type = type;
		this.marketEffect = marketEffect;
		this.cost = cost;
		bonus = marketEffect.createListOfEffect();
	}
	
	public MarketBuilding(MarketBuilding market, Play play){
		this.type=market.getType();
		this.bonus=market.getBonus();
		this.cost=market.getCost();
		registerObserver(play);
	}


	
	
	public ArrayList<Effect> getBonus() {
		
		return bonus;
	}

	public String getType() {
		return type;
	}

	
	/**
	 * @author Sara
	 * To apply the bonus of this specific market when a player decide to do the action put relative on market.
	 */
	public void applyEffect(Player player, Play play) throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		
		for (Effect e : bonus) {
			if (e != null) {
				e.apply(player, play);
			} else {
				return;
			}
		}
	}
	
	@Override
	public String toString() {
		if(isOccupied){
			return ("The market of type: " + type + "\n" + "With cost: " + cost + "\nWith bonus: " + bonus +"\nIs occupied by " +player.getName()+ " with the relative " + relative.getColor());
		}
		else return ("The market of type: " + type + "\n" + "With cost: " + cost +"\nWithBonus: " + bonus + "\nIs free!");
	}

	

	public boolean isOccupied() {
		return isOccupied;
	}

	public int getCost() {
		return cost;
	}

	/**
	 * @author Sara
	 * To put the player when he does an action that involve the market.
	 */
	public void setOccupied(Player player, Relative relative, MarketBuilding market) throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		this.isOccupied = true;
		this.relative=relative;
		this.player=player;
	}

	/**
	 * @author Sara
	 * To remove the player when the round finish.
	 */
	public void setFree() {
		isOccupied = false;
		player=null;
		relative=null;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bonus == null) ? 0 : bonus.hashCode());
		result = prime * result + cost;
		result = prime * result + ((marketEffect == null) ? 0 : marketEffect.hashCode());
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
		MarketBuilding other = (MarketBuilding) obj;
		if (bonus == null) {
			if (other.bonus != null)
				return false;
		} else if (!bonus.equals(other.bonus))
			return false;
		if (cost != other.cost)
			return false;
		if (marketEffect == null) {
			if (other.marketEffect != null)
				return false;
		} else if (!marketEffect.equals(other.marketEffect))
			return false;
		return true;
	}

	public Player getPlayer() {
		return player;
	}

	public Relative getRelative() {
		return relative;
	}
}
