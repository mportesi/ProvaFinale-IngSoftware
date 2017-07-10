package it.polimi.ingsw.effects;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.junit.Test;

import it.polimi.ingsw.GC_40.Play;
import it.polimi.ingsw.GC_40.Player;

public class GainVictoryPointForMilitaryPointTest {

	@Test
	public void testApply() throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		GainVictoryPointForMilitaryPoint gain= new GainVictoryPointForMilitaryPoint(1);
		Play play= new Play(0);
		Player player= new Player(null, null, null, 0);
		player.setMilitaryPoint(5);
		gain.apply(player, play);
		assertEquals(5,player.getVictoryPoint());
	}

	@Test
	public void testGainVictoryPointForMilitaryPoint() {
		GainVictoryPointForMilitaryPoint gain= new GainVictoryPointForMilitaryPoint(1);
		assertEquals(1,gain.victoryPoint);
	}

}
