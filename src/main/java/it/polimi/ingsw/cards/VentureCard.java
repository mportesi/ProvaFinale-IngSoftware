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
import it.polimi.ingsw.effects.HasPrivilege;

/**
 * @author Sara
 * This is the subclass of the venture card.
 * This has a difference from the other because it can have two different costs and the player can choose between the two.
 */
public class VentureCard extends Card {
	private int alternativeCostBoolean;
	private Map<String, Integer> cost;
	private int militaryRequirement;
	private int militaryCost;
	private int victoryPoint;
	private VentureListOfEffect effects;
	private ArrayList<Effect> immediateEffects;
	private boolean payAlternativeCost= false;
	private boolean gainPrivilegeCouncil=false;
	
	public VentureCard(String type, String name, int period, int victoryPoint, int militaryCost, int militaryRequirement,
			Map<String, Integer> costMap, VentureListOfEffect effects) throws FileNotFoundException, IOException, ParseException {
		super(type, name, period);
		this.cost = cost;
		this.victoryPoint = victoryPoint;
		this.militaryRequirement = militaryRequirement;
		this.militaryCost = militaryCost;
		this.effects=effects;
		immediateEffects = effects.createListOfEffect();
		alternativeCost=true;
		setGainPrivilegeCouncil();
		
	};

	public VentureCard(String type, String name, int period, int victoryPoint, Map<String, Integer> cost, VentureListOfEffect effects) throws FileNotFoundException, IOException, ParseException {
		super(type, name, period);
		this.cost = cost;
		militaryRequirement = 0;
		this.victoryPoint = victoryPoint;
		militaryCost = 0;
		this.effects = effects;
		immediateEffects = effects.createListOfEffect();
		setGainPrivilegeCouncil();
	}

	public VentureCard(String type, String name, int period, int victoryPoint, int militaryRequirement, Map<String, Integer> cost, VentureListOfEffect effects) throws FileNotFoundException, IOException, ParseException {
		super(type, name, period);
		this.militaryRequirement = militaryRequirement;
		this.militaryCost = militaryCost;
		this.victoryPoint = victoryPoint;
		this.cost = cost;
		cost = null;
		this.effects=effects;
		immediateEffects = effects.createListOfEffect();
		setGainPrivilegeCouncil();
	};

	/**
	 * @author Sara
	 * To pay the required resources when the card is taken by a player
	 */
	@Override
	public void payCost(Player player, Play play) throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		if (militaryRequirement == 0 && militaryCost == 0 || !payAlternativeCost) {
			for (String key : cost.keySet()) {
				switch (key) {
				case "coin": {
					player.decrementCoin(cost.get(key), play);
					break;
				}
				case "wood": {
					player.decrementWood(cost.get(key), play);
					break;
				}
				case "stone": {
					player.decrementStone(cost.get(key), play);
					break;
				}
				case "servant": {
					player.decrementServant(cost.get(key), play);
					break;
				}
				}
			}
		} else if (cost.isEmpty() || payAlternativeCost) {
			player.decrementMilitaryPoint(militaryCost, play);
		}
		return;

	}
	

	@Override
	public String toString(){
		if(alternativeCost && cost!=null){
		return (name + ":\n" + "The cost can be choose: "+ cost +"\n                     "+ "military requirement "+ militaryRequirement + " cost in military point " + militaryCost+  " \nThe immediate effects are " + immediateEffects );}
		else if(militaryRequirement==0 && militaryCost==0){
			return (name + ":\n" + "The cost is: "+ cost +  " \nThe immediate effects are " + immediateEffects );
		}
		else{ return (name + ":\n" + "The militaryRequirement is: " + militaryRequirement + " , the cost in military point is " + militaryCost+  " \nThe immediate effects are " + immediateEffects );}
	}

	/**
	 * @author Sara
	 * To apply immediate effects when a player takes the card
	 */
	@Override
	public void applyEffect(Player player, Play play) throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		
		for (Effect e : immediateEffects) {
			if (e != null) {
				e.apply(player, play);
			}
			return;
		}
	}
	
	/**
	 * @author Sara
	 * To apply the effect gain privilege is necessary to use another method that ask to the player what resource he wants.
	 */
	public void applyPrivilegeBonus(Play play, Player player, String resource) throws InterruptedException{
		try {
			GainPrivilegeCouncil gain= new GainPrivilegeCouncil(resource);
			gain.apply(player, play);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * @author Sara
	 * To set if the player want to pay the military cost.
	 */
	public void chooseCost(boolean choice){
		payAlternativeCost=choice;
	}
	
	public int getCostCoin(){
		if( cost.get("coin")==null){
			return 0;
		}
		return cost.get("coin");
	}
	public int getCostWood(){
		if( cost.get("wood")==null){
			return 0;
		}
		return cost.get("wood");
	}
	public int getCostStone(){
		if( cost.get("stone")==null){
			return 0;
		}
		return cost.get("stone");
	}
	public int getCostServant(){
		if( cost.get("servant")==null){
			return 0;
		}
		return cost.get("servant");
	}
	public int getMilitaryReq(){
		if(cost.get("militaryRequirement")!=null){
			return militaryRequirement;
		}
		return 0;
	}
	public int getMilitaryCost(){
		if( cost.get("militaryCost")==null){
			return 0;
		}
		return militaryCost;
	}
	public boolean isGainPrivilegeCouncil() {
		return gainPrivilegeCouncil;
	}

	public void setGainPrivilegeCouncil() {
		for (Effect e : this.immediateEffects) {
			if (e instanceof HasPrivilege) {
				this.gainPrivilegeCouncil = true;
			}
		}
		
	}
	public boolean getGainPrivilegeCouncil() {
		return gainPrivilegeCouncil;
	}

	public int getVictory() {
		return victoryPoint;
	}
}
