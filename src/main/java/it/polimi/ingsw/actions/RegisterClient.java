package it.polimi.ingsw.actions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.UUID;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.GC_40.Observable;
import it.polimi.ingsw.GC_40.Play;
import it.polimi.ingsw.GC_40.Player;
import it.polimi.ingsw.changes.Change;
import it.polimi.ingsw.changes.ChangeNewPlayer;

public class RegisterClient extends Observable<Change> implements Action {
	private String name;
	
	public RegisterClient(String name){
		this.name=name;
	}

	@Override
	public void apply(Play play) throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		play.createNewPlayer(name);
	}

	@Override
	public int getMatch() {
		// TODO Auto-generated method stub
		return 0;
	}

}
