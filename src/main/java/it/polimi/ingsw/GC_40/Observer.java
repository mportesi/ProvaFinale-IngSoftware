package it.polimi.ingsw.GC_40;

import it.polimi.ingsw.actions.PutRelative;

public interface Observer<C> {
	
	
	public default void update(C change){
		
	};
	
	public abstract void update();

	


	

}
