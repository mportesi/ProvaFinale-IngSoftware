package it.polimi.ingsw.effects;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.junit.Test;

import it.polimi.ingsw.GC_40.Play;
import it.polimi.ingsw.GC_40.Player;

public class GainPrivilegeCouncilTest {

	@Test
	public void testApplyPlayerPlay() throws FileNotFoundException, IOException, ParseException, NullPointerException, InterruptedException {
		GainPrivilegeCouncil gain=new GainPrivilegeCouncil("coin");
		Player player=new Player(null, null, null, 0);
		Play play=new Play(0);
		gain.apply(player, play);
		assertEquals(2,player.getCoin());
	}

}
