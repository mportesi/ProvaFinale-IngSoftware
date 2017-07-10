package it.polimi.ingsw.effects;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.parser.ParseException;
import org.junit.Test;

import it.polimi.ingsw.GC_40.Play;
import it.polimi.ingsw.GC_40.Player;

public class GainResourceForCostTest {

	@Test
	public void testApply() throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		ArrayList<Effect> pay=new ArrayList<Effect>();
		ArrayList<Effect> gain=new ArrayList<Effect>();
		PayCoin payCoin= new PayCoin(0);
		GainCoin gainCoin=new GainCoin(1);
		pay.add(payCoin);
		gain.add(gainCoin);
		GainResourceForCost gainResource= new GainResourceForCost(pay,gain);
		Play play=new Play(0);
		Player player=new Player(null, play, null, 0);
		gainResource.apply(player, play);
		assertEquals(1,player.getCoin());
	}

	@Test
	public void testIsApplicable() throws FileNotFoundException, NullPointerException, IOException, ParseException {
		ArrayList<Effect> pay=new ArrayList<Effect>();
		ArrayList<Effect> gain=new ArrayList<Effect>();
		PayCoin payCoin= new PayCoin(0);
		GainCoin gainCoin=new GainCoin(1);
		pay.add(payCoin);
		gain.add(gainCoin);
		GainResourceForCost gainResource= new GainResourceForCost(pay,gain);
		Play play=new Play(0);
		Player player=new Player(null, play, null, 0);
		assertTrue(gainResource.isApplicable(player));
	}

}
