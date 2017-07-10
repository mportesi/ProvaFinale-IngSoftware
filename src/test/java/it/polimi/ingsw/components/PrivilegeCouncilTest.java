package it.polimi.ingsw.components;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.junit.Test;

import it.polimi.ingsw.GC_40.Play;
import it.polimi.ingsw.GC_40.Player;
import it.polimi.ingsw.components.PrivilegeCouncil;

public class PrivilegeCouncilTest {

	@Test
	public void testCreateEffectOfPrivilegeCouncil() throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		PrivilegeCouncil council=new PrivilegeCouncil(1,1,1,1,1);
		council.createEffectOfPrivilegeCouncil("coin");
		Play play=new Play(0);
		Player player=new Player(null, play, null, 0);
		council.applyEffect(play, player, "servant");
		assertEquals(1,player.getServant());
		assertEquals(1,player.getCoin());
	}

	@Test
	public void testApplyEffect() throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		PrivilegeCouncil council=new PrivilegeCouncil(1,1,1,1,1);
		Play play=new Play(0);
		Player player=new Player(null, play, null, 0);
		council.applyEffect(play, player, "servant");
		council.applyEffect(play, player, "coin");
		assertEquals(2,player.getServant());
		assertEquals(1,player.getCoin());
	}

}
