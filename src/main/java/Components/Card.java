package Components;

import java.util.ArrayList;
import java.util.List;

import Effects.Effect;

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
