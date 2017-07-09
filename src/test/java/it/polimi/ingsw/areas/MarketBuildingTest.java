package it.polimi.ingsw.areas;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.json.simple.parser.ParseException;
import org.junit.Test;

import it.polimi.ingsw.GC_40.Play;
import it.polimi.ingsw.GC_40.Player;
import it.polimi.ingsw.components.Relative;
import it.polimi.ingsw.effects.GainCoin;

public class MarketBuildingTest {

	@Test
	public void testGetType() throws FileNotFoundException, IOException, ParseException {
		MarketBuilding market=new MarketBuilding("market1", null, 0);
		assertEquals("market1", market.getType());
	}

	@Test
	public void testApplyEffect() throws FileNotFoundException, IOException, ParseException, NullPointerException, InterruptedException {
		Map <String, Integer> bonusMap=new LinkedHashMap();
		bonusMap.put("coin", 1);
		MarketListOfEffect effect=new MarketListOfEffect(bonusMap);
		MarketBuilding market=new MarketBuilding("market1", effect, 0);
		Play play= new Play(0);
		Player player=new Player(null, play, "test", 0);
		market.applyEffect(player, play);
		assertEquals(1, player.getCoin());
	}

	@Test
	public void testIsOccupied() throws FileNotFoundException, IOException, ParseException, NullPointerException, InterruptedException {
		Map <String, Integer> bonusMap=new LinkedHashMap();
		bonusMap.put("coin", 1);
		MarketListOfEffect effect=new MarketListOfEffect(bonusMap);
		MarketBuilding market=new MarketBuilding("market1", effect, 0);
		Relative relative = new Relative(null, null);
		Player player = new Player(null, null, null, 0);
		assertFalse(market.isOccupied());
		market.setOccupied(player, relative, market);
		assertTrue(market.isOccupied());
		
	}

	@Test
	public void testGetCost() {
		Map <String, Integer> bonusMap=new LinkedHashMap();
		bonusMap.put("coin", 1);
		MarketListOfEffect effect=new MarketListOfEffect(bonusMap);
		MarketBuilding market=new MarketBuilding("market1", effect, 0);
		assertEquals(0,market.getCost());
	}

	@Test
	public void testSetOccupied() throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		Map <String, Integer> bonusMap=new LinkedHashMap();
		bonusMap.put("coin", 1);
		MarketListOfEffect effect=new MarketListOfEffect(bonusMap);
		MarketBuilding market=new MarketBuilding("market1", effect, 0);
		Relative relative = new Relative(null, null);
		Player player = new Player(null, null, null, 0);
		assertFalse(market.isOccupied());
		market.setOccupied(player, relative, market);
		assertTrue(market.isOccupied());
	}

	@Test
	public void testSetFree() throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		Map <String, Integer> bonusMap=new LinkedHashMap();
		bonusMap.put("coin", 1);
		MarketListOfEffect effect=new MarketListOfEffect(bonusMap);
		MarketBuilding market=new MarketBuilding("market1", effect, 0);
		Relative relative = new Relative(null, null);
		Player player = new Player(null, null, null, 0);
		assertFalse(market.isOccupied());
		market.setOccupied(player, relative, market);
		assertTrue(market.isOccupied());
		market.setFree();
		assertFalse(market.isOccupied());
	}

	@Test
	public void testSetPlayer() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetPlayer() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetRelative() {
		fail("Not yet implemented");
	}

}
