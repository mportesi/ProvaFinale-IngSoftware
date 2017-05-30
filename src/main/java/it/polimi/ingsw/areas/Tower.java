package it.polimi.ingsw.components;

import java.util.ArrayList;
import java.util.List;

import it.polimi.ingsw.GC_40.Player;

public class Tower {
	private String type;
	public ArrayList <Floor> floors;
	private ArrayList<Card> deck1;
	private ArrayList<Card> deck2;
	private ArrayList<Card> deck3;
	
	
	public Tower(String type, ArrayList<Card> deck1,ArrayList<Card> deck2, ArrayList<Card> deck3, ArrayList<Floor> floors ){
		this.type=type;
		this.deck1=deck1;
		this.deck2=deck2;
		this.deck3=deck3;
		this.floors=floors;
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
			deck = deck1;
			break;
		case 2:
			deck = deck2;
			break;
		case 3:
			deck = deck3;
			break;
		}
		
		for(Floor f : floors){
			f.currentCard=deck.remove(0);
			}}
	
		/*for(int i=0; i<floors.length; i++){
			floors[i].currentCard=deck.remove(0);
			}
	}*/
		
	
	public boolean isPresent(Player p){
		for(Floor f: floors){
			if (f.getPlayer().equals(p)) return true;
		}
		return false;
	}

}
