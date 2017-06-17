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
	private ArrayList<Player> order;
	private ArrayList <Relative> relatives = new ArrayList <Relative>();
	private int orderIndex = 0;

	public CouncilPalace(int bonusPrivilegeCouncil, int bonusCoin, int value){
		this.bonusPrivilegeCouncil = bonusPrivilegeCouncil;
		this.bonusCoin = bonusCoin;
		this.value = value;
		councilPalaceEffect= new ArrayList<>();
		order = new ArrayList<Player>();
	}
	
	public CouncilPalace(CouncilPalace councilPalace, Play play){
		this.bonusPrivilegeCouncil=councilPalace.getBonusPrivilegeCouncil();
		this.bonusCoin=councilPalace.bonusCoin;
		this.value=councilPalace.getValue();
		councilPalaceEffect= new ArrayList<>();
		order = new ArrayList<Player>();
		this.registerObserver(play);
	}
	
	
	private int getValue() {
		return value;
	}

	public int getBonusCoin() {
		return bonusCoin;
	}

	private int getBonusPrivilegeCouncil() {
		return bonusPrivilegeCouncil;
	}

	public void createListOfCouncilPalaceEffect(String bonus) throws FileNotFoundException, IOException, ParseException{
		GainCoin gainCoin = new GainCoin(bonusCoin);
		councilPalaceEffect.add(gainCoin);
		GainPrivilegeCouncil gainPrivilegeCouncil = new GainPrivilegeCouncil (bonusPrivilegeCouncil, bonus);
		councilPalaceEffect.add(gainPrivilegeCouncil);
		
	}
	
	
	public void applyEffect(Play play, Player player, String bonus) throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException{
		createListOfCouncilPalaceEffect(bonus);
		for (Effect e : councilPalaceEffect){
			e.apply(player, play);
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
	}
	
	@Override
	public String toString(){
		return ("CouncilPalace: "+"\nActionValue: " + value +"\n"+ "PrivilegeCouncil bonus: "+ bonusPrivilegeCouncil + "\nCoin bonus: "+bonusCoin + "\n"+ "Effect: gainPrivilegeCouncil" + "\nRelatives:  "+ relatives +"\nThe actual order is: "+ printOrder());
	}
	
	public ArrayList<String> printOrder(){
		ArrayList<String> name= new ArrayList<String>();
		if (order != null){
		for (Player p : order){
			p.getName();
			name.add(p.getName());
		}
		}
		return name;
	}

	public boolean isAlreadyPresent(Player player) {
		for (Player p : order){
			
			if (p.getName().equals(player.getName())){
				System.out.println("CP true");
				return true;
			}
		}
		System.out.println("CP false");
		return false;
		}

	public ArrayList <Relative> getRelatives() {
		return relatives;
	}
		
		
	

	}
