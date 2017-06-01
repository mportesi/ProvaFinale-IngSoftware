package it.polimi.ingsw.client;

import java.util.Scanner;

public class CommandLineInterface {
	
	//sistemare
	public void doAnAction(){
		Scanner in= new Scanner(System.in);
		
		System.out.println("Choose where you want to put the relative:");
		System.out.println("Tower");
		System.out.println("CouncilPalace");
		System.out.println("Market");
		System.out.println("HarvestArea");
		System.out.println("ProductionArea");
		String place= in.nextLine();
		
		switch(place){
		case "Tower":
			
		}
	}

}
