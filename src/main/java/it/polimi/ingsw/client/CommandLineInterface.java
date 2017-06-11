package it.polimi.ingsw.client;

import java.io.Serializable;
import java.util.Scanner;

import it.polimi.ingsw.GC_40.Board;
import it.polimi.ingsw.GC_40.Player;
import it.polimi.ingsw.actions.PutRelative;
import it.polimi.ingsw.actions.PutRelativeOnCouncilPalace;
import it.polimi.ingsw.actions.PutRelativeOnHarvestArea;
import it.polimi.ingsw.actions.PutRelativeOnMarket;
import it.polimi.ingsw.actions.PutRelativeOnProductionArea;
import it.polimi.ingsw.actions.PutRelativeOnTower;
import it.polimi.ingsw.areas.MarketBuilding;
import it.polimi.ingsw.areas.Tower;
import it.polimi.ingsw.colors.ColorDice;
import it.polimi.ingsw.components.Relative;
import it.polimi.ingsw.serverRMI.ServerRMIConnectionViewRemote;

public class CommandLineInterface implements Serializable{

	private Scanner scanner;
	private Player player;// ??
	private ClientModel client;

	public CommandLineInterface(Player player, ClientModel client) {
		scanner = new Scanner(System.in);
		this.player=player;
		this.client=client;
	}

	public void input() {
		String input = "";
		while (!"quit".equals(input)) {
			try {
				chooseTheAction();
				System.out.println("your turn is finished");
				System.out.println("The board now is:" + client);
			} catch (IllegalStateException e) {
				return;
			}
		}

	}
	
	public void printTheBoard(){
		client.getBoard();
	}

	public PutRelative chooseTheAction() {
		System.out.println("sta giocando"+ player.getName());

		Relative relative = chooseTheRelative();
		
		System.out.println("ho creato un relative");

		System.out.println("Choose where you want to put the relative:");
		System.out.println("Tower");
		System.out.println("CouncilPalace");
		System.out.println("Market");
		System.out.println("HarvestArea");
		System.out.println("ProductionArea");
		scanner.nextLine();
		String input = scanner.nextLine();
		
		PutRelative putRelative = null;
		//System.out.println("sto entrando nello switch");
		switch (input) {
		case "Tower": {
			Tower tower = chooseTower();
			int floor = chooseFloor();
			putRelative = new PutRelativeOnTower(player, tower, floor, relative);
			break;
		}
		case "CouncilPalace": {
			String bonus = choosePrivilegeCouncil();
			putRelative = new PutRelativeOnCouncilPalace(player, relative, bonus); // TODO
																					// sistemare
																					// poi
																					// la
																					// stringa
																					// risorsa
																					// e
			// convertirla in dei pezzi
			break;
		}
		case "Market": {
			MarketBuilding market = chooseMarket();
			putRelative = new PutRelativeOnMarket(player, relative, market); // sistemare
			break;
		}
		case "HarvestArea": {
			String harvestArea = chooseHarvestArea();
			putRelative = new PutRelativeOnHarvestArea(player, relative, harvestArea);
			
			break;
		}
		case "ProductionArea": {
			String productionArea = chooseProductionArea();
			putRelative = new PutRelativeOnProductionArea(player, relative, productionArea);
			
			break;
		}

		default: {
			System.out.println("Error: insert again");
			//chooseTheAction();
			break;
		}
		
		}
		return putRelative;
		

	}

	public Relative chooseTheRelative() {

		System.out.println("Choose what relative you want to use: black, white, orange, neutral");
		String input = scanner.nextLine();
		Relative relative = null;
		switch (input) {
		case "black": {
			relative = new Relative(ColorDice.BLACK);
			break;
		}
		case "white": {
			relative = new Relative(ColorDice.WHITE);
		//	System.out.println("ho creato un relative");
			break;
		}
		case "orange": {
			relative = new Relative(ColorDice.ORANGE);
			break;
		}
		case "neutral": {
			relative = new Relative(null);
			break;
		}
		default: {
			System.out.println("Error: insert again");
			break;
		}
		}
		System.out.println("How many servants do you want to use?");
		int value = scanner.nextInt();
		relative.setValue(value);
		return relative;

	}

	public Tower chooseTower() {
		
		System.out.println("Choose the tower:");
		System.out.println("territoryTower");
		System.out.println("buildingTower");
		System.out.println("characterTower");
		System.out.println("ventureTower");
		String input = scanner.nextLine();
		Tower tower;
		switch (input) {
		case "territoryTower": {
			tower = this.client.getTerritoryTower();
			return tower;
		}
		case "buildingTower": {
			tower = this.client.getBuildingTower();
			return tower;
		}
		case "characterTower": {
			tower = this.client.getCharacterTower();
			return tower;
		}
		case "ventureTower": {
			tower = this.client.getVentureTower();
			return tower;
		}
		default: {
			System.out.println("Error: insert again");
			break;
		}
		}
		return null;

	}

	public int chooseFloor() {
		System.out.println("Choose the number of the floor:");
		int floor = scanner.nextInt();
		return floor;
	}

	public String choosePrivilegeCouncil() {

		System.out.println("Choose the privilege Council:");
		System.out.println("coin");
		System.out.println("woodAndStone");
		System.out.println("servant");
		System.out.println("faithPoint");
		System.out.println("militaryPoint");

		String resource = scanner.nextLine();
		return resource;
	}

	public MarketBuilding chooseMarket() {

		System.out.println("Choose the market to put your relative:");
		int number = scanner.nextInt();
		MarketBuilding market = null;
		return client.getMarket(number);
	}

	public String chooseHarvestArea() {

		System.out.println("Choose if you want to put your relative on the left or on the right");
		String harvestArea = scanner.nextLine();
		return harvestArea;

	}

	public String chooseProductionArea() {

		System.out.println("Choose if you want to put your relative on the left or on the right");
		String productionArea = scanner.nextLine();
		return productionArea;

	}

}
