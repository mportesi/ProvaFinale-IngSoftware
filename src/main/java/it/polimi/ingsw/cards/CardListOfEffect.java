package it.polimi.ingsw.cards;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;

import it.polimi.ingsw.effects.Effect;

public abstract class CardListOfEffect implements Serializable{
	protected Map<String, Integer> immediateEffect;
	
	public CardListOfEffect(Map<String, Integer> immediateEffect){
		this.immediateEffect=immediateEffect;
	}
	
	public abstract ArrayList<Effect> createListOfEffect();

}
