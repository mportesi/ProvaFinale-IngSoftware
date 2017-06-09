package it.polimi.ingsw.cards;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.GC_40.Play;
import it.polimi.ingsw.GC_40.Player;
import it.polimi.ingsw.effects.Effect;

public class VentureCard extends Card {
	private int alternativeCostBoolean;
	private Map<String, Integer> cost;
	private int militaryRequirement;
	private int militaryCost;
	private TerritoryListOfEffect effects;
	private ArrayList<Effect> immediateEffects;
	private boolean payAlternativeCost= false;

	public VentureCard(String type, String name, int period, Map<String, Integer> costMap, int militaryRequirement,
			int militaryCost) {
		super(type, name, period);
		this.cost = cost;
		this.militaryRequirement = militaryRequirement;
		this.militaryCost = militaryCost;
		
	};

	public VentureCard(String type, String name, int period, Map<String, Integer> cost) {
		super(type, name, period);
		this.cost = cost;
		militaryRequirement = 0;
		militaryCost = 0;
	}

	public VentureCard(String type, String name, int period, int militaryRequirement, int militaryCost,
			Map<String, Integer> cost) {
		super(type, name, period);
		this.militaryRequirement = militaryRequirement;
		this.militaryCost = militaryCost;
		this.cost = cost;
		cost = null;
	};

	@Override
	public void payCost(Player player) throws FileNotFoundException, NullPointerException, IOException, ParseException {
		if (militaryRequirement == 0 && militaryCost == 0 || payAlternativeCost == false) {
			for (String key : cost.keySet()) {
				switch (key) {
				case "coin": {
					player.decrementCoin(cost.get(key));
					break;
				}
				case "wood": {
					player.decrementWood(cost.get(key));
					break;
				}
				case "stone": {
					player.decrementStone(cost.get(key));
					break;
				}
				case "servant": {
					player.decrementServant(cost.get(key));
					break;
				}
				}
			}
		} else if (cost.isEmpty() || payAlternativeCost == true) {
			player.decrementMilitaryPoint(militaryCost);
		}
		return;

	}

	// to apply immediate effects
	public void applyEffect(Player player) throws FileNotFoundException, NullPointerException, IOException, ParseException {
		immediateEffects = effects.createListOfEffect();

		for (Effect e : immediateEffects) {
			if (e != null) {
				e.apply(player);
			}
			return;
		}
	}

	/*public String chooseCost(Player player) {
		String chosenCost = "militaryPoint";
		return chosenCost;
	}*/
	
	public void chooseCost(boolean choice){
		payAlternativeCost=choice;
	}
}
