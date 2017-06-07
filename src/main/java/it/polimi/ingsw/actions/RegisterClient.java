package it.polimi.ingsw.actions;

import java.util.UUID;

import it.polimi.ingsw.GC_40.Observable;
import it.polimi.ingsw.GC_40.Player;
import it.polimi.ingsw.changes.Change;
import it.polimi.ingsw.changes.ChangeNewPlayer;

public class RegisterClient extends Observable<Change> implements Action {

	@Override
	public void apply() {
		UUID playerID= UUID.randomUUID();
		Player player= new Player(playerID);
		ChangeNewPlayer changeNewPlayer= new ChangeNewPlayer(player);
		System.out.println("the new player has"+ playerID);
		this.notifyObserver(changeNewPlayer);
		System.out.println("Ho notificato");
	}

}
