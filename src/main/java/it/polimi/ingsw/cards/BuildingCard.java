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

public class BuildingCard extends Card {
	

	private Map<String, Integer> cost;
	private BuildingListOfEffect effects;
	private ArrayList<Effect> immediateEffects;
	private ArrayList<Effect> permanentEffects;
	private int permanentCost=0;
	private boolean gainPrivilegeCouncil=false;
	
	public BuildingCard(String type, String name, int period, Map<String, Integer> cost, BuildingListOfEffect effects) throws FileNotFoundException, IOException, ParseException {
		super(type, name, period);
		this.cost=cost;
		this.effects=effects;
		immediateEffects = effects.createListOfEffect();
		setGainPrivilegeCouncil();
	}
	
	
	@Override
	public void payCost(Player player, Play play) throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException{
		for(String key: cost.keySet()){
			switch(key){
			case "coin":{
				player.decrementCoin(cost.get(key), play);
			}
			case "wood":{
				player.decrementWood(cost.get(key), play);
			}
			case "stone":{
				player.decrementStone(cost.get(key), play);
			}
			}
		}
	}
	
	// to apply immediate effects
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
			return (name + ":\n The cost is " + cost + "\n The immediate effects are " + immediateEffects );
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