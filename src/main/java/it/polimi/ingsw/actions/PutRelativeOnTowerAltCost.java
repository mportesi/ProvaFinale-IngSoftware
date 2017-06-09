package it.polimi.ingsw.actions;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.GC_40.Observable;
import it.polimi.ingsw.GC_40.Play;
import it.polimi.ingsw.GC_40.Player;
import it.polimi.ingsw.areas.Tower;
import it.polimi.ingsw.cards.Card;
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
		if(tower.floors.get(floor).isFree() && relative.getValue()>= tower.floors.get(floor).getCost() && tower.isPresent(player)==false)
			 {
			return true;
			 }
		else return false;
	}
	
	
	@Override
	public void apply(Play play) throws FileNotFoundException, NullPointerException, IOException, ParseException{
		if(isApplicable()){
				tower.floors.get(floor).setPlayer(player);
				cardToGive= tower.floors.get(floor).giveCard();
				player.addCard(cardToGive);
				cardToGive.chooseCost(choice);
				cardToGive.payCost(player);
				cardToGive.applyEffect(player);
				tower.floors.get(floor).bonusEffect.apply(player);
				ChangeTower changeTower= new ChangeTower(tower,floor, relative);
				this.notifyObserver(changeTower);
			}
		return;
	}
}