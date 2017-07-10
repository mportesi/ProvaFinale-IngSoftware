package it.polimi.ingsw.GC_40;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import org.json.simple.parser.ParseException;
import org.junit.Test;

import it.polimi.ingsw.areas.Tower;
import it.polimi.ingsw.colors.ColorDice;
import it.polimi.ingsw.components.Relative;

public class PlayTest {

	@Test
	public void testInitializeBoard() throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		Play play=new Play(0);
		play.createNewPlayer("test", 0);
		play.initializeBoard(0);
		assertTrue(play.getBoard().getBuildingTower() instanceof Tower);
			
	}

	@Test
	public void testGiveStartingCoin() throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		Play play=new Play(0);
		Player player=new Player(UUID.randomUUID(), play, "test", 0);
		ArrayList<Player> playerList=new ArrayList<Player>();
		playerList.add(player);
		play.giveStartingCoin(playerList);
		assertEquals(5,player.getCoin());
	}

	@Test
	public void testInitializePlayer() throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		Play play=new Play(0);
		play.createNewPlayer("test", 0);
		play.initializePlayer(0);
		assertEquals(2,play.getPlayers().get(0).getWood());
	}

	@Test
	public void testCreateTurnOrder() throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		Play play=new Play(0);
		play.createNewPlayer("test", 0);
		play.initializePlayer(0);
		assertEquals(1,play.getCurrentTurnOrder().size());
	}

	@Test
	public void testChangeTurnOrder() throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		Play play=new Play(0);
		play.initializeBoard(0);
		play.createNewPlayer("test", 0);
		play.initializePlayer(0);
		Relative relative=new Relative(ColorDice.BLACK, (play.getPlayers().get(0)));
		play.getBoard().getCouncilPalace().addPlayer(play.getPlayers().get(0), relative);
		play.changeTurnOrder();
		assertEquals(1,play.getCurrentTurnOrder().size());
	}

	@Test
	public void testGiveFinalPoint() throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		Play play=new Play(0);
		play.initializeBoard(0);
		play.createNewPlayer("test", 0);
		play.initializePlayer(0);
		play.giveFinalPoint();
		assertNotEquals(0,play.getPlayers().get(0).getVictoryPoint());
	}

	@Test
	public void testCreateNewPlayer() throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		Play play=new Play(0);
		play.initializeBoard(0);
		play.createNewPlayer("test", 0);
		assertEquals("test", play.getPlayers().get(0).getName());
	}

}
