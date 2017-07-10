package it.polimi.ingsw.effects;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.junit.Test;

import it.polimi.ingsw.GC_40.Play;
import it.polimi.ingsw.GC_40.Player;

public class PayFaithTest {

	@Test
	public void testApply() throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		PayFaith pay=new PayFaith(1);
		Play play=new Play(0);
		Player player=new Player(null, play, null, 0);
		GainFaithPoint gain=new GainFaithPoint(2);
		gain.apply(player, play);
		pay.apply(player, play);
		assertEquals(1,player.getFaithPoint());
	}

	@Test
	public void testIsApplicable() throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		PayFaith pay=new PayFaith(1);
		Play play=new Play(0);
		Player player=new Player(null, play, null, 0);
		assertFalse(pay.isApplicable(player));
		GainFaithPoint gain=new GainFaithPoint(2);
		gain.apply(player, play);
		assertTrue(pay.isApplicable(player));
	}

	@Test
	public void testPayFaith() {
		PayFaith pay=new PayFaith(1);
		assertEquals(1,pay.faith);
	}

}
