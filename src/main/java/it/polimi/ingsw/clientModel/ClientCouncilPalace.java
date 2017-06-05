package it.polimi.ingsw.clientModel;

import java.util.ArrayList;
import java.util.List;

import it.polimi.ingsw.GC_40.Player;

public class ClientCouncilPalace {
	int bonusPrivilegeCouncil;
	int bonusCoin;
	int value;
	List <String> councilPalaceEffects;
	private ArrayList<Player> order = new ArrayList<Player>();

	
	@Override
	public String toString(){
		return ("ActionValue: " + value +"\n"+ "PrivilegeCouncil bonus: "+ bonusPrivilegeCouncil + "Coin bonus: "+bonusCoin + "\n"+ "The actual order is: "+ order);
	}
}
