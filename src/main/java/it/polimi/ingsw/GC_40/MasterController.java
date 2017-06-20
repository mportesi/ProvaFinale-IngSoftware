package it.polimi.ingsw.GC_40;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.actions.Action;


public class MasterController implements Observer<Action>{
	private HashMap <Controller, Integer> controllers;
	
	public MasterController(){
		controllers = new HashMap <Controller, Integer> ();
	}
	
	public void addController(Controller controller, int match){
		this.controllers.put(controller, match);
	}

	@Override
	public void update(Action action)
			throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		System.out.println(controllers);1
		for (Controller c : controllers.keySet()){
			
		if (action.getPlay() == controllers.get(c)){
			action.apply(c.getPlay());
		}
		}
		
	}

	@Override
	public void update() {
		
	}
	
	

}
