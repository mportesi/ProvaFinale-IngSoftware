package it.polimi.ingsw.GC_40;

import java.util.Observable;
import java.util.Observer;

import it.polimi.ingsw.changes.*;

public class Controller implements Observer<Change> {
	
	private final GameServer gameServer;
	
	public Controller(GameServer gameServer){
		this.gameServer=gameServer;
	}
	
	

	@Override
	public void update(Change change) {
		// TODO Auto-generated method stub

	}



	public GameServer getGameServer() {
		return gameServer;
	}

	
}
