package it.polimi.ingsw.components;

import static org.junit.Assert.*;

import org.junit.Test;

import it.polimi.ingsw.components.FinalVictoryPoint;

public class FinalVictoryPointTest {

	@Test
	public void testFinalVictoryPoint() {
		FinalVictoryPoint finalVictory = new FinalVictoryPoint("test",1,1,1,1,1,1);
		assertEquals(1,finalVictory.getFinalVictoryPointForOne());
	}

	@Test
	public void testGetType() {
		FinalVictoryPoint finalVictory = new FinalVictoryPoint("test",1,1,1,1,1,1);
		assertEquals("test",finalVictory.getType());
	}

	@Test
	public void testSetType() {
		FinalVictoryPoint finalVictory = new FinalVictoryPoint("test",1,1,1,1,1,1);
		finalVictory.setType("changed");
		assertEquals("changed",finalVictory.getType());
	}

	@Test
	public void testGetFinalVictoryPointForOne() {
		FinalVictoryPoint finalVictory = new FinalVictoryPoint("test",1,1,1,1,1,1);
		assertEquals(1,finalVictory.getFinalVictoryPointForOne());
	}

	@Test
	public void testSetFinalVictoryPointForOne() {
		FinalVictoryPoint finalVictory = new FinalVictoryPoint("test",1,1,1,1,1,1);
		finalVictory.setFinalVictoryPointForOne(2);
		assertEquals(2,finalVictory.getFinalVictoryPointForOne());
	}

	@Test
	public void testGetFinalVictoryPointForTwo() {
		FinalVictoryPoint finalVictory = new FinalVictoryPoint("test",1,1,1,1,1,1);
		assertEquals(1,finalVictory.getFinalVictoryPointForTwo());
	}

	@Test
	public void testSetFinalVictoryPointForTwo() {
		FinalVictoryPoint finalVictory = new FinalVictoryPoint("test",1,1,1,1,1,1);
		finalVictory.setFinalVictoryPointForTwo(2);
		assertEquals(2,finalVictory.getFinalVictoryPointForTwo());
	}

	@Test
	public void testGetFinalVictoryPointForThree() {
		FinalVictoryPoint finalVictory = new FinalVictoryPoint("test",1,1,1,1,1,1);
		assertEquals(1,finalVictory.getFinalVictoryPointForThree());
	}

	@Test
	public void testSetFinalVictoryPointForThree() {
		FinalVictoryPoint finalVictory = new FinalVictoryPoint("test",1,1,1,1,1,1);
		finalVictory.setFinalVictoryPointForThree(2);
		assertEquals(2,finalVictory.getFinalVictoryPointForThree());
	}

	@Test
	public void testGetFinalVictoryPointForFour() {
		FinalVictoryPoint finalVictory = new FinalVictoryPoint("test",1,1,1,1,1,1);
		assertEquals(1,finalVictory.getFinalVictoryPointForFour());
	}

	@Test
	public void testSetFinalVictoryPointForFour() {
		FinalVictoryPoint finalVictory = new FinalVictoryPoint("test",1,1,1,1,1,1);
		finalVictory.setFinalVictoryPointForFour(2);
		assertEquals(2,finalVictory.getFinalVictoryPointForFour());
	}

	@Test
	public void testGetFinalVictoryPointForFive() {
		FinalVictoryPoint finalVictory = new FinalVictoryPoint("test",1,1,1,1,1,1);
		assertEquals(1,finalVictory.getFinalVictoryPointForFive());
	}

	@Test
	public void testSetFinalVictoryPointForFive() {
		FinalVictoryPoint finalVictory = new FinalVictoryPoint("test",1,1,1,1,1,1);
		finalVictory.setFinalVictoryPointForFive(2);
		assertEquals(2,finalVictory.getFinalVictoryPointForFive());
	}

	@Test
	public void testGetFinalVictoryPointForSix() {
		FinalVictoryPoint finalVictory = new FinalVictoryPoint("test",1,1,1,1,1,1);
		assertEquals(1,finalVictory.getFinalVictoryPointForSix());
	}

	@Test
	public void testSetFinalVictoryPointForSix() {
		FinalVictoryPoint finalVictory = new FinalVictoryPoint("test",1,1,1,1,1,1);
		finalVictory.setFinalVictoryPointForSix(2);
		assertEquals(2,finalVictory.getFinalVictoryPointForSix());
	}

}
