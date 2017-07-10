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
import it.polimi.ingsw.changes.ChangeNotApplicable;
import it.polimi.ingsw.changes.ChangeOccupiedRelative;
import it.polimi.ingsw.changes.ChangeTower;
import it.polimi.ingsw.components.Relative;
import it.polimi.ingsw.json.JsonMilitaryPointForTerritory;

/**
 * @author Chiara
 * Action invoked when a player puts one of his relatives on a floor of a tower with the effect "double card".
 *
 */

public class PutRelativeOnTowerDoubleCard extends Observable<Change> implements PutRelative {
	private Tower tower;
	private Tower secondT;
	private Relative relative;
	private int floor;
	private int secondF;
	private Player player;
	private Card cardToGive;
	private Card secondCardToGive;
	boolean payForOccupied = false;
	int match;

	public PutRelativeOnTowerDoubleCard(Player player, Tower tower, int floor, Relative relative, Tower secondT,
			int secondF, int match) {
		this.relative = relative;
		this.match = match;
		this.player = player;
		this.tower = tower;
		this.floor = floor;
		this.secondT = secondT;
		this.secondF = secondF;

	}

	public boolean isApplicable() throws FileNotFoundException, IOException, ParseException {
		boolean check = false;
		if (tower.floors.get(floor).isFree()) {
			if (relative.getValue() >= tower.floors.get(floor).getCost()) {
				if (tower.isPresent(player) == false) {
					check = checkCardCost();
					if (tower.isPresentAnyone()) {
						if (player.getCoin() >= tower.getCost()) {
							if(checkSecondCardCost()){
								payForOccupied=true;
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
			if (payForOccupied == true){
				player.decrementCoin(tower.getCost(), play);
			
			}
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
			if (relative.getServantsUsed()!=0){
				player.incrementServant(relative.getServantsUsed(), play);
				relative.setValueServant(0);
			}
			play.notifyObserver( new ChangeNotApplicable(player, "you cannot put a relative here!"));
		}
		return;
	}

	public boolean checkCardCost() throws FileNotFoundException, IOException, ParseException {
		cardToGive = tower.floors.get(floor).getCard();
		boolean check = false;
		JsonMilitaryPointForTerritory jsonMilitaryPointForTerritory = new JsonMilitaryPointForTerritory();
		jsonMilitaryPointForTerritory.importMilitaryPointForTerritory();
		
		if (player.counter("territory")==2 && player.getMilitaryPoint() < jsonMilitaryPointForTerritory.getForTheThirdCard()){
			check = false;
			return check;
		}
		
		if (player.counter("territory")==3 && player.getMilitaryPoint() < jsonMilitaryPointForTerritory.getForTheFourthCard()){
			check = false;
			return check;
		}
		if (player.counter("territory")==4 && player.getMilitaryPoint() < jsonMilitaryPointForTerritory.getForTheFifthCard()){
			check = false;
			return check;
		}
		if (player.counter("territory")==5 && player.getMilitaryPoint() < jsonMilitaryPointForTerritory.getForTheSixthCard()){
			check = false;
			return check;
		}
		
		
		if (cardToGive instanceof CharacterCard) {
			if (((CharacterCard) cardToGive).getCostCoin() == 0
					|| player.getCoin() >= ((CharacterCard) cardToGive).getCostCoin()) {
				check = true;
			} else {
				check = false;
			}
		}
		if (cardToGive instanceof TerritoryCard) {
			check = true;
			return check;
		}
		if (cardToGive instanceof BuildingCard) {
			if (((BuildingCard) cardToGive).getCostCoin() == 0 || player.getCoin() >= ((BuildingCard) cardToGive).getCostCoin()) {
				if (((BuildingCard) cardToGive).getCostWood() == 0 || player.getWood() >= ((BuildingCard) cardToGive).getCostWood()) {
					if (((BuildingCard) cardToGive).getCostStone() == 0 || player.getStone() >= ((BuildingCard) cardToGive).getCostStone()) {
						if (((BuildingCard) cardToGive).getCostServant() == 0 || player.getServant() >= ((BuildingCard) cardToGive).getCostServant()) {
							check = true;
						}
					}
				}
			} else {
				check = false;
			}
			return check;
		}
		if (cardToGive instanceof VentureCard) {
			if (((VentureCard) cardToGive).getCostCoin() == 0 || player.getCoin() >= ((VentureCard) cardToGive).getCostCoin()) {
				if (((VentureCard) cardToGive).getCostWood() == 0 || player.getWood() >= ((VentureCard) cardToGive).getCostWood()) {
					if (((VentureCard) cardToGive).getCostStone() == 0 || player.getStone() >= ((VentureCard) cardToGive).getCostStone()) {
						if (((VentureCard) cardToGive).getCostServant() == 0 || player.getServant() >= ((VentureCard) cardToGive).getCostServant()) {
							check = true;
						}
					}
				}
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
		if(secondT.floors.get(secondF).getCard()==null){
			return false;
		}
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

	@Override
	public int getMatch() {
		// TODO Auto-generated method stub
		return match;
	}
	
}