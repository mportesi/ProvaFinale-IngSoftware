package it.polimi.ingsw.cards;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.effects.Effect;

/**
 * @author Sara
 * This is the interface for auxiliary classes that creates the list of effects for the cards
 */
public abstract class CreateListOfEffect implements Serializable{
	protected transient Map<String, Integer> immediateEffect;
	
	public CreateListOfEffect(Map<String, Integer> immediateEffect){
		this.immediateEffect=immediateEffect;
	}
	public CreateListOfEffect(){
		
	}
	public abstract ArrayList<Effect> createListOfEffect() throws FileNotFoundException, IOException, ParseException;

}
