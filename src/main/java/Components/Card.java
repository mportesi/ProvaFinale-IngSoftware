package Components;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import Effects.Effect;

public class Card {
	protected String type;
	protected String name;
	protected Long period;
	protected Map<String, Long> immediateEffect;
	protected List<Effect> permanentEffect;
	
	
	
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
