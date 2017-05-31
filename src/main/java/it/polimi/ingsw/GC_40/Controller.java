package it.polimi.ingsw.GC_40;


import it.polimi.ingsw.changes.*;

public class Controller implements Observer<Change> {
	
	private final Play play;
	
	public Controller(Play play){
		this.play=play;
	}
	
	

	@Override
	public void update(Change change) {
		// TODO Auto-generated method stub
		change.apply();

	}



	public Play getGameServer() {
		return play;
	}



	
}
