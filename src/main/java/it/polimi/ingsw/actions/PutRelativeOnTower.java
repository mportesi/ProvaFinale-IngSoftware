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
		System.out.println("entro nell'isApplicable");
		if(tower.floors.get(floor).isFree()){
			System.out.println("tower is free");
			if(relative.getValue()>=tower.floors.get(floor).getCost()){
				System.out.println("The relative has the bigger value");
				if(tower.isPresent(player)==false){
					System.out.println("There isn't the player");
					//System.out.println("true");
					return true;
				}
			}
		}
		
		/*if((tower.floors.get(floor).isFree()) && (relative.getValue()>= tower.floors.get(floor).getCost()) && (tower.isPresent(player)==false))
			 {
			System.out.println(tower);
			System.out.println("true");
			return true;
			 }
	
		else {
			System.out.println("false");
			return false;
		}*/
		return false;
		//System.out.println("false");
	}
	
	
	@Override
	public void apply(Play play) throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException{
		if(isApplicable()){
			System.out.println("Sono nell'apply di put relative on tower");
				tower.floors.get(floor).setPlayer(player, relative, tower, floor);
				player.setOccupiedRelative(relative);
				System.out.println(tower.floors.get(floor).getPlayer());
				cardToGive= tower.floors.get(floor).giveCard();
				System.out.println(cardToGive);
				player.addCard(cardToGive);
				System.out.println("territory" + player.getTerritory().size());
				cardToGive.applyEffect(player);
				tower.floors.get(floor).bonusEffect.apply(player);
				
				
				
			}
		return;
	}
}
