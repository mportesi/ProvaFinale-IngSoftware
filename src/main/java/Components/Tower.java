package Components;

import java.util.ArrayList;

import it.polimi.ingsw.GC_40.Player;


public class Tower {
	private String type;
	public Floor[] floors = new Floor[4];
	private ArrayList<Card> deck1;
	private ArrayList<Card> deck2;
	private ArrayList<Card> deck3;
	
	
	public Tower(String type, ArrayList<Card> deck1,ArrayList<Card> deck2, ArrayList<Card> deck3){
		this.type=type;
		this.deck1=deck1;
		this.deck2=deck2;
		this.deck3=deck3;
	}
	
	public String getType(){
		return type;
	}
	
	
	
	public void refreshTower(int period){
		ArrayList<Card> deck=new ArrayList<Card>();
		switch(period){
		case 1: deck=deck1;
				break;
		case 2: deck=deck2;
				break;
		case 3: deck=deck3;
				break;
		}
		
		for(int i=0; i<floors.length; i++){
			floors[i].currentCard=deck.remove(0);
			}
	}
		
	
	public boolean isPresent(Player p){
		for(Floor f: floors){
			if (f.getPlayer().equals(p)) return true;
		}
		return false;
	}
	
	
	
	
}
