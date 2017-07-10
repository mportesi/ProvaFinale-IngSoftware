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
import it.polimi.ingsw.components.PersonalBonusTile;
import it.polimi.ingsw.components.PersonalBonusTileListOfHarvestEffect;
import it.polimi.ingsw.components.PersonalBonusTileListOfProductionEffect;

public class GainHarvestValueTest {

	@Test
	public void testApply() throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		GainHarvestValue gain=new GainHarvestValue(1);
		Play play=new Play(0);
		Player player= new Player(null, play, null, 0);
		Map<String,Integer> production=new LinkedHashMap();
		production.put("coin", 1);
		PersonalBonusTileListOfProductionEffect productionTile=new PersonalBonusTileListOfProductionEffect(production);
		Map<String,Integer> harvest=new LinkedHashMap();
		harvest.put("coin", 1);
		PersonalBonusTileListOfHarvestEffect harvestTile=new PersonalBonusTileListOfHarvestEffect(harvest);
		PersonalBonusTile personalSimple=new PersonalBonusTile("test", productionTile, harvestTile, 0, 0);
		player.setPersonalBonusTile(personalSimple, null);
		gain.apply(player, play);
		assertEquals(1,player.getCoin());
	}

	@Test
	public void testGainHarvestValue() {
		GainHarvestValue gain=new GainHarvestValue(1);
		assertEquals(1,gain.harvestValue);
	}

}
