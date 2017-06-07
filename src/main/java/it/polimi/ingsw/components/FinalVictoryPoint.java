package it.polimi.ingsw.components;

import java.util.Map;

public class FinalVictoryPoint {
	String type;
	Map <Integer, Integer> amountForObject;
	
	public FinalVictoryPoint (String type, Map amountForObject){
		this.type = type;
		this.amountForObject = amountForObject;
	}

	public String getType() {
		// TODO Auto-generated method stub
		return type;
	}
}
