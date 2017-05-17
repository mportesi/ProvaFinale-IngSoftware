package it.polimi.ingsw.GC_40;

public class Tower {
	private Color color;
	private Floor[] floors;
	
	public Color getColor(){
		return color;
	}
	
	public void setFloors(){
		floors= new Floor[4];
	}
	
	public void refresh(){
		for(int i=0; i<floors.length; i++){
			floors[i].changeCard();
		}
	}
	
}
