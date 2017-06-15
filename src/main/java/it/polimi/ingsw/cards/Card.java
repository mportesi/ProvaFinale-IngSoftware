package it.polimi.ingsw.cards;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.GC_40.Play;
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

public class Card implements Serializable {
	protected String type;
	protected String name;
	protected int period;
	protected boolean gainPrivilegeCouncil; //TODO
	protected boolean getCard;
	protected boolean alternativeCost;
	
	
	public Card(String type, String name, int period){
		this.type=type;
		this.name=name;
		this.period=period;
	}

	// to apply immediate effects
	public void applyEffect(Player player, Play play) throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
	};

	public void payCost(Player player, Play play) throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
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
	public void chooseCost(boolean cost){
		//for venture card
	}
	public void applyPrivilegeBonus(Player player,String resource){
	}

	public boolean getGainPrivilegeCouncil() {
		return gainPrivilegeCouncil;
	}

	public boolean getGetCard() {
		return getCard;
	}

	public boolean getAlternativeCost() {
		return alternativeCost;
	}

	public void applyPrivilegeBonus(Play play, Player player, String bonus) {
		// TODO Auto-generated method stub
		
	}

	
}