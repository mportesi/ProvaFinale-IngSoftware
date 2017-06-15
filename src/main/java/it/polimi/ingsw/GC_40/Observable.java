package it.polimi.ingsw.GC_40;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.AlreadyBoundException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.parser.ParseException;

public abstract class Observable<C> {
	private List<Observer<C>> observers;
	
	public Observable(){
		observers=new ArrayList<Observer<C>>();
	}
	
	public void registerObserver(Observer<C> o){
		observers.add(o);
	}
	
	
	public void notifyObserver(){
		for(Observer<C> o: this.observers){
			o.update();
		}
	}
	
	public void notifyObserver(C c) throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException{
	
		for (Observer<C> o: this.observers){
			o.update(c);
		}
	}
	
	

}
