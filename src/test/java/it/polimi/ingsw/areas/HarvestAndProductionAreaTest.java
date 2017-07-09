package it.polimi.ingsw.areas;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.junit.Test;

import it.polimi.ingsw.GC_40.Player;
import it.polimi.ingsw.colors.ColorDice;
import it.polimi.ingsw.components.Relative;

public class HarvestAndProductionAreaTest {

	@Test
	public void testIsAlreadyPresent() throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		HarvestAndProductionArea area=new HarvestAndProductionArea("harvest",1,1,0);
		Player player=new Player(null, null, null, 0);
		assertFalse(area.isAlreadyPresent(player));
		Relative relative=new Relative(ColorDice.BLACK, player);
		area.setRightRelativeOnHarvest(relative);
		assertTrue(area.isAlreadyPresent(player));
	}

	@Test
	public void testGetLeftRelative() throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		HarvestAndProductionArea area=new HarvestAndProductionArea("harvest",1,1,0);
		Relative relative=new Relative(ColorDice.BLACK, null);
		area.setLeftRelativeOnHarvest(relative);
		assertEquals(ColorDice.BLACK, area.getLeftRelative().getColor());
	}

	@Test
	public void testGetRightRelatives() throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		HarvestAndProductionArea area=new HarvestAndProductionArea("harvest",1,1,0);
		Relative relative=new Relative(ColorDice.BLACK, null);
		area.setRightRelativeOnHarvest(relative);
		assertEquals(ColorDice.BLACK, area.getRightRelatives().get(0).getColor());
	}

	@Test
	public void testSetLeftRelativeOnHarvest() throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		HarvestAndProductionArea area=new HarvestAndProductionArea("harvest",1,1,0);
		Relative relative=new Relative(ColorDice.BLACK, null);
		area.setLeftRelativeOnHarvest(relative);
		assertEquals(ColorDice.BLACK, area.getLeftRelative().getColor());
	}

	@Test
	public void testSetLeftRelativeOnProduction() throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		HarvestAndProductionArea area=new HarvestAndProductionArea("harvest",1,1,0);
		Relative relative=new Relative(ColorDice.WHITE, null);
		area.setLeftRelativeOnProduction(relative);
		assertEquals(ColorDice.WHITE, area.getLeftRelative().getColor());
	}

	@Test
	public void testSetRightRelativeOnHarvest() throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		HarvestAndProductionArea area=new HarvestAndProductionArea("harvest",1,1,0);
		Relative relative=new Relative(ColorDice.BLACK, null);
		area.setRightRelativeOnHarvest(relative);
		assertEquals(ColorDice.BLACK, area.getRightRelatives().get(0).getColor());
	}

	@Test
	public void testSetRightRelativeOnProduction() throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		HarvestAndProductionArea area=new HarvestAndProductionArea("harvest",1,1,0);
		Relative relative=new Relative(ColorDice.WHITE, null);
		area.setRightRelativeOnProduction(relative);
		assertEquals(ColorDice.WHITE, area.getRightRelatives().get(0).getColor());
	}

	@Test
	public void testGetValueOfLeftArea() {
		HarvestAndProductionArea area=new HarvestAndProductionArea("harvest",1,1,0);
		assertEquals(1,area.getValueOfLeftArea());
	}

	@Test
	public void testGetMalus() {
		HarvestAndProductionArea area=new HarvestAndProductionArea("harvest",1,1,0);
		assertEquals(0,area.getMalus());
	}

	@Test
	public void testGetType() {
		HarvestAndProductionArea area=new HarvestAndProductionArea("harvest",1,1,0);
		assertEquals("harvest",area.getType());
	}

	@Test
	public void testRefresh() throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		HarvestAndProductionArea area=new HarvestAndProductionArea("harvest",1,1,0);
		Relative relative=new Relative(ColorDice.BLACK, null);
		area.setLeftRelativeOnHarvest(relative);
		assertEquals(ColorDice.BLACK, area.getLeftRelative().getColor());
		area.refresh();
		assertNull(area.getLeftRelative());
	}

	@Test
	public void testGetValueOfRightArea() {
		HarvestAndProductionArea area=new HarvestAndProductionArea("harvest",1,1,0);
		assertEquals(1,area.getValueOfRightArea());
	}

}
