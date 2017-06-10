package it.polimi.ingsw.client;

import java.util.Observable;
import java.util.Scanner;
//da cambiare
//client

public class ClientView extends Observable{

	public int numberOfPlayer() {
		int numberOfPlayer=0;
		Scanner in = new Scanner(System.in);
		System.out.println("Insert number of player: ");
		while (true) {
			if (numberOfPlayer >= 2 && numberOfPlayer <= 4) {
				 numberOfPlayer= in.nextInt();
			}
			if (numberOfPlayer < 2 || numberOfPlayer > 4) {
				System.out.println("Error: reinsert the number");
				numberOfPlayer = in.nextInt();
			}
			return numberOfPlayer;

		}
	}
	
	public String chooseCostForVentureCards(){
		Scanner in = new Scanner(System.in);
		System.out.println("Insert the cost between: militaryCost or otherCost");
		return in.nextLine();
	}
	
	public String chooseTheRelative(){
		Scanner in = new Scanner(System.in);
		System.out.println("Choose a relative to place:\n" + "Black Orange White Neutral");
		return in.nextLine();
	}
	
	public int addValue(){
		Scanner in = new Scanner(System.in);
		System.out.println("Insert the number of servants that you want to use to add value to your relative");
		return in.nextInt();
	}
	
	public String chooseTheMove(){
		Scanner in = new Scanner(System.in);
		System.out.println("Insert the move that you want to do: ");
		System.out.println("PutRelativeOnTower");
		System.out.println("PutRelativeOnCouncilPalace");
		System.out.println("PutRelativeOnMarket");
		System.out.println("PutRelativeOnHarvestArea");
		System.out.println("PutRelativeOnProductionArea");
		return in.nextLine();	
	}
	
	public Object start() {
		// TODO give player the possibility to do a choice
		Object actionToDo = new Object(); 
		return actionToDo;
	}

}
