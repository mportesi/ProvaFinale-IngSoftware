package it.polimi.ingsw.cards;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.GC_40.Play;
import it.polimi.ingsw.GC_40.Player;
import it.polimi.ingsw.effects.Effect;
import it.polimi.ingsw.effects.HasPrivilege;

/**
 * @author Sara
 * This is the subclass of the building card
 */
public class BuildingCard extends Card {
	
	private Map<String, Integer> cost;
	private BuildingListOfEffect effects;
	private BuildingListOfPermanentEffect permanent;
	private ArrayList<Effect> immediateEffects;
	private ArrayList<Effect> permanentEffects;
	private int permanentCost=0;
	private boolean gainPrivilegeCouncil=false;
	
	public BuildingCard(String type, String name, int period, Map<String, Integer> cost, BuildingListOfEffect effects, BuildingListOfPermanentEffect permanent) throws FileNotFoundException, IOException, ParseException {
		super(type, name, period);
		this.cost=cost;
		this.effects=effects;
		this.permanent=permanent;
		immediateEffects = effects.createListOfEffect();
		permanentEffects= permanent.createListOfEffect();
		setGainPrivilegeCouncil();
	}
	
	public BuildingCard(String type, String name, int period, Map<String, Integer> cost, BuildingListOfEffect effects, BuildingListOfPermanentEffect permanent, int permanentCost) throws FileNotFoundException, IOException, ParseException {
		super(type, name, period);
		this.cost=cost;
		this.permanentCost=permanentCost;
		this.effects=effects;
		this.permanent=permanent;
		immediateEffects = effects.createListOfEffect();
		permanentEffects= permanent.createListOfEffect();
		setGainPrivilegeCouncil();
	}
	
	/**
	 * @author Sara
	 * To pay the required resources when the card is taken by a player
	 */
	@Override
	public void payCost(Player player, Play play) throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException{
		for(String key: cost.keySet()){
			switch(key){
			case "coin":{
				player.decrementCoin(cost.get(key), play);
				break;
			}
			case "wood":{
				player.decrementWood(cost.get(key), play);
				break;
			}
			case "stone":{
				player.decrementStone(cost.get(key), play);
				break;
			}
			}
		}
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
		

		@Override
		public String toString(){
			return (name + ":\n The cost is " + cost + "\n The immediate effects are " + immediateEffects + "\n The permanent effects are " + permanentEffects);
		}
		
		public int getCostCoin(){
			if(cost.get("coin")==null){
				return 0;
			}
			return  cost.get("coin");
		}
		public int getCostWood(){
			if(cost.get("wood")==null){
				return 0;
			}
			return  cost.get("wood");
		}
		public int getCostStone(){
			if(cost.get("stone")==null){
				return 0;
			}
			return  cost.get("stone");
		}
		public int getCostServant(){
			if(cost.get("servant")==null){
				return 0;
			}
			return cost.get("servant");
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
		
		public int getPermanentCost(){
			return permanentCost;
		}
		
		public ArrayList<Effect> getPermanentEffect(){
			return permanentEffects;
		}
}