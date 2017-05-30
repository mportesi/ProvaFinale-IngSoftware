package it.polimi.ingsw.components;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import it.polimi.ingsw.GC_40.Player;
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

public class MarketBuilding extends Market {
	//private Piece bonus;
	private String type;
	private Map<String,Integer> bonus;
	private boolean isOccupied;
	private int cost;
	private List<Effect> marketEffect;
	
	public void createListOfMarketEffect(){
		marketEffect = new ArrayList<Effect>();
		List<String> keys = new ArrayList<String>();
		for (String key : bonus.keySet()) {
			keys.add(key);
		}
		for (int i = 0; i < keys.size(); i++) {
			String effect = keys.get(i);
			int bonusEffect = bonus.get(effect);
			switch (effect) {
			case "coin": {
				GainCoin gainCoin = new GainCoin(bonusEffect);
				marketEffect.add(gainCoin);
				break;
			}
			
			case "privilegeCouncil": {
				GainPrivilegeCouncil gainPrivilegeCouncil = new GainPrivilegeCouncil(bonusEffect);
				marketEffect.add(gainPrivilegeCouncil);
				break;
			}
			case "servant": {
				GainServant gainServant = new GainServant(bonusEffect);
				marketEffect.add(gainServant);
				break;
			}
			
			case "militaryPoint": {
				GainMilitaryPoint gainMilitaryPoint = new GainMilitaryPoint(bonusEffect);
				marketEffect.add(gainMilitaryPoint);
				break;
			}
			}
		}
	}
	
	public void applyEffect(Player player) {
		createListOfMarketEffect();

		for (Effect e : marketEffect) {
			if (e != null) {
				e.apply(player);
			} else {
				return;
			}
		}
	}

	

	/*public Piece getBonus() {
		return bonus;
	}*/

	public boolean IsOccupied() {
		return isOccupied;
	}

	public int getCost() {
		return cost;
	}
	
	public MarketBuilding (String type, Map<String,Integer> bonus, int cost){
		this.type=type;
		this.bonus=bonus;
		this.cost=cost;
	}

	// when a player put a relative, he receive a bonus
	/*public void giveBonus(Player player, MarketBuilding market) {
		if (market.equals(market1)) {
			player.incrementCoin(5);
		}
		if (market.equals(market2)) {
			player.incrementServant(5);
		}
		if (market.equals(market3)) {
			player.incrementMilitaryPoint(3);
			player.incrementCoin(2);
		}
		if (market.equals(market4)) {
			GainPrivilegeCouncil gainPrivilegeCouncil = new GainPrivilegeCouncil(2);
			gainPrivilegeCouncil.apply(player);
		}

	}*/

	public void setOccupied() {
		isOccupied = true;
	}

	public void setFree() {
		isOccupied = false;
	}
}
