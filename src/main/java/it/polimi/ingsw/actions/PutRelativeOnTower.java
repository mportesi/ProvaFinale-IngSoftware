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

public class PutRelativeOnTower extends Observable<Change> implements PutRelative {
	private Tower tower;
	private Relative relative;
	private int floor;
	private Player player;
	private Card cardToGive;
	
	public PutRelativeOnTower(Player player, Tower tower, int floor, Relative relative){
		this.relative=relative;
		this.player=player;
		this.tower=tower;
		this.floor=floor;
	}
	
	public boolean isApplicable(){
		System.out.println(tower);
		System.out.println(floor);
		System.out.println(relative);
		System.out.println(player);
		System.out.println("Value of relative: "+ relative.getValue());
		System.out.println("Cost of action: "+ tower.floors.get(floor).getCost());
		System.out.println("C'è il giocatore: "+ tower.floors.get(floor).getPlayer());
		if(tower.floors.get(floor).isFree() && relative.getValue()>= tower.floors.get(floor).getCost() && tower.isPresent(player)==false)
			 {
			return true;
			 }
		else return false;
	}
	
	
	@Override
	public void apply(Play play) throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException{
		System.out.println("sono nell'apply di putRelative");
		if(isApplicable()){
			System.out.println(isApplicable());
				tower.floors.get(floor).setPlayer(player);
				cardToGive= tower.floors.get(floor).giveCard();
				player.addCard(cardToGive);
				cardToGive.applyEffect(player);
				tower.floors.get(floor).bonusEffect.apply(player);
				System.out.println("ho fatto l'apply  " + tower.floors.get(floor).getPlayer());
				ChangeTower changeTower= new ChangeTower(tower,floor, relative);
				this.notifyObserver(changeTower);
				
			}
		return;
	}
}
