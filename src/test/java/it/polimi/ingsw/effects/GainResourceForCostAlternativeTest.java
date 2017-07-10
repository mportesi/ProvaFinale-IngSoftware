package it.polimi.ingsw.effects;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.parser.ParseException;
import org.junit.Test;

import it.polimi.ingsw.GC_40.Play;
import it.polimi.ingsw.GC_40.Player;

public class GainResourceForCostAlternativeTest {

	@Test
	public void testApply() throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		ArrayList<Effect> pay=new ArrayList<Effect>();
		ArrayList<Effect> gain=new ArrayList<Effect>();
		PayCoin payCoin= new PayCoin(0);
		GainCoin gainCoin=new GainCoin(1);
		pay.add(payCoin);
		gain.add(gainCoin);
		ArrayList<Effect> payAlt=new ArrayList<Effect>();
		ArrayList<Effect> gainAlt=new ArrayList<Effect>();
		PayCoin payCoinAlt= new PayCoin(0);
		GainCoin gainCoinAlt=new GainCoin(2);
		payAlt.add(payCoinAlt);
		gainAlt.add(gainCoinAlt);
		GainResourceForCostAlternative gainResource= new GainResourceForCostAlternative(pay,gain,payAlt,gainAlt);
		Play play=new Play(0);
		Player player=new Player(null, play, null, 0);
		gainResource.apply(player, play);
		assertEquals(1,player.getCoin());
		gainResource.chooseAlt(true);
		gainResource.apply(player, play);
		assertEquals(3,player.getCoin());
	}

	@Test
	public void testIsApplicable() throws FileNotFoundException, NullPointerException, IOException, ParseException {
		ArrayList<Effect> pay=new ArrayList<Effect>();
		ArrayList<Effect> gain=new ArrayList<Effect>();
		PayCoin payCoin= new PayCoin(0);
		GainCoin gainCoin=new GainCoin(1);
		pay.add(payCoin);
		gain.add(gainCoin);
		ArrayList<Effect> payAlt=new ArrayList<Effect>();
		ArrayList<Effect> gainAlt=new ArrayList<Effect>();
		PayCoin payCoinAlt= new PayCoin(0);
		GainCoin gainCoinAlt=new GainCoin(2);
		payAlt.add(payCoinAlt);
		gainAlt.add(gainCoinAlt);
		GainResourceForCostAlternative gainResource= new GainResourceForCostAlternative(pay,gain,payAlt,gainAlt);
		Play play=new Play(0);
		Player player=new Player(null, play, null, 0);
		assertTrue(gainResource.isApplicable(player));
		gainResource.chooseAlt(true);
		assertTrue(gainResource.isApplicable(player));
	}

}
