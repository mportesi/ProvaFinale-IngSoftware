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
import it.polimi.ingsw.cards.BuildingCard;
import it.polimi.ingsw.cards.BuildingListOfEffect;
import it.polimi.ingsw.cards.BuildingListOfPermanentEffect;
import it.polimi.ingsw.cards.CharacterCard;
import it.polimi.ingsw.cards.CharacterListOfEffect;

public class GainVictoryPointForCharacterCardTest {

	@Test
	public void testApply() throws FileNotFoundException, IOException, ParseException, NullPointerException, InterruptedException {
		GainVictoryPointForCharacterCard gain= new GainVictoryPointForCharacterCard(1);
		Play play= new Play(0);
		Player player= new Player(null, null, null, 0);
		Map<String, Integer> immediate= new LinkedHashMap();
		CharacterListOfEffect effects=new CharacterListOfEffect(immediate);
		CharacterCard card= new CharacterCard("characterCard", null, 1, 0,effects);
		player.addCard(card, play);
		gain.apply(player, play);
		assertEquals(1,player.getVictoryPoint());
	}

	@Test
	public void testGainVictoryPointForCharacterCard() {
		GainVictoryPointForCharacterCard gain= new GainVictoryPointForCharacterCard(1);
		assertEquals(1,gain.victoryPoint);
	}

}
