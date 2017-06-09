package it.polimi.ingsw.cards;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.GC_40.Player;
import it.polimi.ingsw.effects.Effect;

public class TerritoryCard extends Card {
	private TerritoryListOfEffect effects;
	private ArrayList<Effect> immediateEffects;

	public TerritoryCard(String type, String name, int period) {
		super(type, name, period);
	}

	// to apply immediate effects
	public void applyEffect(Player player) throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		immediateEffects = effects.createListOfEffect();

		for (Effect e : immediateEffects) {
			if (e != null) {
				e.apply(player);
			}
			return;
		}
	}
}