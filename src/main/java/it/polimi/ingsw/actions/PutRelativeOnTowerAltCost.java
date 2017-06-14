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
import it.polimi.ingsw.changes.ChangeTower;
import it.polimi.ingsw.components.Relative;

public class PutRelativeOnTowerAltCost extends Observable<Change> implements PutRelative {
	Tower tower;
	Relative relative;
	int floor;
	Player player;
	Card cardToGive;
	boolean choice;
	
	public PutRelativeOnTowerAltCost(Player player, Tower tower, int floor, Relative relative, boolean choice){
		this.relative=relative;
		this.player=player;
		this.tower=tower;
		this.floor=floor;
		this.choice=choice;
	}
	
	public boolean isApplicable(){
		boolean check = false;
		if (tower.floors.get(floor).isFree()) {
			System.out.println("tower is free");
			if (relative.getValue() >= tower.floors.get(floor).getCost()) {
				System.out.println("The relative has the bigger value");
				if (tower.isPresent(player) == false) {
					System.out.println("There isn't the player");
					System.out.println("true");
					check = checkCardCost();
					if (tower.isPresentAnyone()) {
						if (player.getCoin() >= tower.getCost()) {
							return check;
						} else
							check = false;
					}
					System.out.println(check);
					return check;
				}
			}
		}

		return check;
	}
	
	
	@Override
	public void apply(Play play) throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException{
		if(isApplicable()){
				tower.floors.get(floor).setPlayer(player, relative, tower, floor);
				player.setOccupiedRelative(relative);
				cardToGive= tower.floors.get(floor).giveCard();
				player.addCard(cardToGive);
				cardToGive.chooseCost(choice);
				cardToGive.payCost(player);
				cardToGive.applyEffect(player);
				tower.floors.get(floor).bonusEffect.apply(player);
				ChangeTower changeTower= new ChangeTower(tower,floor, relative);
				this.notifyObserver(changeTower);
				System.out.println(player);
			}
		return;
	}

	public boolean checkCardCost() {
		cardToGive= tower.floors.get(floor).getCard();
		boolean check= false;
		if(cardToGive instanceof VentureCard){
			if(player.getMilitaryPoint()>= ((VentureCard) cardToGive).getMilitaryReq()){
				check=true;
				return check;
			}
		}
		return check;
	}
}
