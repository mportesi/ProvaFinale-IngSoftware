package it.polimi.ingsw.cards;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.effects.Effect;

public abstract class CreateListOfEffect implements Serializable{
	protected Map<String, Integer> immediateEffect;
	
	public CreateListOfEffect(Map<String, Integer> immediateEffect){
		this.immediateEffect=immediateEffect;
	}
	
	public abstract ArrayList<Effect> createListOfEffect() throws FileNotFoundException, IOException, ParseException;

}
