package it.polimi.ingsw.actions;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.GC_40.Observable;
import it.polimi.ingsw.GC_40.Play;
import it.polimi.ingsw.GC_40.Player;
import it.polimi.ingsw.areas.Tower;
import it.polimi.ingsw.cards.Card;
import it.polimi.ingsw.cards.VentureCard;
import it.polimi.ingsw.changes.Change;
import it.polimi.ingsw.changes.ChangeNotApplicable;
import it.polimi.ingsw.changes.ChangeOccupiedRelative;
import it.polimi.ingsw.changes.ChangeTower;
import it.polimi.ingsw.components.Relative;

public class PutRelativeOnTowerAltCost extends Observable<Change> implements PutRelative {
	Tower tower;
	Relative relative;
	int floor;
	Player player;
	Card cardToGive;
	boolean choice;
	boolean payForOccupied = false;

	public PutRelativeOnTowerAltCost(Player player, Tower tower, int floor, Relative relative, boolean choice) {
		this.relative = relative;
		this.player = player;
		this.tower = tower;
		this.floor = floor;
		this.choice = choice;
	}

	public boolean isApplicable() {
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
			player.addCard(cardToGive, play);
			cardToGive.chooseCost(choice);
			cardToGive.payCost(player, play);
			cardToGive.applyEffect(player, play);
			tower.floors.get(floor).bonusEffect.apply(player, play);
			play.changeCurrentPlayer();
		}
		else {
			play.notifyObserver( new ChangeNotApplicable(player, "you cannot put a relative here!"));
		}
		return;
	}

	public boolean checkCardCost() {
		cardToGive = tower.floors.get(floor).getCard();
		boolean check = false;
		if (cardToGive instanceof VentureCard) {
			if (player.getMilitaryPoint() >= ((VentureCard) cardToGive).getMilitaryReq()) {
				check = true;
				return check;
			}
		}
		return check;
	}
}
