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
		Player player=new Player(null, null, "test", 0);
		Relative relativeB=new Relative(ColorDice.BLACK, player);
		Relative relativeW=new Relative(ColorDice.WHITE, player);
		Relative relativeO=new Relative(ColorDice.ORANGE, player);
		Relative relativeN=new Relative(null, player);
		player.removeRelative(relativeB);
		player.removeRelative(relativeW);
		player.removeRelative(relativeO);
		player.removeRelative(relativeN);
		assertEquals(0, player.getActiveRelatives().size());
	}

	@Test
	public void testResourceCounter() throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		Player player=new Player(null, null, "test", 0);
		Play play=new Play(0);
		player.incrementCoin(1, play);
		player.incrementWood(1, play);
		player.incrementStone(1, play);
		player.incrementServant(1, play);
		assertEquals(4,player.resourceCounter());
	}

	@Test
	public void testGetCoin() throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		Player player=new Player(null, null, "test", 0);
		Play play=new Play(0);
		player.incrementCoin(1, play);
		assertEquals(1,player.getCoin());
	}

	@Test
	public void testGetWood() throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		Player player=new Player(null, null, "test", 0);
		Play play=new Play(0);
		player.incrementWood(1, play);
		assertEquals(1,player.getWood());
	}

	@Test
	public void testGetStone() throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		Player player=new Player(null, null, "test", 0);
		Play play=new Play(0);
		player.incrementStone(1, play);
		assertEquals(1,player.getStone());
	}

	@Test
	public void testGetServant() throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		Player player=new Player(null, null, "test", 0);
		Play play=new Play(0);
		player.incrementServant(1, play);
		assertEquals(1,player.getServant());
	}

	@Test
	public void testGetColor() {
		Player player=new Player(null, null, "test", 0);
		player.setColor(ColorPlayer.BLUE);
		assertEquals(ColorPlayer.BLUE,player.getColor());
	}

	@Test
	public void testGetFaithPoint() throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		Player player=new Player(null, null, "test", 0);
		Play play=new Play(0);
		player.incrementFaithPoint(1, play);
		assertEquals(1,player.getFaithPoint());
	}

	@Test
	public void testGetVictoryPoint() throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		Player player=new Player(null, null, "test", 0);
		Play play=new Play(0);
		player.incrementVictoryPoint(1, play);
		assertEquals(1,player.getVictoryPoint());
	}

	@Test
	public void testGetMilitaryPoint() throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		Player player=new Player(null, null, "test", 0);
		Play play=new Play(0);
		player.incrementMilitaryPoint(1, play);
		player.decrementMilitaryPoint(1, play);
		assertEquals(0,player.getMilitaryPoint());
	}

	@Test
	public void testIncrementCoin() throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		Player player=new Player(null, null, "test", 0);
		Play play=new Play(0);
		player.incrementCoin(1, play);
		assertEquals(1,player.getCoin());
	}

	@Test
	public void testDecrementCoin() throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		Player player=new Player(null, null, "test", 0);
		Play play=new Play(0);
		player.incrementCoin(1, play);
		player.decrementCoin(1, play);
		assertEquals(0,player.getCoin());
	}

	@Test
	public void testIncrementWood() throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		Player player=new Player(null, null, "test", 0);
		Play play=new Play(0);
		player.incrementWood(1, play);
		assertEquals(1,player.getWood());
	}

	@Test
	public void testDecrementWood() throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		Player player=new Player(null, null, "test", 0);
		Play play=new Play(0);
		player.incrementWood(1, play);
		player.decrementWood(1, play);
		assertEquals(0,player.getWood());
	}

	@Test
	public void testIncrementStone() throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		Player player=new Player(null, null, "test", 0);
		Play play=new Play(0);
		player.incrementStone(1, play);
		assertEquals(1,player.getStone());
	}

	@Test
	public void testDecrementStone() throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		Player player=new Player(null, null, "test", 0);
		Play play=new Play(0);
		player.incrementStone(1, play);
		player.decrementStone(1, play);
		assertEquals(0,player.getStone());
	}

	@Test
	public void testIncrementServant() throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		Player player=new Player(null, null, "test", 0);
		Play play=new Play(0);
		player.incrementServant(1, play);
		assertEquals(1,player.getServant());
	}

	@Test
	public void testDecrementServant() throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		Player player=new Player(null, null, "test", 0);
		Play play=new Play(0);
		player.incrementServant(1, play);
		player.decrementServant(1, play);
		assertEquals(0,player.getServant());
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
		Player player=new Player(null, null, "test",0);
		assertEquals(ColorDice.BLACK,player.getBlackRelative().getColor());
	}

	@Test
	public void testGetCharCardBonus() throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		Player player=new Player(null, null, "test", 0);
		Play play=new Play(0);
		player.addCharCardBonus(1,play);
		assertEquals(1,player.getCharCardBonus());
	}

	@Test
	public void testAddCharCardBonus() throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		Player player=new Player(null, null, "test", 0);
		Play play=new Play(0);
		player.addCharCardBonus(1,play);
		assertEquals(1,player.getCharCardBonus());
	}

	@Test
	public void testSetCharCardBonus() {
		Player player=new Player(null, null, "test", 0);
		player.setCharCardBonus(1);
		assertEquals(1,player.getCharCardBonus());
	}

	@Test
	public void testGetBuildCardBonus() throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		Player player=new Player(null, null, "test", 0);
		Play play=new Play(0);
		player.addBuildCardBonus(1,play);
		assertEquals(1,player.getBuildCardBonus());
	}

	@Test
	public void testAddBuildCardBonus() throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		Player player=new Player(null, null, "test", 0);
		Play play=new Play(0);
		player.addBuildCardBonus(1,play);
		assertEquals(1,player.getBuildCardBonus());
	}

	@Test
	public void testSetBuildCardBonus() {
		Player player=new Player(null, null, "test", 0);
		player.setBuildCardBonus(1);
		assertEquals(1,player.getBuildCardBonus());
	}

	@Test
	public void testGetVentCardBonus() throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		Player player=new Player(null, null, "test", 0);
		Play play=new Play(0);
		player.addVentCardBonus(1,play);
		assertEquals(1,player.getVentCardBonus());
	}

	@Test
	public void testAddVentCardBonus() throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		Player player=new Player(null, null, "test", 0);
		Play play=new Play(0);
		player.addVentCardBonus(1,play);
		assertEquals(1,player.getVentCardBonus());
	}

	@Test
	public void testSetVentCardBonus() {
		Player player=new Player(null, null, "test", 0);
		player.setVentCardBonus(1);
		assertEquals(1,player.getVentCardBonus());
	}

	@Test
	public void testGetTerrCardBonus() throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		Player player=new Player(null, null, "test", 0);
		Play play=new Play(0);
		player.addTerrCardBonus(1,play);
		assertEquals(1,player.getTerrCardBonus());
	}

	@Test
	public void testAddTerrCardBonus() throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		Player player=new Player(null, null, "test", 0);
		Play play=new Play(0);
		player.addTerrCardBonus(1,play);
		assertEquals(1,player.getTerrCardBonus());
	}

	@Test
	public void testSetTerrCardBonus() {
		Player player=new Player(null, null, "test", 0);
		player.setTerrCardBonus(1);
		assertEquals(1,player.getTerrCardBonus());
	}

	@Test
	public void testGetProductionBonus() throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		Player player=new Player(null, null, "test", 0);
		Play play=new Play(0);
		player.addProductionBonus(1,play);
		assertEquals(1,player.getProductionBonus());
	}

	@Test
	public void testAddProductionBonus() throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		Player player=new Player(null, null, "test", 0);
		Play play=new Play(0);
		player.addProductionBonus(1,play);
		assertEquals(1,player.getProductionBonus());
	}

	@Test
	public void testSetProductionBonus() {
		Player player=new Player(null, null, "test", 0);
		player.setProductionBonus(1);
		assertEquals(1,player.getProductionBonus());
	}

	@Test
	public void testGetHarvestBonus() throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		Player player=new Player(null, null, "test", 0);
		Play play=new Play(0);
		player.addHarvestBonus(1,play);
		assertEquals(1,player.getHarvestBonus());
	}

	@Test
	public void testAddHarvestBonus() throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		Player player=new Player(null, null, "test", 0);
		Play play=new Play(0);
		player.addHarvestBonus(1,play);
		assertEquals(1,player.getHarvestBonus());
	}

	@Test
	public void testSetHarvestBonus() throws FileNotFoundException, NullPointerException, IOException, ParseException {
		Player player=new Player(null, null, "test", 0);
		player.setHarvestBonus(1);
		assertEquals(1,player.getHarvestBonus());
	}

}
