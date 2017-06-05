package it.polimi.ingsw.clientModel;

import java.util.ArrayList;

public class ClientTower {
	String type;
	public ArrayList <ClientFloor> clientFloors;

	public ClientTower (String type){
		this.type = type;
	}
	
	@Override 
	public String toString(){
		return ("["+ clientFloors.get(0).getCard()+"] \n"+"["+ clientFloors.get(1).getCard()+"] \n"+"["+ clientFloors.get(2).getCard()+"] \n"+"["+ clientFloors.get(3).getCard()+"] \n");
	}
	
	
	
}
