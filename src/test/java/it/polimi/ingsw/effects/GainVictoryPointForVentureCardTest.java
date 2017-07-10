package it.polimi.ingsw.effects;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.json.simple.parser.ParseException;
import org.junit.Test;

import it.polimi.ingsw.GC_40.Play;
import it.polimi.ingsw.GC_40.Player;
import it.polimi.ingsw.cards.BuildingListOfEffect;
import it.polimi.ingsw.cards.VentureCard;
import it.polimi.ingsw.cards.VentureListOfEffect;

public class GainVictoryPointForVentureCardTest {

	@Test
	public void testApply() throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		GainVictoryPointForVentureCard gain= new GainVictoryPointForVentureCard(1);
		Play play= new Play(0);
		Player player= new Player(null, null, null, 0);
		Map<String, Integer> cost= new LinkedHashMap();
		Map<String, Integer> immediate= new LinkedHashMap();
		VentureListOfEffect effects=new VentureListOfEffect(immediate);
		VentureCard card= new VentureCard("ventureCard",null,1,0,0,cost,effects);
		player.addCard(card, play);
		gain.apply(player, play);
		assertEquals(1,player.getVictoryPoint());
	}

	@Test
	public void testGainVictoryPointForVentureCard() {
		GainVictoryPointForVentureCard gain= new GainVictoryPointForVentureCard(1);
		assertEquals(1,gain.victoryPoint);
	}

}
