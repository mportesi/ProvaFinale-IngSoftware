package it.polimi.ingsw.GC_40;


import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.actions.Action;
import it.polimi.ingsw.actions.PutRelative;
import it.polimi.ingsw.changes.*;

/**
 * @author Chiara
 * This class represents the controller of the game. It is an observer, and when it is notified of an action it updates it.
 *
 */

public class Controller implements Observer<Action> {
	
		private  final Play play;
		
		public Controller(Play play){
			this.play=play;
		}
		
		
		@Override
		public void update(Action action) throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
			action.apply(play);

		}




		public Play getPlay() {
			return play;
		}


		@Override
		public void update() {
			
		}



		
	}

