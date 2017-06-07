package it.polimi.ingsw.areas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import it.polimi.ingsw.GC_40.Player;
import it.polimi.ingsw.client.CommandLineInterface;
import it.polimi.ingsw.components.PrivilegeCouncil;
import it.polimi.ingsw.effects.Effect;
import it.polimi.ingsw.effects.GainCoin;
import it.polimi.ingsw.effects.GainPrivilegeCouncil;

public class CouncilPalace {
	int bonusPrivilegeCouncil;
	int bonusCoin;
	int value;
	List <Effect> councilPalaceEffect;
	
	private ArrayList<Player> order = new ArrayList<Player>();
	private int orderIndex = 0;

	
	public CouncilPalace(int bonusPrivilegeCouncil, int bonusCoin, int value){
		this.bonusPrivilegeCouncil = bonusPrivilegeCouncil;
		this.bonusCoin = bonusCoin;
		this.value = value;
	}
	
	public void createListOfCouncilPalaceEffect(){
		GainCoin gainCoin = new GainCoin(bonusCoin);
		councilPalaceEffect.add(gainCoin);
		String resource = CommandLineInterface.choosePrivilegeCouncil(); 
		GainPrivilegeCouncil gainPrivilegeCouncil = new GainPrivilegeCouncil (bonusPrivilegeCouncil, resource);
		councilPalaceEffect.add(gainPrivilegeCouncil);
		
	}
	
	// to give the bonus when a player put a relative and choose a piece
	/*public void giveBonus(Piece r, Player player) {
		player.incrementCoin(1);
		PrivilegeCouncil.giveBonus(r, player);
	}*/
	
	public void applyEffect(Player player){
		createListOfCouncilPalaceEffect();
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
	public void addPlayer(Player player) {
		order.add(orderIndex, player);
		orderIndex += 1;
	}
	
	@Override
	public String toString(){
		return ("ActionValue: " + value +"\n"+ "PrivilegeCouncil bonus: "+ bonusPrivilegeCouncil + "Coin bonus: "+bonusCoin + "\n"+ "The actual order is: "+ order);
	}
}
