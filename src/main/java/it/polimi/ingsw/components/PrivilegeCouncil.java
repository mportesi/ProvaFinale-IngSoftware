package it.polimi.ingsw.components;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.GC_40.Play;
import it.polimi.ingsw.GC_40.Player;
import it.polimi.ingsw.effects.Effect;
import it.polimi.ingsw.effects.GainCoin;
import it.polimi.ingsw.effects.GainFaithPoint;
import it.polimi.ingsw.effects.GainMilitaryPoint;
import it.polimi.ingsw.effects.GainServant;
import it.polimi.ingsw.effects.GainStone;
import it.polimi.ingsw.effects.GainWood;

// Quando devo attivare il privilege council, chiamo privilegeCuncil.applyEFfect(player, resource)

public class PrivilegeCouncil implements Serializable{
	private int bonusWoodAndStone;
	private int bonusServant;
	private int bonusCoin;
	private int bonusMilitaryPoint;
	private int bonusFaithPoint;
	private List<Effect> effectOfPrivilegeCouncil;
	
	public PrivilegeCouncil (int bonusWoodAndStone, int bonusServant, int bonusCoin, int bonusMilitaryPoint, int bonusFaithPoint){
		this.bonusWoodAndStone = bonusWoodAndStone;
		this.bonusCoin = bonusCoin;
		this.bonusFaithPoint = bonusFaithPoint;
		this.bonusMilitaryPoint = bonusMilitaryPoint;
		this.bonusServant = bonusServant;
		this.effectOfPrivilegeCouncil= new ArrayList<Effect>();
	}
	
	
	public void createEffectOfPrivilegeCouncil(String resource){
		switch (resource){
		case "woodAndStone" : {
			 GainWood gainWood = new GainWood (bonusWoodAndStone);
			 GainStone gainStone = new GainStone (bonusWoodAndStone);
			 effectOfPrivilegeCouncil.add(gainWood);
			 effectOfPrivilegeCouncil.add(gainStone);
			 break;
		}
		
		case "servant" : {
			GainServant gainServant = new GainServant (bonusServant);
			effectOfPrivilegeCouncil.add(gainServant);
			break;
		}
		
		case "coin" : {
			GainCoin gainCoin = new GainCoin (bonusCoin);
			effectOfPrivilegeCouncil.add(gainCoin);
			break;
		}
		
		case "militaryPoint" : {
			GainMilitaryPoint gainMilitaryPoint = new GainMilitaryPoint (bonusMilitaryPoint);
			effectOfPrivilegeCouncil.add(gainMilitaryPoint);
			break;
		}
		
		case "faithPoint" : {
			GainFaithPoint gainFaithPoint = new GainFaithPoint (bonusFaithPoint);
			effectOfPrivilegeCouncil.add(gainFaithPoint);
			break;
		}
		}
	}
	
	
	public void applyEffect(Play play, Player player, String resource) throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		createEffectOfPrivilegeCouncil(resource);
		System.out.println("effetti del priv + " +effectOfPrivilegeCouncil);
		for (Effect e : effectOfPrivilegeCouncil) {
			if (e != null) {
				e.apply(player, play);
			} else {
				return;
			}
		}
	}
	
	@Override
	public String toString() {
		return ("Privilege with effect: " + effectOfPrivilegeCouncil);
		
	}
	

}

