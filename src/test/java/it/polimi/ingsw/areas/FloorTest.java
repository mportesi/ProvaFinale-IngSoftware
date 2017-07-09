package it.polimi.ingsw.areas;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.junit.Test;

import it.polimi.ingsw.GC_40.Player;
import it.polimi.ingsw.cards.Card;
import it.polimi.ingsw.colors.ColorDice;
import it.polimi.ingsw.components.Relative;

public class FloorTest {

	@Test
	public void testGetBonusEffect() {
		Floor floor=new Floor("territory", 1, null);
		assertNull(floor.getBonusEffect());
	}

	@Test
	public void testGetCost() {
		Floor floor=new Floor("territory", 1, null);
		assertEquals(1,floor.getCost());
	}

	@Test
	public void testGiveCard() {
		Floor floor=new Floor("territory", 1, null);
		Card card= new Card("territory", "testcard",1);
		floor.currentCard=card;
		assertEquals("territory",floor.giveCard().getType());
		assertNull(floor.currentCard);
	}

	@Test
	public void testGetPlayer() throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		Floor floor=new Floor("territory", 1, null);
		Relative relative=new Relative(null, null);
		Tower tower=new Tower(null, null, null, null, null, null);
		Player player=new Player(null, null, null, 0);
		floor.setPlayer(player, relative, tower, 1);
		assertEquals(player, floor.getPlayer());
	}

	@Test
	public void testSetPlayer() throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		Floor floor=new Floor("territory", 1, null);
		Relative relative=new Relative(null, null);
		Tower tower=new Tower(null, null, null, null, null, null);
		Player player=new Player(null, null, null, 0);
		floor.setPlayer(player, relative, tower, 1);
		assertFalse(floor.isFree());
	}

	@Test
	public void testSetFree() {
		Floor floor=new Floor("territory", 1, null);
		floor.setFree();
		assertTrue(floor.isFree());
		assertNull(floor.getPlayer());
		assertNull(floor.getRelative());
	}

	@Test
	public void testIsFree() throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		Floor floor=new Floor("territory", 1, null);
		assertTrue(floor.isFree());
		Relative relative=new Relative(null, null);
		Tower tower=new Tower(null, null, null, null, null, null);
		Player player=new Player(null, null, null, 0);
		floor.setPlayer(player, relative, tower, 1);
		assertFalse(floor.isFree());
	}

	@Test
	public void testGetCard() {
		Floor floor=new Floor("territory", 1, null);
		Card card= new Card("territory", "testcard",1);
		floor.currentCard=card;
		assertEquals("territory",floor.getCard().getType());
		assertEquals("testcard", floor.getCard().getName());
	}

	@Test
	public void testGetRelative() throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		Floor floor=new Floor("territory", 1, null);
		Relative relative=new Relative(ColorDice.BLACK, null);
		floor.setRelative(relative);
		assertEquals(ColorDice.BLACK, floor.getRelative().getColor());
		assertEquals(relative, floor.getRelative());
	}

	@Test
	public void testSetRelative() {
		Floor floor=new Floor("territory", 1, null);
		Relative relative=new Relative(ColorDice.BLACK, null);
		floor.setRelative(relative);
		assertEquals(ColorDice.BLACK, floor.getRelative().getColor());
		assertEquals(relative, floor.getRelative());
	}

}
