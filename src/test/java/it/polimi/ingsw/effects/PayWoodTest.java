package it.polimi.ingsw.effects;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.junit.Test;

import it.polimi.ingsw.GC_40.Play;
import it.polimi.ingsw.GC_40.Player;

public class PayWoodTest {

	@Test
	public void testApply() throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		PayWood pay=new PayWood(1);
		Play play=new Play(0);
		Player player=new Player(null, play, null, 0);
		GainWood gain=new GainWood(2);
		gain.apply(player, play);
		pay.apply(player, play);
		assertEquals(1,player.getWood());
	}

	@Test
	public void testIsApplicable() throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		PayWood pay=new PayWood(1);
		Play play=new Play(0);
		Player player=new Player(null, play, null, 0);
		assertFalse(pay.isApplicable(player));
		GainWood gain=new GainWood(2);
		gain.apply(player, play);
		assertTrue(pay.isApplicable(player));
	}

	@Test
	public void testPayWood() {
		PayWood pay=new PayWood(1);
		assertEquals(1,pay.wood);
	}

}
