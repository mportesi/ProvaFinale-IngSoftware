package it.polimi.ingsw.GC_40;


import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.actions.Action;
import it.polimi.ingsw.actions.PutRelative;
import it.polimi.ingsw.changes.*;


public class Controller implements Observer<Action> {
	

	
		
		private final Play play;
		
		public Controller(Play play){
			this.play=play;
		}
		
		

		/*@Override
		public void update(Change change) {
			// TODO Auto-generated method stub
			change.applyChange();

		}*/
		
		@Override
		public void update(Action action) throws FileNotFoundException, NullPointerException, IOException, ParseException {
			// TODO Auto-generated method stub
			System.out.println(play);
			action.apply(play);
			//System.out.println("E' stata fatta apply()");

		}




		public Play getPlay() {
			return play;
		}


		@Override
		public void update() {
			// TODO Auto-generated method stub
			
		}



		
	}

