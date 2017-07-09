package it.polimi.ingsw.areas;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import org.json.simple.parser.ParseException;
import org.junit.Test;

import it.polimi.ingsw.effects.Effect;
import it.polimi.ingsw.effects.GainCoin;

public class MarketListOfEffectTest {

	@Test
	public void testCreateListOfEffect() throws FileNotFoundException, IOException, ParseException {
		Map <String, Integer> bonusMap=new LinkedHashMap();
		bonusMap.put("coin", 1);
		MarketListOfEffect effect=new MarketListOfEffect(bonusMap);
		ArrayList<Effect> testList=effect.createListOfEffect();
		assertTrue(testList.get(0) instanceof GainCoin);
	}

}
