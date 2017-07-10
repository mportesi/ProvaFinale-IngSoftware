package it.polimi.ingsw.components;

import static org.junit.Assert.*;

import org.junit.Test;

import it.polimi.ingsw.colors.ColorDice;
import it.polimi.ingsw.components.Dice;

public class DiceTest {

	@Test
	public void testDice() {
		Dice dice=new Dice(ColorDice.BLACK);
		assertEquals(ColorDice.BLACK, dice.getColor());
	}

	@Test
	public void testGetColor() {
		Dice dice=new Dice(ColorDice.BLACK);
		assertEquals(ColorDice.BLACK, dice.getColor());
	}

	@Test
	public void testGetValue() {
		Dice dice=new Dice(ColorDice.BLACK);
		dice.setValue();
		assertEquals(3,dice.getValue(),3);
	}

	@Test
	public void testRoll() {
		Dice dice=new Dice(ColorDice.BLACK);
		int testInt=dice.roll();
		assertNotNull(testInt);
		assertEquals(3,testInt,3);
	}

	@Test
	public void testSetValue() {
		Dice dice=new Dice(ColorDice.BLACK);
		dice.setValue();
		assertEquals(3,dice.getValue(),3);
	}

}
