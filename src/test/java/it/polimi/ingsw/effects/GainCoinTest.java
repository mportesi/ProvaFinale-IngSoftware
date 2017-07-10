package it.polimi.ingsw.effects;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.junit.Test;

import it.polimi.ingsw.GC_40.Play;
import it.polimi.ingsw.GC_40.Player;

public class GainCoinTest {

	@Test
	public void testApply() throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		GainCoin gain=new GainCoin(1);
		Play play=new Play(0);
		Player player=new Player(null, play, null, 0);
		gain.apply(player, play);
		assertEquals(1,player.getCoin());
		
	}

	@Test
	public void testGainCoin() {
		GainCoin gain=new GainCoin(1);
		assertEquals(1,gain.coin);
	}

}
