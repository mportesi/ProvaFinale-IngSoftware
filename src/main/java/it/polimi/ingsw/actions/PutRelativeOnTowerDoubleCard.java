package it.polimi.ingsw.actions;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.GC_40.Observable;
import it.polimi.ingsw.GC_40.Play;
import it.polimi.ingsw.GC_40.Player;
import it.polimi.ingsw.areas.Tower;
import it.polimi.ingsw.cards.BuildingCard;
import it.polimi.ingsw.cards.Card;
import it.polimi.ingsw.cards.CharacterCard;
import it.polimi.ingsw.cards.TerritoryCard;
import it.polimi.ingsw.cards.VentureCard;
import it.polimi.ingsw.changes.Change;
import it.polimi.ingsw.changes.ChangeOccupiedRelative;
import it.polimi.ingsw.changes.ChangeTower;
import it.polimi.ingsw.components.Relative;

public class PutRelativeOnTowerDoubleCard extends Observable<Change> implements PutRelative {
	private Tower tower;
	private Tower secondT;
	private Relative relative;
	private int floor;
	private int secondF;
	private Player player;
	private Card cardToGive;
	private Card secondCardToGive;

	public PutRelativeOnTowerDoubleCard(Player player, Tower tower, int floor, Relative relative, Tower seconT,
			int secondF) {
		this.relative = relative;
		this.player = player;
		this.tower = tower;
		this.floor = floor;
		this.secondT = secondT;
		this.secondF = secondF;

	}

	public boolean isApplicable() {
		boolean check = false;
		if (tower.floors.get(floor).isFree()) {
			if (relative.getValue() >= tower.floors.get(floor).getCost()) {
				if (tower.isPresent(player) == false) {
					check = checkCardCost();
					if (tower.isPresentAnyone()) {
						if (player.getCoin() >= tower.getCost()) {
							if(checkSecondCardCost()){
								return check;
							}
						} else
							check = false;
					}
					if(checkSecondCardCost()){
						return check;
					}
					else{
						check=false;
					}
				}
			}
		}

		return check;
	}

	@Override
	public void apply(Play play)
			throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		if (isApplicable()) {
			tower.floors.get(floor).setPlayer(player, relative, tower, floor);
			play.notifyObserver(new ChangeTower(tower, floor,player, relative));
			player.setOccupiedRelative(relative);
			play.notifyObserver(new ChangeOccupiedRelative(player, relative));
			cardToGive = tower.floors.get(floor).giveCard();
			cardToGive.payCost(player, play);
			player.addCard(cardToGive, play);
			cardToGive.applyEffect(player, play);
			tower.floors.get(floor).bonusEffect.apply(player, play);
			secondCardToGive = secondT.floors.get(secondF).giveCard();
			secondCardToGive.payCost(player, play);
			giveDiscount(cardToGive,player,play);
			player.addCard(secondCardToGive, play);
			secondCardToGive.applyEffect(player, play);
			play.changeCurrentPlayer();
		}
		else {
			play.actionNotApplicable(player);
		}
		return;
	}

	public boolean checkCardCost() {
		cardToGive = tower.floors.get(floor).getCard();
		boolean check = false;
		if (cardToGive instanceof CharacterCard) {
			if (player.getCoin() >= ((CharacterCard) cardToGive).getCostCoin()) {
				check = true;
				return check;
			}
		}
		if (cardToGive instanceof TerritoryCard) {
			check = true;
			return check;
		}
		if (cardToGive instanceof BuildingCard) {
			if (player.getCoin() >= ((BuildingCard) cardToGive).getCostCoin()) {
				check = true;
			} else {
				check = false;
			}
			if (player.getWood() >= ((BuildingCard) cardToGive).getCostWood()) {
				check = true;
			} else {
				check = false;
			}
			if (player.getStone() >= ((BuildingCard) cardToGive).getCostStone()) {
				check = true;
			} else {
				check = false;
			}
			if (player.getServant() >= ((BuildingCard) cardToGive).getCostServant()) {
				check = true;
			} else {
				check = false;
			}
			return check;
		}
		if (cardToGive instanceof VentureCard) {
			if (player.getCoin() >= ((VentureCard) cardToGive).getCostCoin()) {
				check = true;
			} else {
				check = false;
			}
			if (player.getWood() >= ((VentureCard) cardToGive).getCostWood()) {
				check = true;
			} else {
				check = false;
			}
			if (player.getStone() >= ((VentureCard) cardToGive).getCostStone()) {
				check = true;
			} else {
				check = false;
			}
			if (player.getServant() >= ((VentureCard) cardToGive).getCostServant()) {
				check = true;
			} else {
				check = false;
			}
			return check;
		}
		return check;
	}
	
	private boolean checkSecondCardCost(){
		boolean value=false;
		cardToGive = tower.floors.get(floor).getCard();
		secondCardToGive = secondT.floors.get(secondF).getCard();
		if(((CharacterCard) cardToGive).getSecondCardValue()>=secondT.floors.get(floor).getCost()){
			if(((CharacterCard) cardToGive).getSecondCard().equals(secondCardToGive.getType()) || ((CharacterCard) cardToGive).getSecondCard()=="anyone"){
				if(secondCardToGive instanceof CharacterCard ){
					if ((player.getCoin()-((CharacterCard)cardToGive).getCostCoin() + ((CharacterCard)cardToGive).getDiscountCoin() ) >= ((CharacterCard) secondCardToGive).getCostCoin()) {
						value = true;
						return value;
					}
				}
				if (secondCardToGive instanceof TerritoryCard) {
					value = true;
					return value;
				}
				if (secondCardToGive instanceof BuildingCard){
					if ((player.getCoin()-((CharacterCard) cardToGive).getCostCoin()+((CharacterCard) cardToGive).getDiscountCoin()) >= ((BuildingCard) secondCardToGive).getCostCoin()) {
						if ((player.getWood()+((CharacterCard) cardToGive).getDiscountWood()) >= ((BuildingCard) secondCardToGive).getCostWood()) {
							if ((player.getStone()+((CharacterCard) cardToGive).getDiscountStone()) >= ((BuildingCard) secondCardToGive).getCostStone()) {
								if (player.getServant() >= ((BuildingCard) secondCardToGive).getCostServant()) {
									value=true;
								}
							}
						}
					}
					return value;
				}
				if (secondCardToGive instanceof VentureCard) {
					if ((player.getCoin()-((CharacterCard) cardToGive).getCostCoin()+((CharacterCard) cardToGive).getDiscountCoin()) >= ((VentureCard) secondCardToGive).getCostCoin()) {
						if ((player.getWood() +((CharacterCard) cardToGive).getDiscountWood()) >= ((VentureCard) secondCardToGive).getCostWood()) {
							if ((player.getStone()+((CharacterCard) cardToGive).getDiscountStone()) >= ((VentureCard) secondCardToGive).getCostStone()) {
								if (player.getServant() >= ((VentureCard) secondCardToGive).getCostServant()) {
									value=true;
								}
							}
						}
					}
					return value;
				}
			}
		}
		return value;
	}
	public void giveDiscount(Card cardToGive,Player player, Play play) throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException{
		
		player.incrementCoin(((CharacterCard) cardToGive).getDiscountCoin(), play);
		player.incrementWood(((CharacterCard) cardToGive).getDiscountWood(), play);
		player.incrementStone(((CharacterCard) cardToGive).getDiscountStone(), play);
	}
}