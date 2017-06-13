package it.polimi.ingsw.cards;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.GC_40.Player;
import it.polimi.ingsw.effects.Effect;
import it.polimi.ingsw.effects.GainPrivilegeCouncil;

public class TerritoryCard extends Card {
	private TerritoryListOfEffect effects;
	private ArrayList<Effect> immediateEffects;

	public TerritoryCard(String type, String name, int period, TerritoryListOfEffect effects) throws FileNotFoundException, IOException, ParseException {
		super(type, name, period);
		this.effects=effects;
		immediateEffects = effects.createListOfEffect();
	}

	// to apply immediate effects
	public void applyEffect(Player player) throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		

		for (Effect e : immediateEffects) {
			if (e != null) {
				e.apply(player);
			}
			return;
		}
	}
	
	public void applyPrivilegeBonus(Player player, String resource){
		try {
			GainPrivilegeCouncil gain= new GainPrivilegeCouncil(resource);
			gain.apply(player);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public String toString(){
		return (name + ": gli effetti immediati sono " + immediateEffects );
	}
}