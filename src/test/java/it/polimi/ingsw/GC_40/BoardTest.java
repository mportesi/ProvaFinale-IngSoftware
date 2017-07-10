package it.polimi.ingsw.GC_40;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.UUID;

import org.json.simple.parser.ParseException;
import org.junit.Test;

import it.polimi.ingsw.areas.CouncilPalace;
import it.polimi.ingsw.areas.HarvestAndProductionArea;
import it.polimi.ingsw.areas.MarketBuilding;
import it.polimi.ingsw.areas.Tower;
import it.polimi.ingsw.colors.ColorDice;
import it.polimi.ingsw.components.Relative;

public class BoardTest {

	@Test
	public void testBoard() throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		Play play=new Play(0);
		Board board=new Board(play, 0);
		assertTrue(board.getBuildingTower() instanceof Tower);
		
	}

	@Test
	public void testGetCouncilPalace() throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		Play play=new Play(0);
		Board board=new Board(play, 0);
		assertTrue(board.getCouncilPalace() instanceof CouncilPalace);
	}

	@Test
	public void testGetTerritoryTower() throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		Play play=new Play(0);
		Board board=new Board(play, 0);
		assertTrue(board.getTerritoryTower() instanceof Tower);
	}

	@Test
	public void testGetBuildingTower() throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		Play play=new Play(0);
		Board board=new Board(play, 0);
		assertTrue(board.getBuildingTower() instanceof Tower);
	}

	@Test
	public void testGetCharacterTower() throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		Play play=new Play(0);
		Board board=new Board(play, 0);
		assertTrue(board.getCharacterTower() instanceof Tower);
	}

	@Test
	public void testGetVentureTower() throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		Play play=new Play(0);
		Board board=new Board(play, 0);
		assertTrue(board.getVentureTower() instanceof Tower);
	}

	@Test
	public void testGetHarvestArea() throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		Play play=new Play(0);
		Board board=new Board(play, 0);
		assertTrue(board.getHarvestArea() instanceof HarvestAndProductionArea);
	}

	@Test
	public void testGetProductionArea() throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		Play play=new Play(0);
		Board board=new Board(play, 0);
		assertTrue(board.getProductionArea() instanceof HarvestAndProductionArea);
	}

	@Test
	public void testGetBlackDice() throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		Play play=new Play(0);
		Board board=new Board(play, 0);
		assertEquals(ColorDice.BLACK, board.getBlackDice().getColor());
	}

	@Test
	public void testGetWhiteDice() throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		Play play=new Play(0);
		Board board=new Board(play, 0);
		assertEquals(ColorDice.WHITE, board.getWhiteDice().getColor());
	}

	@Test
	public void testGetOrangeDice() throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		Play play=new Play(0);
		Board board=new Board(play, 0);
		assertEquals(ColorDice.ORANGE, board.getOrangeDice().getColor());
	}

	@Test
	public void testGetDeck() throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		Play play=new Play(0);
		Board board=new Board(play, 0);
		assertNotEquals(0,board.getDeck().size());
	}

	@Test
	public void testGetMarketInt() throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		Play play=new Play(0);
		Board board=new Board(play, 0);
		assertTrue(board.getMarket(0) instanceof MarketBuilding);
	}

	@Test
	public void testGetMarket() throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		Play play=new Play(0);
		Board board=new Board(play, 0);
		assertTrue(board.getMarket().get(0) instanceof MarketBuilding);
	}


	@Test
	public void testGetNumberOfPlayers() throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		Play play=new Play(0);
		Board board=new Board(play, 0);
		assertEquals(0, board.getNumberOfPlayers());
	}

	@Test
	public void testRemove() throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		Play play=new Play(0);
		Board board=new Board(play, 0);
		Player player= new Player(UUID.randomUUID(), play, "test", 0);
		Relative relative=new Relative(ColorDice.ORANGE, player);
		board.getCouncilPalace().addPlayer(player, relative);
		board.remove(player);
		assertEquals(0,board.getCouncilPalace().getOrder().size());
		
	}

}
