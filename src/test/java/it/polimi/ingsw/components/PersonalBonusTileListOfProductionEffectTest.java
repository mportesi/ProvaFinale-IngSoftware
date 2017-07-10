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
import it.polimi.ingsw.components.PersonalBonusTileListOfProductionEffect;
import it.polimi.ingsw.effects.Effect;
import it.polimi.ingsw.effects.GainCoin;

public class PersonalBonusTileListOfProductionEffectTest {

	@Test
	public void testCreateListOfEffect() throws FileNotFoundException, NullPointerException, IOException, ParseException {
		Play play=new Play(0);
		Player player= new Player(null, play, null, 0);
		Map<String,Integer> production=new LinkedHashMap();
		production.put("coin", 1);
		PersonalBonusTileListOfProductionEffect productionTile=new PersonalBonusTileListOfProductionEffect(production);
		ArrayList <Effect> productionList=productionTile.createListOfEffect();
		assertTrue(productionList.get(0) instanceof GainCoin);
	}

	@Test
	public void testPersonalBonusTileListOfProductionEffect() throws FileNotFoundException, NullPointerException, IOException, ParseException {
		Play play=new Play(0);
		Player player= new Player(null, play, null, 0);
		Map<String,Integer> production=new LinkedHashMap();
		production.put("coin", 1);
		PersonalBonusTileListOfProductionEffect productionTile=new PersonalBonusTileListOfProductionEffect(production);
		ArrayList <Effect> productionList=productionTile.createListOfEffect();
		assertEquals(1,productionList.size());
	}

}
