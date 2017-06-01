package it.polimi.ingsw.components;

import java.util.List;

import it.polimi.ingsw.GC_40.Player;
import it.polimi.ingsw.effects.Effect;
import it.polimi.ingsw.effects.GainCoin;
import it.polimi.ingsw.effects.GainFaithPoint;
import it.polimi.ingsw.effects.GainMilitaryPoint;
import it.polimi.ingsw.effects.GainServant;
import it.polimi.ingsw.effects.GainStone;
import it.polimi.ingsw.effects.GainWood;

// Quando devo attivare il privilege council, chiamo privilegeCuncil.applyEFfect(player, resource)

public class PrivilegeCouncil extends Piece {
	int bonusWoodAndStone;
	int bonusServant;
	int bonusCoin;
	int bonusMilitaryPoint;
	int bonusFaithPoint;
	List<Effect> effectOfPrivilegeCouncil;
	
	public PrivilegeCouncil (int bonusWoodAndStone, int bonusServant, int bonusCoin, int bonusMilitaryPoint, int bonusFaithPoint){
		this.bonusWoodAndStone = bonusWoodAndStone;
		this.bonusCoin = bonusCoin;
		this.bonusFaithPoint = bonusFaithPoint;
		this.bonusMilitaryPoint = bonusMilitaryPoint;
		this.bonusServant = bonusServant;
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
		
		case "bonusServant" : {
			GainServant gainServant = new GainServant (bonusServant);
			effectOfPrivilegeCouncil.add(gainServant);
			break;
		}
		
		case "bonusCoin" : {
			GainCoin gainCoin = new GainCoin (bonusCoin);
			effectOfPrivilegeCouncil.add(gainCoin);
			break;
		}
		
		case "bonusMilitaryPoint" : {
			GainMilitaryPoint gainMilitaryPoint = new GainMilitaryPoint (bonusMilitaryPoint);
			effectOfPrivilegeCouncil.add(gainMilitaryPoint);
			break;
		}
		
		case "bonusFaithPoint" : {
			GainFaithPoint gainFaithPoint = new GainFaithPoint (bonusFaithPoint);
			effectOfPrivilegeCouncil.add(gainFaithPoint);
			break;
		}
		}
	}
	
	
	public void applyEffect(Player player, String resource) {
		createEffectOfPrivilegeCouncil(resource);

		for (Effect e : effectOfPrivilegeCouncil) {
			if (e != null) {
				e.apply(player);
			} else {
				return;
			}
		}
	}
	
	/*
	
	public static void giveBonus(Piece piece, Player player){
		piece.incrementPrivilegeCouncil(player);
		
		}

	//It is useless in this class but this class extend Piece
	@Override
	public void incrementPrivilegeCouncil(Player player) {
		return;
	} */
}
