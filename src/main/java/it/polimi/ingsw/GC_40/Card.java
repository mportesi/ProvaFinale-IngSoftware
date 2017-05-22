package it.polimi.ingsw.GC_40;

import java.util.ArrayList;
import java.util.List;

public class Card {
	private String type;
	private String name;
	private int period;
	private List<Effect> immediateEffects;
	private List<Effect> permanentEffects;
	
	public void applyEffect(){
		for (Effect e: immediateEffects){
			e.apply();
		}
	}
	

	public String getType(){
		return type;
	};
	
	public String getName(){
		return name;
	}
	
	public int getPeriod(){
		return period;
	}
	
	

}
