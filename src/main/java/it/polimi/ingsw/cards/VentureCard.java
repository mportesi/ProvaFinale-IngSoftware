package it.polimi.ingsw.cards;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.GC_40.Play;
import it.polimi.ingsw.GC_40.Player;
import it.polimi.ingsw.effects.Effect;
import it.polimi.ingsw.effects.GainPrivilegeCouncil;

public class VentureCard extends Card {
	private int alternativeCostBoolean;
	private Map<String, Integer> cost;
	private int militaryRequirement;
	private int militaryCost;
	private VentureListOfEffect effects;
	private ArrayList<Effect> immediateEffects;
	private boolean payAlternativeCost= false;

	public VentureCard(String type, String name, int period, Map<String, Integer> costMap, int militaryRequirement,
			int militaryCost, VentureListOfEffect effects) throws FileNotFoundException, IOException, ParseException {
		super(type, name, period);
		this.cost = cost;
		this.militaryRequirement = militaryRequirement;
		this.militaryCost = militaryCost;
		this.effects=effects;
		immediateEffects = effects.createListOfEffect();
		alternativeCost=true;
		
	};

	public VentureCard(String type, String name, int period, Map<String, Integer> cost, VentureListOfEffect effects) throws FileNotFoundException, IOException, ParseException {
		super(type, name, period);
		this.cost = cost;
		militaryRequirement = 0;
		militaryCost = 0;
		this.effects = effects;
		immediateEffects = effects.createListOfEffect();
	}

	public VentureCard(String type, String name, int period, int militaryRequirement, int militaryCost,
			Map<String, Integer> cost, VentureListOfEffect effects) throws FileNotFoundException, IOException, ParseException {
		super(type, name, period);
		this.militaryRequirement = militaryRequirement;
		this.militaryCost = militaryCost;
		this.cost = cost;
		cost = null;
		this.effects=effects;
		immediateEffects = effects.createListOfEffect();

	};

	@Override
	
	public void payCost(Player player) throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
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
	

	@Override
	public String toString(){
		return (name + ":\n" + "The cost can be choose: "+ cost +"\n                     "+ "military requirement "+ militaryRequirement + " cost in military point " + militaryCost+  " \nThe immediate effects are " + immediateEffects );
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
	public void applyPrivilegeBonus(Player player, String resource){
		try {
			GainPrivilegeCouncil gain= new GainPrivilegeCouncil(resource);
			gain.apply(player);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*public String chooseCost(Player player) {
		String chosenCost = "militaryPoint";
		return chosenCost;
	}*/
	
	public void chooseCost(boolean choice){
		payAlternativeCost=choice;
	}
	
	public Integer getCostCoin(){
		return cost.get("coin");
	}
	public Integer getCostWood(){
		return cost.get("wood");
	}
	public Integer getCostStone(){
		return cost.get("stone");
	}
	public Integer getCostServant(){
		return cost.get("servant");
	}
	public Integer getMilitaryReq(){
		return militaryRequirement;
	}
	public Integer getMilitaryCost(){
		return militaryCost;
	}
}
