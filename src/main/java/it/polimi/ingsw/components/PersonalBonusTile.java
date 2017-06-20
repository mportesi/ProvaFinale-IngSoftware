package it.polimi.ingsw.components;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.GC_40.Play;
import it.polimi.ingsw.GC_40.Player;
import it.polimi.ingsw.effects.Effect;
import it.polimi.ingsw.effects.GainCoin;
import it.polimi.ingsw.effects.GainFaithPoint;
import it.polimi.ingsw.effects.GainMilitaryPoint;
import it.polimi.ingsw.effects.GainServant;
import it.polimi.ingsw.effects.GainStone;
import it.polimi.ingsw.effects.GainVictoryPoint;
import it.polimi.ingsw.effects.GainVictoryPointForBuildingCard;
import it.polimi.ingsw.effects.GainVictoryPointForCharacterCard;
import it.polimi.ingsw.effects.GainVictoryPointForMilitaryPoint;
import it.polimi.ingsw.effects.GainVictoryPointForTerritoryCard;
import it.polimi.ingsw.effects.GainVictoryPointForVentureCard;
import it.polimi.ingsw.effects.GainWood;


public class PersonalBonusTile implements Serializable{
	private String type;
	private PersonalBonusTileListOfProductionEffect productionEffect;
	private PersonalBonusTileListOfHarvestEffect harvestEffect;
	private int costProduction;
	private int costHarvest;
	ArrayList <Effect> production;
	ArrayList <Effect> harvest;
	
	public PersonalBonusTile (String type, PersonalBonusTileListOfProductionEffect productionEffect, PersonalBonusTileListOfHarvestEffect harvestEffect, int costProduction, int costHarvest) throws FileNotFoundException, IOException, ParseException{
		this.type = type;
		this.costProduction = costProduction;
		this.costHarvest = costHarvest;
		this.harvestEffect=harvestEffect;
		this.productionEffect=productionEffect;
		production = productionEffect.createListOfEffect();
		harvest = harvestEffect.createListOfEffect();
		
	}
	
	
	public void applyProductionEffect(Player player, Play play) throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
	
		for (Effect e : production) {
			if (e != null) {
				e.apply(player, play);
			} else {
				return;
			}
		}
	}
	
	public void applyHarvestEffect(Player player, Play play) throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		

		for (Effect e : harvest) {
			if (e != null) {
				e.apply(player, play);
			} else {
				return;
			}
		}
	}
	
	@Override
	public String toString() {
			return ("PersonalBonusTile of type: " + type + "\n" + "With costProduction: " + costProduction +  "\nWith costHarves: " + costHarvest + "\nWith productionEffect: " + production +"\nWith harvestEffect: " +harvest);
		}
		

	public int getCostHarvest() {
		return costHarvest;
	}

	public int getCostProduction() {
		return costProduction;
	}

	
	

}
