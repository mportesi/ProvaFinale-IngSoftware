package it.polimi.ingsw.components;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.json.simple.parser.ParseException;
import org.junit.Test;

import it.polimi.ingsw.GC_40.Play;
import it.polimi.ingsw.GC_40.Player;
import it.polimi.ingsw.components.PersonalBonusTile;
import it.polimi.ingsw.components.PersonalBonusTileListOfHarvestEffect;
import it.polimi.ingsw.components.PersonalBonusTileListOfProductionEffect;

public class PersonalBonusTileTest {

	@Test
	public void testPersonalBonusTile() throws FileNotFoundException, IOException, ParseException {
		Play play=new Play(0);
		Player player= new Player(null, play, null, 0);
		Map<String,Integer> production=new LinkedHashMap();
		production.put("coin", 1);
		PersonalBonusTileListOfProductionEffect productionTile=new PersonalBonusTileListOfProductionEffect(production);
		Map<String,Integer> harvest=new LinkedHashMap();
		harvest.put("coin", 1);
		PersonalBonusTileListOfHarvestEffect harvestTile=new PersonalBonusTileListOfHarvestEffect(harvest);
		PersonalBonusTile personalSimple=new PersonalBonusTile("test", productionTile, harvestTile, 0, 0);
		assertEquals(0,personalSimple.getCostHarvest());
	}

	@Test
	public void testApplyProductionEffect() throws FileNotFoundException, IOException, ParseException, NullPointerException, InterruptedException {
		Play play=new Play(0);
		Player player= new Player(null, play, null, 0);
		Map<String,Integer> production=new LinkedHashMap();
		production.put("coin", 1);
		PersonalBonusTileListOfProductionEffect productionTile=new PersonalBonusTileListOfProductionEffect(production);
		Map<String,Integer> harvest=new LinkedHashMap();
		harvest.put("coin", 1);
		PersonalBonusTileListOfHarvestEffect harvestTile=new PersonalBonusTileListOfHarvestEffect(harvest);
		PersonalBonusTile personalSimple=new PersonalBonusTile("test", productionTile, harvestTile, 0, 0);
		personalSimple.applyProductionEffect(player, play);
		assertEquals(1,player.getCoin());
	}

	@Test
	public void testApplyHarvestEffect() throws FileNotFoundException, IOException, ParseException, NullPointerException, InterruptedException {
		Play play=new Play(0);
		Player player= new Player(null, play, null, 0);
		Map<String,Integer> production=new LinkedHashMap();
		production.put("coin", 1);
		PersonalBonusTileListOfProductionEffect productionTile=new PersonalBonusTileListOfProductionEffect(production);
		Map<String,Integer> harvest=new LinkedHashMap();
		harvest.put("coin", 1);
		PersonalBonusTileListOfHarvestEffect harvestTile=new PersonalBonusTileListOfHarvestEffect(harvest);
		PersonalBonusTile personalSimple=new PersonalBonusTile("test", productionTile, harvestTile, 0, 0);
		personalSimple.applyHarvestEffect(player, play);
		assertEquals(1,player.getCoin());
	}

	@Test
	public void testGetCostHarvest() throws FileNotFoundException, IOException, ParseException {
		Play play=new Play(0);
		Player player= new Player(null, play, null, 0);
		Map<String,Integer> production=new LinkedHashMap();
		production.put("coin", 1);
		PersonalBonusTileListOfProductionEffect productionTile=new PersonalBonusTileListOfProductionEffect(production);
		Map<String,Integer> harvest=new LinkedHashMap();
		harvest.put("coin", 1);
		PersonalBonusTileListOfHarvestEffect harvestTile=new PersonalBonusTileListOfHarvestEffect(harvest);
		PersonalBonusTile personalSimple=new PersonalBonusTile("test", productionTile, harvestTile, 0, 0);
		assertEquals(0,personalSimple.getCostHarvest());
	}

	@Test
	public void testGetCostProduction() throws FileNotFoundException, IOException, ParseException {
		Play play=new Play(0);
		Player player= new Player(null, play, null, 0);
		Map<String,Integer> production=new LinkedHashMap();
		production.put("coin", 1);
		PersonalBonusTileListOfProductionEffect productionTile=new PersonalBonusTileListOfProductionEffect(production);
		Map<String,Integer> harvest=new LinkedHashMap();
		harvest.put("coin", 1);
		PersonalBonusTileListOfHarvestEffect harvestTile=new PersonalBonusTileListOfHarvestEffect(harvest);
		PersonalBonusTile personalSimple=new PersonalBonusTile("test", productionTile, harvestTile, 0, 0);
		assertEquals(0,personalSimple.getCostProduction());
	}

}
