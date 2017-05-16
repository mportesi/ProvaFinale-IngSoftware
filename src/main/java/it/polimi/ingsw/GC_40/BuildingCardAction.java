package it.polimi.ingsw.GC_40;

public class BuildingCardAction extends CardAction {
	
	public void immediateEffect(){
		player.faithPoint+=card.permanenteffect.bonus.faithPoint;
		player.victoryPoint+=card.permanenteffect.bonus.victoryPoint;
	}
	
	public void checkTypeOfPermanentEffect(){
		if (card.permanenteffect.type.equals(exchange)) {BuildingCard.exchange()};
		if (card.permanenteffect.type.equals(doubleExchange)) {BuildingCard.doubleExchange()};
		if (card.permanenteffect.type.equals(gainForCard)) {BuildingCard.gainForCard()};
		if (card.permanenteffect.type.equals(gain)) {BuildingCard.gain()};
	}
	
	public void exchange(){
		player.coin+=(card.permanenteffect.bonus.coin-card.permanenteffect.malus.coin);
		player.wood+=(card.permanenteffect.bonus.wood-card.permanenteffect.malus.wood);
		player.stone+=(card.permanenteffect.bonus.stone-card.permanenteffect.malus.stone);
		player.servant+=(card.permanenteffect.bonus.servant-card.permanenteffect.malus.wood);
		player.faithPoint+=(card.permanenteffect.bonus.faithPoint-card.permanenteffect.malus.faithPoint);
	}
	
	public void doubleExchange(){
		chooseBonus= chooseBonus();
		if (chooseBonus==1){
			player.coin+=(card.permanenteffect.bonus1.coin-card.permanenteffect.malus1.coin);
			player.wood+=(card.permanenteffect.bonus1.wood-card.permanenteffect.malus1.wood);
			player.stone+=(card.permanenteffect.bonus1.stone-card.permanenteffect.malus1.stone);
			player.servant+=(card.permanenteffect.bonus1.servant-card.permanenteffect.malus1.wood);
			player.faithPoint+=(card.permanenteffect.bonus1.faithPoint-card.permanenteffect.malus1.faithPoint);
			player.militaryPoint+=(card.permanenteffect.bonus1.militaryPoint-card.permanenteffect.malus1.militaryPoint);
			player.victoryPoint+=(card.permanenteffect.bonus1.victoryPoint-card.permanenteffect.malus1.victoryPoint);
			if (card.permanenteffect.bonus1.privilegeCouncil!=0) 
				{PrivilegeCouncil.giveBonus()}
		}
		if (chooseBonus==2){
			player.coin+=(card.permanenteffect.bonus2.coin-card.permanenteffect.malus2.coin);
			player.wood+=(card.permanenteffect.bonus2.wood-card.permanenteffect.malus2.wood);
			player.stone+=(card.permanenteffect.bonus2.stone-card.permanenteffect.malus2.stone);
			player.servant+=(card.permanenteffect.bonus2.servant-card.permanenteffect.malus2.wood);
			player.faithPoint+=(card.permanenteffect.bonus2.faithPoint-card.permanenteffect.malus2.faithPoint);
			player.militaryPoint+=(card.permanenteffect.bonus2.militaryPoint-card.permanenteffect.malus2.militaryPoint);
			player.victoryPoint+=(card.permanenteffect.bonus2.victoryPoint-card.permanenteffect.malus2.victoryPoint);
			if (card.permanenteffect.bonus2.privilegeCouncil!=0) 
				{PrivilegeCouncil.giveBonus()}
		}
	}
	
	public void gainForCard(){
		player.coin+=card.permanenteffect.bonus.coin*player.counter(card.cardtype);
		player.victoryPoint+=card.permanenteffect.bonus.victoryPoint*player.counter(card.cardtype);
	}
	
	public void gain(){
		player.coin+=card.permanenteffect.bonus.coin;
		player.militaryPoint+=card.permanenteffect.bonus.militaryPoint;
		player.victoryPoint+=card.permanenteffect.bonus.victoryPoint;
		if (card.permanenteffect.bonus.privilegeCouncil!=0) 
		{PrivilegeCouncil.giveBonus()}
	}
	
	public int chooseBonus(){
		//giocatore sceglie bonus 1 o 2 da tastiera
	}
}
