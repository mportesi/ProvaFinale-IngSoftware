package it.polimi.ingsw.GC_40;

import java.io.FileNotFoundException;
import java.io.IOException;
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
		System.out.println(o);
	}
	
	public void unregisterObserver(Observer<C> o){
		this.observers.remove(o);
	}
	
	public void notifyObserver(){
		for(Observer<C> o: this.observers){
			o.update();
		}
	}
	
	public void notifyObserver(C c) throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException{
		for (Observer<C> o: this.observers){
			//System.out.println("notifico"+ c);
			o.update(c);
		}
	}
	
	

}
