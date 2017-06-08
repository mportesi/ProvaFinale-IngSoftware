package it.polimi.ingsw.cards;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import it.polimi.ingsw.GC_40.Player;
import it.polimi.ingsw.client.CommandLineInterface;
import it.polimi.ingsw.components.PrivilegeCouncil;
import it.polimi.ingsw.effects.Effect;
import it.polimi.ingsw.effects.GainCoin;
import it.polimi.ingsw.effects.GainFaithPoint;
import it.polimi.ingsw.effects.GainMilitaryPoint;
import it.polimi.ingsw.effects.GainPrivilegeCouncil;
import it.polimi.ingsw.effects.GainServant;
import it.polimi.ingsw.effects.GainStone;
import it.polimi.ingsw.effects.GainVictoryPoint;
import it.polimi.ingsw.effects.GainVictoryPointForBuildingCard;
import it.polimi.ingsw.effects.GainVictoryPointForCharacterCard;
import it.polimi.ingsw.effects.GainVictoryPointForMilitaryPoint;
import it.polimi.ingsw.effects.GainVictoryPointForTerritoryCard;
import it.polimi.ingsw.effects.GainVictoryPointForVentureCard;
import it.polimi.ingsw.effects.GainWood;

public class Card {
	protected String type;
	protected String name;
	protected int period;
	
	
	public Card(String type, String name, int period){
		this.type=type;
		this.name=name;
		this.period=period;
	}

	// to apply immediate effects
	public void applyEffect(Player player) {
	};

	public void payCost(Player player) {
	};

	public String getType() {
		return type;
	};

	public String getName() {
		return name;
	}

	public int getPeriod() {
		return period;
	}

}