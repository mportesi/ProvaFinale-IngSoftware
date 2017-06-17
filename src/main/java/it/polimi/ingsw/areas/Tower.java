package it.polimi.ingsw.areas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import it.polimi.ingsw.GC_40.Observable;
import it.polimi.ingsw.GC_40.Play;
import it.polimi.ingsw.GC_40.Player;
import it.polimi.ingsw.cards.Card;
import it.polimi.ingsw.changes.Change;
import it.polimi.ingsw.components.Relative;

public class Tower implements Serializable {
	private String type;
	public ArrayList<Floor> floors;
	private ArrayList<Card> deck1;
	private ArrayList<Card> deck2;
	private ArrayList<Card> deck3;
	private int cost;
	
	
	public Tower(String type, ArrayList<Card> deck1, ArrayList<Card> deck2, ArrayList<Card> deck3, ArrayList<Floor> floors, Play play) {
		this.type = type;
		this.deck1 = deck1;
		this.deck2 = deck2;
		this.deck3 = deck3;
		this.floors = floors;
	}

	public String getType() {
		return type;
	}
	
	
	// To empty the towers at the end of the round and to recharge them with new
	// cards
	public void refreshTower(int period) {
		ArrayList<Card> deck = new ArrayList<Card>();
		switch (period) {
		case 1:
			{
			deck = deck1;
			break;
			}
		case 2:
			{deck = deck2;
			break;
			}
		case 3:
			{deck = deck3;
			break;
			}
		}
				for(int i=3; i>=0; i--){
					floors.get(i).currentCard = deck.remove(i);
				
				}
		
	}

	
	
	public boolean isPresent(Player p) {
	
		for (Floor f : floors) {
			if (f.getPlayer()==null || !f.getPlayer().equals(p) || (f.getPlayer().equals(p) && f.getRelative().getColor()==null))
			
				return false;
		}
		return true;
	}
	
	public boolean isPresentAnyone() {
			for (Floor f : floors) {
				if (f.getPlayer()!=null){
					cost=3;
					return true;}
			}
			return false;
		}
	

	public Floor getFloor(int i) {
		return floors.get(i);
	}

	@Override
	public String toString() {
		if(isPresentAnyone()){
			return ("The " + type + " tower have a cost of 3 coin and is: \n" + "[" +
					"FLOOR n°4 \n " + floors.get(3)+ "] \n" + "["
					+ "FLOOR n°3 \n " + floors.get(2) + "] \n" + "["
					+ "FLOOR n°2 \n " + floors.get(1)+ "] \n" + "[" +
					"FLOOR n°1 \n " + floors.get(0) + "] \n" );
		}
		return ("The " + type + " tower is: \n" + "[" +
				"FLOOR n°4 \n " + floors.get(3)+ "] \n" + "["
				+ "FLOOR n°3 \n " + floors.get(2) + "] \n" + "["
				+ "FLOOR n°2 \n " + floors.get(1)+ "] \n" + "[" +
				"FLOOR n°1 \n " + floors.get(0) + "] \n" );
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((floors == null) ? 0 : floors.hashCode());
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
		Tower other = (Tower) obj;
		if (floors == null) {
			if (other.floors != null)
				return false;
		} else if (!floors.equals(other.floors))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	public int getCost() {
		return 3;
	}



}
