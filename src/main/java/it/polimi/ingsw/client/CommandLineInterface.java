package it.polimi.ingsw.client;

import java.util.Scanner;

public class CommandLineInterface {

	private Scanner scanner;

	public CommandLineInterface() {
		scanner = new Scanner(System.in);
	}

	public void input() {
		String input = "";
		while (!"quit".equals(input)) {
			try {
				chooseTheRelative();
				input = this.scanner.nextLine();
				chooseTheAction();
				System.out.println("your turn is finished");
				System.out.println("The board now is:"+ Board);
			} catch (IllegalStateException e) {
				return;
			}
		}

	}

	public void chooseTheAction() {

		System.out.println("Choose where you want to put the relative:");
		System.out.println("Tower");
		System.out.println("CouncilPalace");
		System.out.println("Market");
		System.out.println("HarvestArea");
		System.out.println("ProductionArea");
		String input = this.scanner.nextLine();
		switch (input) {
		case "Tower": {
			ClientTower tower = chooseTower();
			int floor = chooseFloor();
			ClientPutRelativeOnTower putRelativeOnTower = new ClientPutRelativeOnTower(tower, floor);
			break;
		}
		case "CouncilPalace": {
			String resource = choosePrivilegeCouncil();
			ClientPutRelativeOnCouncilPalace putRelativeOnCouncilPalace = new ClientPutRelativeOnCouncilPalace(
					resource); // TODO sistemare poi la stringa risorsa e
								// convertirla in dei pezzi
			break;
		}
		case "Market": {
			int market = chooseMarket();
			ClientPutRelativeOnMarket putRelativeOnMarket = new ClientPutRelativeOnMarket(market);
			break;
		}
		case "HarvestArea": {
			String harvestArea = chooseHarvestArea();
			ClientPutRelativeOnHarvestArea putRelativeOnHarvestArea = new ClientPutRelativeOnHarvestArea(harvestArea);
			break;
		}
		case "ProductionArea": {
			String productionArea = chooseProductionArea();
			ClientPutRelativeOnProductionArea putRelativeOnProductionArea = new ClientPutRelativeOnProductionArea(
					productionArea);
			break;
		}
		default: {
			System.out.println("Error: insert again");
			break;
		}
		}

	}

	public void chooseTheRelative() {

		System.out.println("Choose what relative you want to use: black, white, orange, neutral");
		String input = this.scanner.nextLine();
		ClientRelative relative;
		switch (input) {
		case "black": {
			relative = new ClientRelative(BLACK);
			break;
		}
		case "white": {
			relative = new ClientRelative(WHITE);
			break;
		}
		case "orange": {
			relative = new ClientRelative(ORANGE);
			break;
		}
		case "neutral": {
			relative = new ClientRelative(null);
			break;
		}
		default: {
			System.out.println("Error: insert again");
			break;
		}
		}
		System.out.println("How many servants do you want to use?");
		int value = this.scanner.nextInt();
		relative.modifyValue(value);

	}

	public ClientTower chooseTower() {

		System.out.println("Choose the tower:");
		System.out.println("territoryTower");
		System.out.println("buildingTower");
		System.out.println("characterTower");
		System.out.println("ventureTower");

		String input = this.scanner.nextLine();
		ClientTower tower;
		switch (input) {
		case "territoryTower": {
			tower = ClientBoard.territoryTower;
		}
		case "buildingTower": {
			tower = ClientBoard.buildingTower;
		}
		case "characterTower": {
			tower = ClientBoard.characterTower;
		}
		case "ventureTower": {
			tower = ClientBoard.ventureTower;
		}
		default: {
			System.out.println("Error: insert again");
			break;
		}
		}

		return tower;

	}

	public int chooseFloor() {
		System.out.println("Choose the number of the floor:");
		int floor = this.scanner.nextInt();
		return floor;
	}

	public String choosePrivilegeCouncil() {

		System.out.println("Choose the privilege Council:");
		System.out.println("coin");
		System.out.println("woodAndStone");
		System.out.println("servant");
		System.out.println("faithPoint");
		System.out.println("militaryPoint");

		String resource = this.scanner.nextLine();
		return resource;
	}

	public int chooseMarket() {

		System.out.println("Choose the market to put your relative:");
		int market = this.scanner.nextInt();

	}

	public String chooseHarvestArea() {

		System.out.println("Choose if you want to put your relative on the left or on the right");
		String harvestArea = this.scanner.nextLine();

	}

	public String chooseProductionArea() {

		System.out.println("Choose if you want to put your relative on the left or on the right");
		String productionArea = this.scanner.nextLine();

	}

}
