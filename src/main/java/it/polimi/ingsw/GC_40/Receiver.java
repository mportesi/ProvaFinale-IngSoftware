package it.polimi.ingsw.GC_40;

public class Receiver {
	
	public void putRelativeOnTower(Relative r, Tower t, Floor f){
		
		PutRelative.isApplicable();
		
		Card card= t.f.giveCard(); //in give card metteremo card nel player
		
		Card.immediateEffect();
	}

}
