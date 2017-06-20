package it.polimi.ingsw.GC_40;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.actions.Action;


public class MasterController implements Observer<Action>{
	private HashMap <Integer, Controller> controllers;
	
	public MasterController(){
		controllers = new HashMap <Integer, Controller> ();
	}
	
	public void addController(Controller controller, int match){
		this.controllers.put(match, controller);
	}

	@Override
	public void update(Action action)
			throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		System.out.println(controllers);
		
		action.apply(controllers.get(action.getPlay()).getPlay());
		
		
		
		
	}

	@Override
	public void update() {
		
	}
	
	

}
