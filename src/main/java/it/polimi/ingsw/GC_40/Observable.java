package it.polimi.ingsw.GC_40;

import java.util.ArrayList;
import java.util.List;

public abstract class Observable<C> {
	private List<Observer<C>> observers;
	
	public Observable(){
		observers=new ArrayList<Observer<C>>();
	}
	
	public void registerObserver(Observer<C> o){
		observers.add(o);
	}
	
	public void unregisterObserver(Observer<C> o){
		this.observers.remove(o);
	}
	
	public void notifyObserver(){
		for(Observer<C> o: this.observers){
			o.update();
		}
	}
	
	public void notifyObserver(C c){
		for (Observer<C> o: this.observers){
			o.update(c);
		}
	}
	
	

}
