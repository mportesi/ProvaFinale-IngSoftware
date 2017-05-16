package it.polimi.ingsw.GC_40;

public class VentureCardAction extends CardAction {
	
	public void immediateEffect(){
		player.coin+=card.immediateEffect.coin;
		player.wood+=card.immediateEffect.wood;
		player.stone+=card.immediateEffect.stone;
		player.servant+=card.immediateEffect.servant;
		player.faithPoint+=card.immediateEffect.faithPoint;
		player.militaryPoint+=card.immediateEffect.militaryPoint;
		player.victoryPoint+=card.immediateEffect.victoryPoint;
		player.harvestValue+=card.immediateEffect.harvestValue;
		player.productionValue+=card.immediateEffect.productionValue;
		if (card.permanenteffect.bonus.privilegeCouncil!=0) 
		{PrivilegeCouncil.giveBonus()}
	}
	
	public void permanentEffect(){
		player.victoryPoint+=card.permanentEffect.victoryPoint;
	}

}
