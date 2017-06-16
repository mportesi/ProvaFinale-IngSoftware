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
import it.polimi.ingsw.components.PrivilegeCouncil;
import it.polimi.ingsw.components.Relative;
import it.polimi.ingsw.effects.GainPrivilegeCouncil;
import it.polimi.ingsw.json.JsonMilitaryPointForTerritory;

public class PutRelativeOnTowerPrivilege extends Observable<Change> implements PutRelative {
	Tower tower;
	Relative relative;
	int floor;
	Player player;
	Card cardToGive;
	String bonus;
	boolean payForOccupied = false;

	public PutRelativeOnTowerPrivilege(Player player, Tower tower, int floor, Relative relative, String bonus) {
		this.relative = relative;
		this.player = player;
		this.tower = tower;
		this.floor = floor;
		this.bonus = bonus;
	}

	public boolean isApplicable() throws FileNotFoundException, IOException, ParseException {
		boolean check = false;
		if (tower.floors.get(floor).isFree()) {
			if (relative.getValue() >= tower.floors.get(floor).getCost()) {
				if (tower.isPresent(player) == false) {
					check = checkCardCost();
					if (tower.isPresentAnyone()) {
						if (player.getCoin() >= tower.getCost()) {
							payForOccupied = true;
							return check;
						} else
							check = false;
					}
					return check;
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
			cardToGive.applyPrivilegeBonus(play, player, bonus);
			tower.floors.get(floor).bonusEffect.apply(player, play);
			play.changeCurrentPlayer();
		}
		else {
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
}
