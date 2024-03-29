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
 * Action invoked when a player puts one of his relatives on a floor of a tower.
 *
 */

public class PutRelativeOnTower extends Observable<Change> implements PutRelative {
	private Tower tower;
	private Relative relative;
	private int floor;
	private Player player;
	private Card cardToGive;
	boolean payForOccupied = false;
	int match;

	
	public PutRelativeOnTower(Player player, Tower tower, int floor, Relative relative, int match) {
		this.relative = relative;
		this.player = player;
		this.tower = tower;
		this.floor = floor;
		this.match = match;
	}

	

/**
 * The player can put his/her relative on the tower if the relative has a sufficient cost, and if the player has enough resources to get the card.
 * If on the same tower there's another relative on the player, he/she can't put the relative on that tower (unless it is the white relative).
 * If on the same tower there's a relative of another player, he/she can put the relative on that tower, after paying three coins.
 * @author Chiara
 * 
 *
 */
	
	public boolean isApplicable() throws FileNotFoundException, IOException, ParseException {
		boolean check = false;
		if (tower.floors.get(floor).isFree()) {
			if (relative.getValue() >= tower.floors.get(floor).getCost()) {
				if (tower.isPresent(player) == false) {
					check = checkCardCost();
					if (tower.isPresentAnyone()) {
						if (player.getCoin() >= tower.getCost()) {
							payForOccupied=true;
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
	
	/**
	 * If the action is applicable, the player takes the card on that floor, and immediately applies the immediate effects of it.
	 * The player will pay the cost associated to the floor and to the card.
	 * The floor will be occupied by the relative, and all the observers will be notified so that the resources of the player will be updated.
	 * 
	 * @author Chiara
	 * 
	 *
	 */

	@Override
	public void apply(Play play)
			throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		if (isApplicable()) {
			if (payForOccupied == true){
				player.decrementCoin(tower.getCost(), play);
			}
			tower.floors.get(floor).setPlayer(player, relative, tower, floor);
			player.setOccupiedRelative(relative);
			play.notifyObserver(new ChangeOccupiedRelative(player, relative));
			cardToGive = tower.floors.get(floor).giveCard();
			play.notifyObserver(new ChangeTower(tower, floor,player, relative));
			cardToGive.payCost(player, play);
			player.addCard(cardToGive, play);
			cardToGive.applyEffect(player, play);
			if(tower.floors.get(floor).bonusEffect!=null){
					tower.floors.get(floor).bonusEffect.apply(player, play);}
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

	
	/**
	 * Checks if the player has enough resources to take the card. 
	 * If the card is of type "territory", the player need to have enough military points to take it.
	 * @author Chiara
	 * 
	 *
	 */
	
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

	@Override
	public int getMatch() {
		
		return match;
	}
	
	
}
