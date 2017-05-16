package it.polimi.ingsw.GC_40;

public class TerritoryCardAction extends CardAction {
		
		public void immediateEffect(){
			player.coin+=card.immediateEffect.bonus.coin;
			player.wood+=card.immediateEffect.bonus.wood;
			player.stone+=card.immediateEffect.bonus.stone;
			player.servant+=card.immediateEffect.bonus.servant;
			player.faithPoint+=card.immediateEffect.bonus.faithPoint;
			player.militaryPoint+=card.immediateEffect.bonus.militaryPoint;
			player.victoryPoint+=card.immediateEffect.bonus.victoryPoint;
		}
		
		public void permanentEffect(){
			player.coin+=card.permanentEffect.bonus.coin;
			player.wood+=card.permanentEffect.bonus.wood;
			player.stone+=card.permanentEffect.bonus.stone;
			player.servant+=card.permanentEffect.bonus.servant;
			player.faithPoint+=card.permanentEffect.bonus.faithPoint;
			player.militaryPoint+=card.permanentEffect.bonus.militaryPoint;
			player.victoryPoint+=card.permanentEffect.bonus.victoryPoint;
		}
		
		/**in putRelativeOnProductionArea metto un controllo:
		if (relative.value<=card.activationValue){
			card.permanentEffect();
			}
		**/
	

}
