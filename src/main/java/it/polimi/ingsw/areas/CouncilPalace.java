package it.polimi.ingsw.areas;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.GC_40.Board;
import it.polimi.ingsw.GC_40.Observable;
import it.polimi.ingsw.GC_40.Play;
import it.polimi.ingsw.GC_40.Player;
import it.polimi.ingsw.changes.*;
import it.polimi.ingsw.client.CommandLineInterface;

import it.polimi.ingsw.components.PrivilegeCouncil;
import it.polimi.ingsw.components.Relative;
import it.polimi.ingsw.effects.Effect;
import it.polimi.ingsw.effects.GainCoin;
import it.polimi.ingsw.effects.GainPrivilegeCouncil;

public class CouncilPalace extends Observable<Change> implements Serializable{
	private int bonusPrivilegeCouncil;
	private int bonusCoin;
	private int value;
	private List <Effect> councilPalaceEffect;
	private ArrayList<Player> order = new ArrayList<Player>();
	private int orderIndex = 0;

	public CouncilPalace(int bonusPrivilegeCouncil, int bonusCoin, int value){
		this.bonusPrivilegeCouncil = bonusPrivilegeCouncil;
		this.bonusCoin = bonusCoin;
		this.value = value;
		councilPalaceEffect= new ArrayList<>();
	}
	
	public CouncilPalace(CouncilPalace councilPalace, Play play){
		this.bonusPrivilegeCouncil=councilPalace.getBonusPrivilegeCouncil();
		this.bonusCoin=councilPalace.bonusCoin;
		this.value=councilPalace.getValue();
		councilPalaceEffect= new ArrayList<>();
		this.registerObserver(play);
	}
	
	
	private int getValue() {
		// TODO Auto-generated method stub
		return value;
	}

	private int getBonusCoin() {
		// TODO Auto-generated method stub
		return bonusCoin;
	}

	private int getBonusPrivilegeCouncil() {
		// TODO Auto-generated method stub
		return bonusPrivilegeCouncil;
	}

	public void createListOfCouncilPalaceEffect(String bonus) throws FileNotFoundException, IOException, ParseException{
		GainCoin gainCoin = new GainCoin(bonusCoin);
		councilPalaceEffect.add(gainCoin);
		GainPrivilegeCouncil gainPrivilegeCouncil = new GainPrivilegeCouncil (bonusPrivilegeCouncil, bonus);
		councilPalaceEffect.add(gainPrivilegeCouncil);
		
	}
	
	
	public void applyEffect(Player player, String bonus) throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException{
		createListOfCouncilPalaceEffect(bonus);
		System.out.println(councilPalaceEffect);
		for (Effect e : councilPalaceEffect){
			e.apply(player);
		}
	}

	public ArrayList<Player> getOrder() {
		return order;
	}

	// to empty the council palace at the end of the round
	public void refresh() {
		order.clear();
		orderIndex = 0;
	}

	// to add a player on the council palace
	public void addPlayer(Player player, Relative relative) throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		order.add(orderIndex, player);
		orderIndex += 1;
		ChangeCouncilPalace changeCouncilPalace= new ChangeCouncilPalace(relative);
		System.out.println("ho creato il change");
		this.notifyObserver(changeCouncilPalace);
	}
	
	@Override
	public String toString(){
		return ("ActionValue: " + value +"\n"+ "PrivilegeCouncil bonus: "+ bonusPrivilegeCouncil + "Coin bonus: "+bonusCoin + "\n"+ "The actual order is: "+ order);
	}
}
