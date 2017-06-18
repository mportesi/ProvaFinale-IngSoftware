package it.polimi.ingsw.cards;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.GC_40.Play;
import it.polimi.ingsw.GC_40.Player;
import it.polimi.ingsw.effects.Effect;
import it.polimi.ingsw.effects.GainPrivilegeCouncil;
import it.polimi.ingsw.effects.HasPrivilege;

public class TerritoryCard extends Card {
	private TerritoryListOfEffect effects;
	private ArrayList<Effect> immediateEffects;
	private boolean gainPrivilegeCouncil=false;

	public TerritoryCard(String type, String name, int period, TerritoryListOfEffect effects) throws FileNotFoundException, IOException, ParseException {
		super(type, name, period);
		this.effects=effects;
		immediateEffects = effects.createListOfEffect();
		setGainPrivilegeCouncil();
	}

	// to apply immediate effects
	@Override
	public void applyEffect(Player player, Play play) throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		for (Effect e : immediateEffects) {
			if (e != null) {
				e.apply(player, play);
			}
			return;
		}
	}
	
	public void applyPrivilegeBonus(Play play,Player player, String resource){
		try {
			GainPrivilegeCouncil gain= new GainPrivilegeCouncil(resource);
			gain.apply(player, play);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public String toString(){
		return (name + ":\n" + " The immediate effects are " + immediateEffects );
	}

	public boolean isGainPrivilegeCouncil() {
		return gainPrivilegeCouncil;
	}

	public void setGainPrivilegeCouncil() {
		for (Effect e : this.immediateEffects) {
			if (e instanceof HasPrivilege) {
				this.gainPrivilegeCouncil = true;
			}
		}
		
	}
	public boolean getGainPrivilegeCouncil() {
		return gainPrivilegeCouncil;
	}
}