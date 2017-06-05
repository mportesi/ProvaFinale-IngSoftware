package it.polimi.ingsw.client;

import java.util.Scanner;

public class CommandLineInterface {
	
	private Scanner scanner;
	
	
	
	public CommandLineInterface(){
		scanner= new Scanner(System.in);
		ClientInSocketHandler inSocketHandler= new ClientInSocketHandler(scanner);
	}
	
	
	public void input(){
		String input="";
		while (!"quit".equals(input)) {
			try {
				chooseTheRelative();
				input=this.scanner.nextLine();
				chooseTheAction();
				input=this.scanner.nextLine();
				switch(input){
				case("tower"):{
					chooseTowerAndFloor();
					input=this.scanner.nextLine();
				}
				}
			} catch (IllegalStateException e){
				return;
			}
		}
		
	}
	//sistemare
	public void chooseTheAction(){
		
		
		System.out.println("Choose where you want to put the relative:");
		System.out.println("Tower");
		System.out.println("CouncilPalace");
		System.out.println("Market");
		System.out.println("HarvestArea");
		System.out.println("ProductionArea");
	
	}
	
	public void chooseTheRelative(){
		
		
		System.out.println("Choose what relative you want to use: black, white, orange, neutral");
		System.out.println("How many servants do you want to use?");
		System.out.println("Divide the color and the number with the ;");
		
		
	}
	
	public void chooseTowerAndFloor(){
		
		
		System.out.println("Choose the tower:");
		System.out.println("territoryTower");
		System.out.println("buildingTower");
		System.out.println("characterTower");
		System.out.println("ventureTower");

		
		System.out.println("Choose the number of the floor:");
		System.out.println("Divide the tower and the number with the ;");
	
		
	}
	
	public void choosePrivilegeCouncil(){
		
		
		System.out.println("Choose the privilege Council:");
		System.out.println("coin");
		System.out.println("woodAndStone");
		System.out.println("servant");
		System.out.println("faithPoint");
		System.out.println("militaryPoint");
		
		
	}
	
	public void chooseMarket(){
		
		
		System.out.println("Choose the market to put your relative:");
		
	}
	
	public void chooseHarvestArea(){
		
		
		System.out.println("Choose if you want to put your relative on the left or on the right");
		
		
	}
	
	public void chooseProductionArea(){
		
		
		System.out.println("Choose if you want to put your relative on the left or on the right");
		
	}

}
