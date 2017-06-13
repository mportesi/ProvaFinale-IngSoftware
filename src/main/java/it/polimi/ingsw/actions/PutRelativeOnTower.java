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
		boolean check= false;
		System.out.println("entro nell'isApplicable");
		//System.out.println("entro nell'isApplicable");
		if(tower.floors.get(floor).isFree()){
			System.out.println("tower is free");
			if(relative.getValue()>=tower.floors.get(floor).getCost()){
				System.out.println("The relative has the bigger value");
				if(tower.isPresent(player)==false){
					System.out.println("There isn't the player");
					System.out.println("true");
					check=checkCardCost();
					System.out.println(check);
					return check;
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
		return check;
		//System.out.println("false");
	}
	
	
	@Override
	public void apply(Play play) throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException{
		if(isApplicable()){
			//System.out.println("Sono nell'apply di put relative on tower");
				tower.floors.get(floor).setPlayer(player, relative, tower, floor);
				player.setOccupiedRelative(relative);
				System.out.println(tower.floors.get(floor).getPlayer());
				cardToGive= tower.floors.get(floor).giveCard();
				System.out.println(cardToGive);
				player.addCard(cardToGive);
				System.out.println("territory" + player.getTerritory().size());
				cardToGive.applyEffect(player);
				tower.floors.get(floor).bonusEffect.apply(player);
				System.out.println(player);
				
				
				
			}
		return;
	}
	
	public boolean checkCardCost(){
		cardToGive= tower.floors.get(floor).getCard();
		boolean check= false;
		if(cardToGive instanceof CharacterCard){
			if(player.getCoin()>= ((CharacterCard) cardToGive).getCostCoin()){
				check=true;
				return check;
			}	
		}
		if(cardToGive instanceof TerritoryCard){
			check=true;
			return check;
		}
		if(cardToGive instanceof BuildingCard){
			if(player.getCoin()>= ((BuildingCard) cardToGive).getCostCoin()){
				check=true;
			}
			else{
				check=false;
			}
			if(player.getWood()>= ((BuildingCard) cardToGive).getCostWood()){
				check=true;
			}
			else{
				check=false;
			}
			if(player.getStone()>= ((BuildingCard) cardToGive).getCostStone()){
				check=true;
			}
			else{
				check=false;
			}
			if(player.getServant()>= ((BuildingCard) cardToGive).getCostServant()){
				check=true;
			}
			else{
				check=false;
			}
			return check;
		}
		if(cardToGive instanceof VentureCard){
			if(player.getCoin()>= ((VentureCard) cardToGive).getCostCoin()){
				check=true;
			}
			else{
				check=false;
			}				if(player.getWood()>= ((VentureCard) cardToGive).getCostWood()){
				check=true;
			}
			else{
				check=false;
			}
			if(player.getStone()>= ((VentureCard) cardToGive).getCostStone()){
				check=true;
			}
			else{
				check=false;
			}
			if(player.getServant()>= ((VentureCard) cardToGive).getCostServant()){
				check=true;
			}
			else{
				check=false;
			}
			return check;
		}
		return check;
	}
}
