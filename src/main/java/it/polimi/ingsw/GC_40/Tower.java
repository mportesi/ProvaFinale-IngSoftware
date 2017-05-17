package it.polimi.ingsw.GC_40;

public class Tower {
	private String name;
	private Color color;
	private Floor[] floors;
	private Deck[] deck;
	
	public Color getColor(){
		return color;
	}
	
	public void setFloors(){
		floors= new Floor[4];
	}
	
	public void refresh(int period){
		for(int i=0; i<floors.length; i++){
			floors[i].currentCard=random(deck);
		}
	}
	
}
