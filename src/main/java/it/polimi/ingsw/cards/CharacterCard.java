package it.polimi.ingsw.cards;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.GC_40.Board;
import it.polimi.ingsw.GC_40.Player;
import it.polimi.ingsw.areas.Floor;
import it.polimi.ingsw.areas.Tower;
import it.polimi.ingsw.effects.Effect;
import it.polimi.ingsw.effects.GainCoin;
import it.polimi.ingsw.effects.GainFaithPoint;
import it.polimi.ingsw.effects.GainMilitaryPoint;
import it.polimi.ingsw.effects.GainStone;
import it.polimi.ingsw.effects.GainVictoryPoint;
import it.polimi.ingsw.effects.GainVictoryPointForBuildingCard;
import it.polimi.ingsw.effects.GainVictoryPointForCharacterCard;
import it.polimi.ingsw.effects.GainVictoryPointForMilitaryPoint;
import it.polimi.ingsw.effects.GainVictoryPointForTerritoryCard;
import it.polimi.ingsw.effects.GainVictoryPointForVentureCard;
import it.polimi.ingsw.effects.GainWood;
import it.polimi.ingsw.effects.*;

public class CharacterCard extends Card {
	private int costCoin;
	private String card;
	private int value;
	private Map<String, Integer> discount;
	private CharacterListOfEffect effects;
	private ArrayList<Effect> immediateEffects;

	public CharacterCard(String type, String name, int period, int costCoin, CharacterListOfEffect effects) throws FileNotFoundException, IOException, ParseException {
		super(type, name, period);
		this.costCoin = costCoin;
		this.effects=effects;
		immediateEffects = effects.createListOfEffect();
	}

	public CharacterCard(String type, String name, int period, int costCoin, String card, int value,
			Map<String, Integer> discount, CharacterListOfEffect effects) throws FileNotFoundException, IOException, ParseException {
		super(type, name, period);
		this.costCoin = costCoin;
		this.card = card;
		this.value = value;
		this.discount = discount;
		this.effects=effects;
		immediateEffects = effects.createListOfEffect();
	}

	@Override
	public void payCost(Player player) throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		player.decrementCoin(costCoin);
	}
	
	@Override
	public String toString(){
		return (name + ":\n" + "Il costo è "+ costCoin +"\n"+ "Gli effetti immediati sono " + immediateEffects );
	}
	
	// to apply immediate effects
	public void applyEffect(Player player) throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		

		for (Effect e : immediateEffects) {
			if (e != null) {
				e.apply(player);
			}
			return;
		}
	}
}