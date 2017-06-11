package it.polimi.ingsw.areas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import it.polimi.ingsw.GC_40.Player;
import it.polimi.ingsw.cards.Card;
import it.polimi.ingsw.components.Relative;

public class Tower implements Serializable {
	private String type;
	public ArrayList<Floor> floors;
	private ArrayList<Card> deck1;
	private ArrayList<Card> deck2;
	private ArrayList<Card> deck3;
	
	
	public Tower(String type, ArrayList<Card> deck1, ArrayList<Card> deck2, ArrayList<Card> deck3, ArrayList<Floor> floors) {
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
		System.out.println("Sono nella refresh tower");
		ArrayList<Card> deck = new ArrayList<Card>();
		switch (period) {
		case 1:
			{
			System.out.println("Sono nel case1");	
			deck = deck1;
			
			break;
			}
		case 2:
			{deck = deck2;
			System.out.println("mazzo2:" + deck.get(0));
			break;
			}
		case 3:
			{deck = deck3;
			System.out.println("mazzo3:" + deck.get(0));
			break;
			}
		}

		
				for(int i=0; i<4; i++){
				floors.get(i).currentCard = deck.remove(i);
				System.out.println("ho messo nel piano: "+i +"la carta:" + floors.get(i).currentCard.getType());
				}
		
	}

	/*
	 * for(int i=0; i<floors.length; i++){ floors[i].currentCard=deck.remove(0);
	 * } }
	 */
	
	public boolean isPresent(Player p) {
	//	floors = new ArrayList <Floor>();
		//System.out.println(floors.get(0));
		for (Floor f : floors) {
			if (f.getPlayer()==null || f.getPlayer().equals(p))
			
				return true;
		}
		return false;
	}

	public Floor getFloor(int i) {
		return floors.get(i);
	}

	@Override
	public String toString() {
		return ("The tower of type: " + type + " is: \n" + "[" + floors.get(0).getCard() + "] \n" + "["
				+ floors.get(1).getCard() + "] \n" + "[" + floors.get(2).getCard() + "] \n" + "["
				+ floors.get(3).getCard() + "] \n");
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



}
