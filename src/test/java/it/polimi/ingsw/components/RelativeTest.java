package it.polimi.ingsw.components;

import static org.junit.Assert.*;

import org.junit.Test;

import it.polimi.ingsw.GC_40.Player;
import it.polimi.ingsw.colors.ColorDice;
import it.polimi.ingsw.components.Relative;

public class RelativeTest {

	@Test
	public void testRelative() {
		Relative rel=new Relative(ColorDice.BLACK,null);
		assertEquals(ColorDice.BLACK,rel.getColor());
	}

	@Test
	public void testGetColor() {
		Relative rel=new Relative(ColorDice.WHITE,null);
		assertEquals(ColorDice.WHITE,rel.getColor());
	}

	@Test
	public void testGetValue() {
		Relative rel=new Relative(ColorDice.BLACK,null);
		rel.setValue(1);
		assertEquals(1,rel.getValue());
	}

	@Test
	public void testSetValueServant() {
		Relative rel=new Relative(ColorDice.BLACK,null);
		rel.setValue(1);
		rel.setValueServant(1);
		assertEquals(2,rel.getValue());
	}

	@Test
	public void testAddValue() {
		Relative rel=new Relative(ColorDice.BLACK,null);
		rel.setValue(1);
		rel.addValue(1);
		assertEquals(2,rel.getValue());
	}

	@Test
	public void testSetValue() {
		Relative rel=new Relative(ColorDice.BLACK,null);
		rel.setValue(3);
		assertEquals(3,rel.getValue());
	}

	@Test
	public void testGetPlayer() {
		Player player=new Player(null, null, "test", 0);
		Relative rel=new Relative(ColorDice.BLACK,player);
		assertEquals("test",rel.getPlayer().getName());
	}

	@Test
	public void testEqualsObject() {
		Relative rel=new Relative(ColorDice.BLACK,null);
		assertTrue(rel.equals(rel));
		assertFalse(rel.equals(null));
	}

	@Test
	public void testGetServantsUsed() {
		Relative rel=new Relative(ColorDice.BLACK,null);
		rel.setValue(1);
		rel.setValueServant(1);
		assertEquals(1,rel.getServantsUsed());
	}

}
