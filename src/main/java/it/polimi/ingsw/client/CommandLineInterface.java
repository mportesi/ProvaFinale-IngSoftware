package it.polimi.ingsw.client;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Callable;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.GC_40.Board;
import it.polimi.ingsw.GC_40.Player;
import it.polimi.ingsw.GC_40.TimerAction;
import it.polimi.ingsw.actions.*;
import it.polimi.ingsw.areas.MarketBuilding;
import it.polimi.ingsw.areas.Tower;
import it.polimi.ingsw.colors.ColorDice;
import it.polimi.ingsw.components.PrivilegeCouncil;
import it.polimi.ingsw.components.Relative;
import it.polimi.ingsw.effects.GainPrivilegeCouncil;
import it.polimi.ingsw.json.JsonTimeOut;
import it.polimi.ingsw.serverRMI.ServerRMIConnectionViewRemote;

public class CommandLineInterface implements Serializable, Runnable {

	private BufferedReader in;
//	private transient Scanner scanner;
	private ClientModel client;
	private ServerRMIConnectionViewRemote serverStub;
	private Timer timer;
	

	public CommandLineInterface(ClientModel client, ServerRMIConnectionViewRemote serverStub, Timer timer) {
		in = new BufferedReader(new InputStreamReader(System.in));
	//	scanner = new Scanner(System.in);
		this.client = client;
		this.serverStub = serverStub;
		this.timer=timer;
	}

	public CommandLineInterface(ClientModel client) {
		in = new BufferedReader(new InputStreamReader(System.in));
		//scanner = new Scanner(System.in);
		this.client = client;
	}
	
	public void esci() throws FileNotFoundException, NullPointerException, RemoteException, IOException, ParseException, InterruptedException{


	@SuppressWarnings("deprecation")

		ShiftPlayer shiftPlayer = new ShiftPlayer(client.getPlayer().getMatch());
		serverStub.notifyObserver(shiftPlayer);
		
	//	scanner.close();
		System.out.println("The scanner is closed!");
		
	
	}
	

	public void input()
			throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {

		/*JsonTimeOut jsonTimeOut = new JsonTimeOut();

		
		
			
	
		JsonTimeOut jsonTimeOut = new JsonTimeOut();

		int timeOutAction = jsonTimeOut.getTimeOutAction();
		Timer timer = new Timer();
		timer.schedule(new TimerAction(serverStub) { public void run() {
			System.out.println("It ran out of time!");
			//ShiftPlayer shiftPlayer = new ShiftPlayer(client.getPlayer().getMatch());
			try {
				esci();
			} catch (NullPointerException | IOException | InterruptedException | org.json.simple.parser.ParseException e) {
				e.printStackTrace();
			}

		}}, (long) timeOutAction); */
		if(client.getCurrentPlayer().getName().equals(client.getPlayer().getName())){
		//int input = scanner.nextInt();
		
		/*switch (input) {

			System.exit(0);
		}}, (long) timeOutAction); */
		System.out.println("\nChoose: 1)Do an action 2)Print the board 3)Quit");
		
		

		
		
	
		//String inputLine = scanner.nextLine();
		
		
		String input = in.readLine();
		System.out.println(input);
		timer.cancel();
		
		switch (input) {
		case "1": {
			Relative relative = chooseTheRelative();
			int servant = chooseServants(relative);
			serverStub.notifyObserver(new SetServant(servant, client.getPlayer(), relative, client.getPlayer().getMatch()));
			PutRelative putRelative = chooseTheAction(relative);
			serverStub.notifyObserver(putRelative);
			break;
		}
		case "2": {
			printTheBoard();
			break;
		}
		case "3": {
			
			serverStub.notifyObserver(new Quit(client.getPlayer(), client.getPlayer().getMatch()));
			client.setQuit(true);
			
			int input0 = in.read();
			
			switch(input0){
			case 0: 
				System.out.println("reconnect");
				serverStub.notifyObserver(new Reconnect(client.getPlayer(), client.getPlayer().getMatch()));
				
			break;
			}
		}
		}}
		/*else{
			scanner.close();
		}*/
		//timer.cancel();
	//	timer=new Timer();

	
		}
		
		

	public void printTheBoard() {
		client.getBoard();
	}

	public Relative chooseTheRelative()
			throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		System.out.println("Il tuo stato è: \n" + client.getPlayer());
		System.out.println("\n\nLa board è: \n" + client.getBoard());
		System.out.println("\n Choose what relative you want to use: \n 1) black \n 2) white \n 3) orange \n 4) neutral");
		Relative relative = null;
		int input = 0;
		//while (!scanner.hasNextInt())
			
		/* try{ */ input = in.read();
		switch (input) {
		case 1: {
			if (client.getPlayer().getBooleanRelative(client.getPlayer().getBlackRelative())) {
				relative = client.getPlayer().getBlackRelative();
				break;
			} else {
				System.out.println("\nYou cannot use this relative, it is already used");
				relative = chooseTheRelative();
				break;
			}

		}
		case 2: {
			if (client.getPlayer().getBooleanRelative(client.getPlayer().getWhiteRelative())) {
				relative = client.getPlayer().getWhiteRelative();
				break;
			} else {
				System.out.println("\nYou cannot use this relative, it is already used");
				relative = chooseTheRelative();
				break;
			}

		}
		case 3: {
			if (client.getPlayer().getBooleanRelative(client.getPlayer().getOrangeRelative())) {
				relative = client.getPlayer().getOrangeRelative();
				break;
			} else {
				System.out.println("\nYou cannot use this relative, it is already used");
				relative = chooseTheRelative();
				break;
			}

		}
		case 4: {
			if (client.getPlayer().getBooleanRelative(client.getPlayer().getNeutralRelative())) {
				relative = client.getPlayer().getNeutralRelative();
				break;
			} else {
				System.out.println("\nYou cannot use this relative, it is already used");
				relative = chooseTheRelative();
				break;
			}

		}
		default: {
			System.out.println("\nError: insert again");
			relative = chooseTheRelative();
			break;
		}
		}
		/*
		 * } catch(InputMismatchException e){
		 * System.out.println("\nError: insert again"); relative=
		 * chooseTheRelative(); return relative; }
		 */
		return relative;
	}

	public int chooseServants(Relative relative) throws IOException {
		System.out.println("\nHow many servants do you want to use?");
		boolean legalServant = false; // loop until a legal servant numbers is
										// given
		int valueServant = 0;
		while (!legalServant) {
			valueServant = in.read();
		//	System.out.println("il client ha servi: "+client.getPlayer().getServant());
			if (valueServant <= client.getPlayer().getServant()) {
				relative.setValueServant(valueServant);
				// client.getPlayer().decrementServant(valueServant);
				legalServant = true;
			} else {
				System.out.println(
						"\nNot enough servant, you have only " + client.getPlayer().getServant() + " servant.");
			}
		}
		System.out.println("\nThe value of the relative with servant is  " + relative.getValue());
		return valueServant;
	}

	public PutRelative chooseTheAction(Relative relative)
			throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {

		System.out.println("\nChoose where you want to put the relative:");
		System.out.println("1) Tower");
		System.out.println("2) CouncilPalace");
		System.out.println("3) Market");
		System.out.println("4) HarvestArea");
		System.out.println("5) ProductionArea");

		PutRelative putRelative = null;
		//while (!scanner.hasNextInt())
			//scanner.next();
		/* try{ */int input = in.read();
		switch (input) {
		case 1: {
			Tower tower = chooseTower();
			int floor = chooseFloor();
			putRelative = chooseThePutRelativeOnTower(tower, floor, relative);
			break;
		}
		case 2: {
			String bonus = choosePrivilegeCouncil();
			putRelative = new PutRelativeOnCouncilPalace(client.getPlayer(), relative,
					client.getBoard().getCouncilPalace(), bonus, client.getPlayer().getMatch());
			break;
		}
		case 3: {
			if (client.getBoard().getNumberOfPlayers() == 4) {
				System.out.println(
						"\nChoose the market to put your relative: \n 1)Gain coin \n 2)Gain servant \n 3)Gain military point and coin \n 4)Gain two different privilege Council");
				int number = in.read();
				MarketBuilding market = client.getMarket(number);
				if (number == 4) {
					putRelative = new PutRelativeOnMarketPrivilege(client.getPlayer(), relative, market,
							choosePrivilegeCouncil(), client.getPlayer().getMatch());
				} else {
					putRelative = new PutRelativeOnMarket(client.getPlayer(), relative, market, client.getPlayer().getMatch());
				}
			} else {
				System.out.println("\nChoose the market to put your relative: \n 1)Gain coin \n 2)Gain servant");
				int number = in.read();
				MarketBuilding market = client.getMarket(number - 1);
				putRelative = new PutRelativeOnMarket(client.getPlayer(), relative, market, client.getPlayer().getMatch());
			}
			break;
		}
		case 4: {
			String harvestArea = chooseHarvestArea();
			putRelative = new PutRelativeOnHarvestArea(client.getPlayer(), relative, client.getBoard().getHarvestArea(),
					harvestArea, client.getPlayer().getMatch());

			break;
		}
		case 5: {
			String productionArea = chooseProductionArea();
			putRelative = new PutRelativeOnProductionArea(client.getPlayer(), relative,
					client.getBoard().getProductionArea(), productionArea, client.getPlayer().getMatch());

			break;
		}
		default: {
			System.out.println("Try again");
			putRelative = chooseTheAction(relative);
		}
		}
		/*
		 * } catch(InputMismatchException e){
		 * System.out.println("\nError: insert again"); putRelative =
		 * chooseTheAction(relative);
		 * 
		 * }
		 */

		return putRelative;
	}

	public PutRelative chooseThePutRelativeOnTower(Tower tower, int floor, Relative relative) throws IOException {
		PutRelative putRelative = null;
		switch (tower.getType()) {
		case "territory": {
			if (client.getBoard().getTerritoryTower().getFloor(floor).getCard() != null) {
				if (client.getBoard().getTerritoryTower().getFloor(floor).getCard().getGainPrivilegeCouncil()) {
					String bonus = choosePrivilegeCouncil();
					putRelative = new PutRelativeOnTowerPrivilege(client.getPlayer(), tower, floor, relative, bonus, client.getPlayer().getMatch());
				} else {
					putRelative = new PutRelativeOnTower(client.getPlayer(), tower, floor, relative, client.getPlayer().getMatch());
				}
			} else {
				System.out.println("It is occupied by another player. Choose again!");
				try {
					chooseTheAction(relative);
				} catch (NullPointerException | IOException | ParseException | InterruptedException e) {
					e.printStackTrace();
				}
			}
			break;
		}
		case "building": {
			putRelative = new PutRelativeOnTower(client.getPlayer(), tower, floor, relative, client.getPlayer().getMatch());
			break;
		}
		case "character": {
			if (client.getBoard().getCharacterTower().getFloor(floor).getCard()!=null && client.getBoard().getCharacterTower().getFloor(floor).getCard().getGetCard()) {
				Tower tower2 = chooseTower();
				int floor2 = chooseFloor();
				putRelative = new PutRelativeOnTowerDoubleCard(client.getPlayer(), tower, floor, relative, tower2,
						floor2, client.getPlayer().getMatch());
			} else {
				putRelative = new PutRelativeOnTower(client.getPlayer(), tower, floor, relative, client.getPlayer().getMatch());
			}
			break;
		}
		case "venture": {
			if (client.getBoard().getVentureTower().getFloor(floor).getCard().getAlternativeCost()) {
				putRelative = new PutRelativeOnTowerAltCost(client.getPlayer(), tower, floor, relative,
						chooseAlternativeCost(), client.getPlayer().getMatch());
			} else if (client.getBoard().getVentureTower().getFloor(floor).getCard().getGainPrivilegeCouncil()) {
				String bonus = choosePrivilegeCouncil();
				putRelative = new PutRelativeOnTowerPrivilege(client.getPlayer(), tower, floor, relative, bonus, client.getPlayer().getMatch());
			} else {
				putRelative = new PutRelativeOnTower(client.getPlayer(), tower, floor, relative, client.getPlayer().getMatch());
			}
			break;
		}
		}
		return putRelative;
	}

	private boolean chooseAlternativeCost() throws IOException {
		boolean choice = false;
		System.out.println("\nChoose if you prefer: \n 1)military cost \n 2)the other cost");
		/* try{ */
		//while (!scanner.hasNextInt())
			//scanner.next();
		int input = in.read();
		switch (input) {
		case 1: {
			choice = true;
			return choice;
		}
		case 2: {
			choice = false;
			return choice;
		}
		default: {
			System.out.println("\nError: insert again");
			choice = chooseAlternativeCost();
		}
		}
		/*
		 * } catch(InputMismatchException e){
		 * System.out.println("\nError: insert again"); choice =
		 * chooseAlternativeCost();
		 * 
		 * }
		 */
		return choice;
	}

	public Tower chooseTower() throws IOException {

		System.out.println("\nChoose the tower:");
		System.out.println("1) Territory tower");
		System.out.println("2) Building tower");
		System.out.println("3) Character tower");
		System.out.println("4) Venture tower");
	//	while (!scanner.hasNextInt())
	//		scanner.next();
		int input = in.read();
		Tower tower;
		/* try{ */
		switch (input) {
		case 1: {
			tower = this.client.getTerritoryTower();
			return tower;
		}
		case 2: {
			tower = this.client.getBuildingTower();
			return tower;
		}
		case 3: {
			tower = this.client.getCharacterTower();
			return tower;
		}
		case 4: {
			tower = this.client.getVentureTower();
			return tower;
		}
		default: {
			System.out.println("\nError: insert again");
			tower = chooseTower();
			return tower;
		}
		}
		/*
		 * } catch(InputMismatchException e){
		 * System.out.println("\nError: insert again"); tower = chooseTower();
		 * 
		 * }
		 */
		// return null;
	}

	public int chooseFloor() throws IOException {
		System.out.println("\nChoose the number of the floor:");
		int floor;
		//while (!scanner.hasNextInt())
			//scanner.next();
		/* try{ */floor = in.read();
		floor -= 1;
		if (floor < 0 || floor > 4) {
			System.out.println("\nThat floor don't exist!");
			floor = chooseFloor();
		}
		/*
		 * } catch(InputMismatchException e){
		 * System.out.println("\nError: insert again"); floor = chooseFloor(); }
		 */

		return (floor);
	}

	public String choosePrivilegeCouncil() {

		System.out.println("\nChoose the privilege Council:");
		System.out.println("1) 2 coin");
		System.out.println("2) 1 wood and 1 Stone");
		System.out.println("3) 1 servant");
		System.out.println("4) 1 faithPoint");
		System.out.println("5) 2 militaryPoint");
		String resource = null;
		int choice = 0;
		//while (!scanner.hasNextInt())
			//scanner.next();
		/* try{ */try {
			choice = in.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}// }
		/*
		 * catch(InputMismatchException e){
		 * System.out.println("\nError: insert again");
		 * choosePrivilegeCouncil(); }
		 */
		switch (choice) {
		case 1: {
			resource = "coin";
			break;
		}
		case 2: {
			resource = "woodAndStone";
			break;
		}
		case 3: {
			resource = "servant";
			break;
		}
		case 4: {
			resource = "faithPoint";
			break;
		}
		case 5: {
			resource = "militaryPoint";
			break;
		}
		}
		if (choice < 1 || choice > 5) {
			System.out.println("\nError: insert again");
			choosePrivilegeCouncil();
		}

		return resource;
	}

	public String chooseHarvestArea() {
		String harvestArea = null;
		int choice = 0;
		if (client.getBoard().getNumberOfPlayers() >= 3) {
			System.out.println("sono entrato nell'if");
			if (client.getBoard().getHarvestArea().getLeftRelative() != null) {
				System.out.println("\nThe left area is occupied. You can only put on the right area");
				harvestArea = "right";
			}
			// Choose if you want to place the relative left or right
			System.out.println("\nChoose where you want to put your relative: \n1) left \n2) right");
		//	while (!scanner.hasNextInt())
			//	scanner.next();
			/* try{ */try {
				choice = in.read();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}// }
			/*
			 * catch(InputMismatchException e){
			 * System.out.println("\nError: insert again"); chooseHarvestArea();
			 * }
			 */
			if (choice < 1 || choice > 2) {
				System.out.println("\nError: insert again");
				chooseHarvestArea();
			}
			switch (choice) {
			case 1: {
				harvestArea = "left";
				break;
			}
			case 2: {
				harvestArea = "right";
			}
			}
			return harvestArea;
		} else {
			harvestArea = "left";
			return harvestArea;
		}
	}

	public String chooseProductionArea() {
		String productionArea = null;
		int choice = 0;
		if (client.getBoard().getNumberOfPlayers() >= 3) {
			if (client.getBoard().getProductionArea().getLeftRelative() != null) {
				System.out.println("\nThe left area is occupied. You can only put on the right area");
				productionArea = "right";
			}
			// Choose if you want to place the relative left or right
			System.out.println("\nChoose where you want to put your relative: \n1) left \n2) right");
			//while (!scanner.hasNextInt())
			//	scanner.next();
			/* try{ */try {
				choice = in.read();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}// }
			/*
			 * catch(InputMismatchException e){
			 * System.out.println("\nError: insert again");
			 * chooseProductionArea(); }
			 */
			if (choice < 1 || choice > 2) {
				System.out.println("\nError: insert again");
				chooseProductionArea();
			}
			switch (choice) {
			case 1: {
				productionArea = "left";
				break;
			}
			case 2: {
				productionArea = "right";
			}
			}
			return productionArea;
		} else {
			productionArea = "left";
			return productionArea;
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}


	
	


}
