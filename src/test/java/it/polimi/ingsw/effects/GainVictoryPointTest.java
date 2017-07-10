package it.polimi.ingsw.effects;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.junit.Test;

import it.polimi.ingsw.GC_40.Play;
import it.polimi.ingsw.GC_40.Player;

public class GainVictoryPointTest {

	@Test
	public void testApply() throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		GainVictoryPoint gain=new GainVictoryPoint(1);
		Play play=new Play(0);
		Player player=new Player(null, play, null, 0);
		gain.apply(player, play);
		assertEquals(1,player.getVictoryPoint());
	}

	@Test
	public void testGainVictoryPoint() {
		GainVictoryPoint gain=new GainVictoryPoint(1);
		assertEquals(1,gain.victoryPoint);
	}

}
