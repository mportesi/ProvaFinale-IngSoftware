package it.polimi.ingsw.components;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import org.json.simple.parser.ParseException;
import org.junit.Test;

import it.polimi.ingsw.GC_40.Play;
import it.polimi.ingsw.GC_40.Player;
import it.polimi.ingsw.components.PersonalBonusTileListOfHarvestEffect;
import it.polimi.ingsw.effects.Effect;
import it.polimi.ingsw.effects.GainCoin;

public class PersonalBonusTileListOfHarvestEffectTest {

	@Test
	public void testCreateListOfEffect() throws FileNotFoundException, IOException, ParseException {
		Play play=new Play(0);
		Player player= new Player(null, play, null, 0);
		Map<String,Integer> harvest=new LinkedHashMap();
		harvest.put("coin", 1);
		PersonalBonusTileListOfHarvestEffect harvestTile=new PersonalBonusTileListOfHarvestEffect(harvest);
		ArrayList <Effect> harvestList=harvestTile.createListOfEffect();
		assertTrue(harvestList.get(0) instanceof GainCoin);
	}

	@Test
	public void testPersonalBonusTileListOfHarvestEffect() throws FileNotFoundException, IOException, ParseException {
		Play play=new Play(0);
		Player player= new Player(null, play, null, 0);
		Map<String,Integer> harvest=new LinkedHashMap();
		harvest.put("coin", 1);
		PersonalBonusTileListOfHarvestEffect harvestTile=new PersonalBonusTileListOfHarvestEffect(harvest);
		ArrayList <Effect> harvestList=harvestTile.createListOfEffect();
		assertEquals(1,harvestList.size());
	}

}
