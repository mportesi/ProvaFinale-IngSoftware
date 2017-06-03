package it.polimi.ingsw.GC_40;


public interface Observer<C> {
	
	
	public default void update(C change){
		
	};
	
	public abstract void update();

	

}
