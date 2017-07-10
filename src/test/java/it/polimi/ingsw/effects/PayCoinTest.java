package it.polimi.ingsw.effects;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.junit.Test;

import it.polimi.ingsw.GC_40.Play;
import it.polimi.ingsw.GC_40.Player;

public class PayCoinTest {

	@Test
	public void testApply() throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		PayCoin pay=new PayCoin(1);
		Play play=new Play(0);
		Player player=new Player(null, play, null, 0);
		GainCoin gain=new GainCoin(2);
		gain.apply(player, play);
		pay.apply(player, play);
		assertEquals(1,player.getCoin());
	}

	@Test
	public void testIsApplicable() throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		PayCoin pay=new PayCoin(1);
		Play play=new Play(0);
		Player player=new Player(null, play, null, 0);
		assertFalse(pay.isApplicable(player));
		GainCoin gain=new GainCoin(2);
		gain.apply(player, play);
		assertTrue(pay.isApplicable(player));
		
		
	}

	@Test
	public void testPayCoin() {
		PayCoin pay=new PayCoin(1);
		assertEquals(1,pay.coin);
	}

}
