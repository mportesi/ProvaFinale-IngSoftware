package it.polimi.ingsw.effects;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.junit.Test;

import it.polimi.ingsw.GC_40.Play;
import it.polimi.ingsw.GC_40.Player;

public class GainTerrCardBonusTest {

	@Test
	public void testApply() throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		GainTerrCardBonus gain=new GainTerrCardBonus(1);
		Play play=new Play(0);
		Player player=new Player(null, play, null, 0);
		gain.apply(player, play);
		assertEquals(1,player.getTerrCardBonus());
	}

	@Test
	public void testGainTerrCardBonus() {
		GainTerrCardBonus gain=new GainTerrCardBonus(1);
		assertEquals(1,gain.terrBonus);
	}

}
