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
/**
 * @author Sara
 * This is the subclass of the territory card
 */
public class TerritoryCard extends Card {
	private TerritoryListOfEffect effects;
	private TerritoryListOfEffect permanent;
	private ArrayList<Effect> immediateEffects;
	private ArrayList<Effect> permanentEffects;
	private boolean gainPrivilegeCouncil=false;
	private int permanentCost=0;

	public TerritoryCard(String type, String name, int period, TerritoryListOfEffect effects, TerritoryListOfEffect permanent) throws FileNotFoundException, IOException, ParseException {
		super(type, name, period);
		this.effects=effects;
		this.permanent=permanent;
		immediateEffects = effects.createListOfEffect();
		permanentEffects = permanent.createListOfEffect();
		setGainPrivilegeCouncil();
	}
	
	public TerritoryCard(String type, String name, int period, TerritoryListOfEffect effects, TerritoryListOfEffect permanent, int permanentCost) throws FileNotFoundException, IOException, ParseException {
		super(type, name, period);
		this.permanentCost=permanentCost;
		this.effects=effects;
		this.permanent=permanent;
		immediateEffects = effects.createListOfEffect();
		permanentEffects = permanent.createListOfEffect();
		setGainPrivilegeCouncil();
	}

	/**
	 * @author Sara
	 * To apply immediate effects when a player takes the card
	 */
	@Override
	public void applyEffect(Player player, Play play) throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		for (Effect e : immediateEffects) {
			if (e != null) {
				e.apply(player, play);
			}
			return;
		}
	}
	
	/**
	 * @author Sara
	 * To apply the effect gain privilege is necessary to use another method that ask to the player what resource he wants.
	 */
	public void applyPrivilegeBonus(Play play,Player player, String resource) throws InterruptedException{
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
			throw e;
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
	
	public void applyPermanentEffect(Player player, Play play) throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException{
		for(Effect e : permanentEffects){
			if(e!=null){
				e.apply(player,play);
			}
		}
	}
	public int getPermanentCost(){
		return permanentCost;
	}
}