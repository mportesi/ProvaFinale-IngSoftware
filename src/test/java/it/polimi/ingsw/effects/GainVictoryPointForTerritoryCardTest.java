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
import it.polimi.ingsw.cards.TerritoryCard;
import it.polimi.ingsw.cards.TerritoryListOfEffect;

public class GainVictoryPointForTerritoryCardTest {

	@Test
	public void testApply() throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		GainVictoryPointForTerritoryCard gain= new GainVictoryPointForTerritoryCard(1);
		Play play= new Play(0);
		Player player= new Player(null, null, null, 0);
		Map<String, Integer> cost= new LinkedHashMap();
		Map<String, Integer> immediate= new LinkedHashMap();
		Map<String, Integer> permanent= new LinkedHashMap();
		TerritoryListOfEffect effects=new TerritoryListOfEffect(immediate);
		TerritoryListOfEffect permanentEffects=new TerritoryListOfEffect(permanent);
		TerritoryCard card= new TerritoryCard("territoryCard",null,1,effects,permanentEffects);
		player.addCard(card, play);
		gain.apply(player, play);
		assertEquals(1,player.getVictoryPoint());
		
	}

	@Test
	public void testGainVictoryPointForTerritoryCard() {
		GainVictoryPointForTerritoryCard gain= new GainVictoryPointForTerritoryCard(1);
		assertEquals(1,gain.victoryPoint);
	}

}
