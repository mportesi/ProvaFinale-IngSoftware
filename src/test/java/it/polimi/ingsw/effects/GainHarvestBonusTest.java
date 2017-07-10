package it.polimi.ingsw.effects;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.junit.Test;

import it.polimi.ingsw.GC_40.Play;
import it.polimi.ingsw.GC_40.Player;

public class GainHarvestBonusTest {

	@Test
	public void testApply() throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		GainHarvestBonus gain=new GainHarvestBonus(1);
		Play play=new Play(0);
		Player player=new Player(null, play, null, 0);
		gain.apply(player, play);
		assertEquals(1,player.getHarvestBonus());
	}

	@Test
	public void testGainHarvestBonus() {
		GainHarvestBonus gain=new GainHarvestBonus(1);
		assertEquals(1,gain.harvestBonus);
	}

}
