package it.polimi.ingsw.GC_40;

public class CouncilPalace {
	private Player[] order;
	
	public void setOrder(){
		order= new Player[4];
	}
	
	public Pieces giveBonus(Pieces r){
		return r;
	}

}
