package it.polimi.ingsw.GC_40;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.actions.PutRelative;

public interface Observer<C> {
	
	
	public default void update(C change) throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException{
		
	};
	
	public abstract void update();

	


	

}
