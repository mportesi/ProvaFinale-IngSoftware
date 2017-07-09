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
import it.polimi.ingsw.GC_40.*;
import it.polimi.ingsw.GC_40.Player;
import it.polimi.ingsw.changes.*;
import it.polimi.ingsw.client.CommandLineInterface;

import it.polimi.ingsw.components.PrivilegeCouncil;
import it.polimi.ingsw.components.Relative;
import it.polimi.ingsw.effects.Effect;
import it.polimi.ingsw.effects.GainCoin;
import it.polimi.ingsw.effects.GainPrivilegeCouncil;

/**
 * @author Sara
 * Class for the area of the council palace where the players can put relatives.
 */

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
		relatives = new ArrayList <Relative>();
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

	/**
	 * @author Sara
	 * Create the list of effects based on the bonus that we ask to the player because there is
	 * the privilege that is a list of resources that can be choosen.
	 */
	public void createListOfCouncilPalaceEffect(String bonus) throws FileNotFoundException, IOException, ParseException{
		GainCoin gainCoin = new GainCoin(bonusCoin);
		councilPalaceEffect.add(gainCoin);
		GainPrivilegeCouncil gainPrivilegeCouncil = new GainPrivilegeCouncil (bonusPrivilegeCouncil, bonus);
		councilPalaceEffect.add(gainPrivilegeCouncil);
		
	}
	
	/**
	 * @author Sara
	 * Apply the effects when the player put the relative here: for every effect .
	 */
	public void applyEffect(Play play, Player player, String bonus) throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException{
		createListOfCouncilPalaceEffect(bonus);
		for (Effect e : councilPalaceEffect){
			e.apply(player, play);
		}
	}

	public ArrayList<Player> getOrder() {
		return order;
	}

	/**
	 * @author Sara
	 * To empty the council palace when it is finished the round.
	 */
	public void refresh() {
		order.clear();
		orderIndex = 0;
	}

	/**
	 * @author Sara
	 * To add the player in the array that contains all the players that put a relative in this area.
	 */
	public void addPlayer(Player player, Relative relative) throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		order.add(orderIndex, player);
		orderIndex += 1;
	}
	
	@Override
	public String toString(){
		return ("CouncilPalace: "+"\nActionValue: " + value +"\n"+ "PrivilegeCouncil bonus: "+ bonusPrivilegeCouncil + "\nCoin bonus: "+bonusCoin + "\n"+ "Effect: gainPrivilegeCouncil" + "\nRelatives:  "+ relatives +"\nThe actual order is: "+ printOrder());
	}
	
	/**
	 * @author Sara
	 * To print the order of the players for the command line.
	 */

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

	/**
	 * @author Sara
	 * To see if a player is present in the council for the change of the turn order when the round is finished.
	 */
	public boolean isAlreadyPresent(Player player) {
		for (Player p : order){
			
			if (p.getName().equals(player.getName())){
				return true;
			}
		}
		return false;
		}
	
	
	public ArrayList <Relative> getRelatives() {
		return relatives;
	}

	/**
	 * @author Sara
	 * To remove the player from the council palace when he doesn't want to play anymore
	 * and he exits from the match.
	 */

	public void removePlayer(Player player) {
		Player playerToRemove=null;
		Relative relativeToRemove=null;
		for(int i=0; i<order.size(); i++){
			if(player.getID().equals(order.get(i))){
				playerToRemove=order.get(i);
			}
			if(relatives.get(i).getPlayer().getID().equals(player.getID())){
				relativeToRemove=relatives.get(i);
			}
		}
		order.remove(playerToRemove);
		relatives.remove(relativeToRemove);
	}
		
		
	

	}
