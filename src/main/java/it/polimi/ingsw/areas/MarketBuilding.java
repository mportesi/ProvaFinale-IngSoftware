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

public class MarketBuilding extends Observable<Change> implements Serializable{

	private String type; // A COSA SERVE??
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


	
	
	private ArrayList<Effect> getBonus() {
		
		return bonus;
	}

	private String getType() {
		return type;
	}

	

	public void applyEffect(Player player) throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		
		for (Effect e : bonus) {
			if (e != null) {
				e.apply(player);
			} else {
				return;
			}
		}
	}
	
	@Override
	public String toString() {
		if(player!=null){
			return ("The market of type: " + type + "\n" + "With cost: " + cost + "\nWith bonus: " + bonus +"\nIs occupied by " +player+ " with the relative " + relative.getColor());
		}
		return ("The market of type: " + type + "\n" + "With cost: " + cost +"\nWithBonus: " + bonus + "\nIs free!");
	}

	

	public boolean IsOccupied() {
		return isOccupied;
	}

	public int getCost() {
		return cost;
	}


	public void setOccupied(Relative relative, MarketBuilding market) throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		isOccupied = true;
		this.relative=relative;
		ChangeMarket changeMarket= new ChangeMarket(relative, market);
		this.notifyObserver(changeMarket);
	}

	public void setFree() {
		isOccupied = false;
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
}
