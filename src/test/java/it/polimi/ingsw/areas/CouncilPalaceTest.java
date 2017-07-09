package it.polimi.ingsw.areas;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import org.json.simple.parser.ParseException;
import org.junit.Test;

import it.polimi.ingsw.GC_40.Play;
import it.polimi.ingsw.GC_40.Player;
import it.polimi.ingsw.colors.ColorDice;
import it.polimi.ingsw.components.Relative;
import it.polimi.ingsw.effects.GainCoin;
import it.polimi.ingsw.effects.GainPrivilegeCouncil;

public class CouncilPalaceTest {

	@Test
	public void testGetBonusCoin() {
		CouncilPalace palace=new CouncilPalace(1, 1, 1);
		assertEquals(1,palace.getBonusCoin());
	}

	@Test
	public void testCreateListOfCouncilPalaceEffect() throws FileNotFoundException, IOException, ParseException {
		CouncilPalace palace=new CouncilPalace(1, 1, 1);
		palace.createListOfCouncilPalaceEffect("coin");
		assertTrue(palace.getCouncilPalaceEffect().get(0) instanceof GainCoin);
		assertTrue(palace.getCouncilPalaceEffect().get(1) instanceof GainPrivilegeCouncil);
	}

	@Test
	public void testApplyEffect() throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		CouncilPalace palace=new CouncilPalace(1, 3, 1);
		Play play=new Play(0);
		Player player=new Player(null, play, null, 0);
		palace.applyEffect(play, player, "coin");
		assertEquals(5,player.getCoin());
		
		
	}

	@Test
	public void testGetOrder() throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		CouncilPalace palace=new CouncilPalace(1, 1, 1);
		Player player=new Player(null, null, "test", 0);
		Relative relative=new Relative(null, player);
		palace.addPlayer(player, relative);
		assertEquals("test",palace.getOrder().get(0).getName());
	}

	@Test
	public void testRefresh() throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		CouncilPalace palace=new CouncilPalace(1, 1, 1);
		Player player=new Player(null, null, "test", 0);
		Relative relative=new Relative(null, player);
		palace.addPlayer(player, relative);
		assertEquals("test",palace.getOrder().get(0).getName());
		palace.refresh();
		assertEquals(0,palace.getOrder().size());
	}

	@Test
	public void testAddPlayer() throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		CouncilPalace palace=new CouncilPalace(1, 1, 1);
		Player player=new Player(null, null, "test", 0);
		Relative relative=new Relative(null, player);
		palace.addPlayer(player, relative);
		assertEquals(1,palace.getOrder().size());
	}

	@Test
	public void testPrintOrder() throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		CouncilPalace palace=new CouncilPalace(1, 1, 1);
		Player player=new Player(null, null, "test", 0);
		Relative relative=new Relative(null, player);
		palace.addPlayer(player, relative);
		ArrayList<String> name= palace.printOrder();
		assertEquals("test",name.get(0));
	}

	@Test
	public void testIsAlreadyPresent() throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		CouncilPalace palace=new CouncilPalace(1, 1, 1);
		Player player=new Player(null, null, "test", 0);
		Relative relative=new Relative(null, player);
		palace.addPlayer(player, relative);
		assertTrue(palace.isAlreadyPresent(player));

	}

	@Test
	public void testGetRelatives() throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		CouncilPalace palace=new CouncilPalace(1, 1, 1);
		Player player=new Player(null, null, "test", 0);
		Relative relative=new Relative(ColorDice.BLACK, player);
		palace.addPlayer(player, relative);
		assertEquals(ColorDice.BLACK, palace.getRelatives().get(0).getColor());
	}

	@Test
	public void testRemovePlayer() throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		CouncilPalace palace=new CouncilPalace(1, 1, 1);
		Player player=new Player(UUID.randomUUID(), null, "test", 0);
		Relative relative=new Relative(null, player);
		palace.addPlayer(player, relative);
		assertEquals(1,palace.getOrder().size());
		palace.removePlayer(player);
		assertEquals(0,palace.getOrder().size());
	}

}
