package it.polimi.ingsw.GC_40;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.junit.Test;

import it.polimi.ingsw.colors.ColorDice;
import it.polimi.ingsw.colors.ColorPlayer;
import it.polimi.ingsw.components.Relative;

public class PlayerTest {

	@Test
	public void testRemoveRelative() {
		fail("Not yet implemented");
	}

	@Test
	public void testResourceCounter() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetCoin() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetWood() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetStone() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetServant() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetColor() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetFaithPoint() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetVictoryPoint() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetMilitaryPoint() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetTerritory() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetCharacter() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetBuilding() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetVenture() {
		fail("Not yet implemented");
	}

	@Test
	public void testIncrementCoin() {
		fail("Not yet implemented");
	}

	@Test
	public void testDecrementCoin() {
		fail("Not yet implemented");
	}

	@Test
	public void testIncrementWood() {
		fail("Not yet implemented");
	}

	@Test
	public void testDecrementWood() {
		fail("Not yet implemented");
	}

	@Test
	public void testIncrementStone() {
		fail("Not yet implemented");
	}

	@Test
	public void testDecrementStone() {
		fail("Not yet implemented");
	}

	@Test
	public void testIncrementServant() {
		fail("Not yet implemented");
	}

	@Test
	public void testDecrementServant() {
		fail("Not yet implemented");
	}

	@Test
	public void testIncrementMilitaryPoint() throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		Player player=new Player(null, null, "test", 0);
		Play play=new Play(0);
		player.incrementMilitaryPoint(1, play);
		player.decrementMilitaryPoint(1, play);
		assertEquals(0,player.getMilitaryPoint());
	}

	@Test
	public void testDecrementMilitaryPoint() throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		Player player=new Player(null, null, "test", 0);
		Play play=new Play(0);
		player.incrementMilitaryPoint(1, play);
		player.decrementMilitaryPoint(1, play);
		assertEquals(0,player.getMilitaryPoint());
	}

	@Test
	public void testIncrementFaithPoint() throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		Player player=new Player(null, null, "test", 0);
		Play play=new Play(0);
		player.incrementFaithPoint(1, play);
		assertEquals(1,player.getFaithPoint());
	}

	@Test
	public void testDecrementFaithPoint() throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		Player player=new Player(null, null, "test", 0);
		Play play=new Play(0);
		player.incrementFaithPoint(1, play);
		player.decrementFaithPoint(1, play);
		assertEquals(0,player.getFaithPoint());
	}

	@Test
	public void testIncrementVictoryPoint() throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		Player player=new Player(null, null, "test", 0);
		Play play=new Play(0);
		player.incrementVictoryPoint(1, play);
		assertEquals(1,player.getVictoryPoint());
	}

	@Test
	public void testDecrementVictoryPoint() throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		Player player=new Player(null, null, "test", 0);
		Play play=new Play(0);
		player.incrementVictoryPoint(1, play);
		player.decrementVictoryPoint(1, play);
		assertEquals(0,player.getVictoryPoint());
	}


	@Test
	public void testSetCoin() {
		Player player=new Player(null, null, "test", 0);
		player.setCoin(1);
		assertEquals(1,player.getCoin());
	}

	@Test
	public void testSetWood() {
		Player player=new Player(null, null, "test", 0);
		player.setWood(1);
		assertEquals(1,player.getWood());
	}

	@Test
	public void testSetServant() {
		Player player=new Player(null, null, "test", 0);
		player.setServant(1);
		assertEquals(1,player.getServant());
	}

	@Test
	public void testSetStone() {
		Player player=new Player(null, null, "test", 0);
		player.setStone(1);
		assertEquals(1,player.getStone());
	}

	@Test
	public void testSetMilitaryPoint() {
		Player player=new Player(null, null, "test", 0);
		player.setFaithPoint(1);
		assertEquals(1,player.getFaithPoint());
	}

	@Test
	public void testSetVictoryPoint() {
		Player player=new Player(null, null, "test", 0);
		player.setVictoryPoint(1);
		assertEquals(1,player.getVictoryPoint());
	}

	@Test
	public void testSetFaithPoint() {
		Player player=new Player(null, null, "test", 0);
		player.setFaithPoint(1);
		assertEquals(1,player.getFaithPoint());
	}

	@Test
	public void testSetColor() {
		Player player=new Player(null, null, "test", 0);
		player.setColor(ColorPlayer.BLUE);
		assertEquals(ColorPlayer.BLUE,player.getColor());
	}


	@Test
	public void testGetName() {
		Player player=new Player(null, null, "test", 0);
		assertEquals("test",player.getName());
	}

	@Test
	public void testGetBlackRelative() {
		Player player=new Player(null, null, "test", 0);
		assertEquals(ColorDice.BLACK, player.getBlackRelative().getColor());
	}

	@Test
	public void testGetWhiteRelative() {
		Player player=new Player(null, null, "test", 0);
		assertEquals(ColorDice.WHITE, player.getWhiteRelative().getColor());
	}

	@Test
	public void testGetOrangeRelative() {
		Player player=new Player(null, null, "test", 0);
		assertEquals(ColorDice.ORANGE, player.getOrangeRelative().getColor());
	}

	@Test
	public void testGetNeutralRelative() {
		Player player=new Player(null, null, "test", 0);
		assertEquals(null, player.getNeutralRelative().getColor());
	}

	@Test
	public void testSetOccupiedRelative() throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		Player player=new Player(null, null, "test", 0);
		Relative relative=new Relative(ColorDice.BLACK,player);
		player.setOccupiedRelative(relative);
		assertFalse(player.getBooleanRelative(relative));
	}

	@Test
	public void testGetBooleanRelative() throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		Player player=new Player(null, null, "test", 0);
		Relative relative=new Relative(ColorDice.BLACK,player);
		player.setOccupiedRelative(relative);
		assertFalse(player.getBooleanRelative(relative));
		player.setFreeRelative(relative);
		assertTrue(player.getBooleanRelative(relative));
	}

	@Test
	public void testSetFreeRelative() throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		Player player=new Player(null, null, "test", 0);
		Relative relative=new Relative(ColorDice.BLACK,player);
		player.setOccupiedRelative(relative);
		assertFalse(player.getBooleanRelative(relative));
		player.setFreeRelative(relative);
		assertTrue(player.getBooleanRelative(relative));
	}

	@Test
	public void testSetFreeAllRelatives() {
		Player player=new Player(null, null, "test", 0);
		player.setFreeAllRelatives();
		assertEquals(4,player.getActiveRelatives().size());
		
	}

	@Test
	public void testGetRelative() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetCharCardBonus() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddCharCardBonus() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetCharCardBonus() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetBuildCardBonus() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddBuildCardBonus() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetBuildCardBonus() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetVentCardBonus() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddVentCardBonus() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetVentCardBonus() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetTerrCardBonus() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddTerrCardBonus() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetTerrCardBonus() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetProductionBonus() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddProductionBonus() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetProductionBonus() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetHarvestBonus() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddHarvestBonus() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetHarvestBonus() {
		fail("Not yet implemented");
	}

}
