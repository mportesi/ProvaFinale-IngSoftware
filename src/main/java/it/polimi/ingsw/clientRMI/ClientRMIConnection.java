package it.polimi.ingsw.clientRMI;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.nio.channels.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Scanner;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.GC_40.Observer;
import it.polimi.ingsw.actions.PutRelative;
import it.polimi.ingsw.actions.ShiftPlayer;
import it.polimi.ingsw.changes.Change;
import it.polimi.ingsw.client.ClientModel;
import it.polimi.ingsw.client.CommandLineInterface;
import it.polimi.ingsw.serverRMI.ServerRMIConnectionViewRemote;

public class ClientRMIConnection implements Serializable {
	private int RMI_PORT;
	private String HOST;
	private String NAME = "Lorenzo Il Magnifico";
	private CommandLineInterface commandLineInterface;
	private ClientModel clientModel;

	public ClientRMIConnection(int rmi_port, String host) {
		RMI_PORT = rmi_port;
		HOST = host;
		// this.clientModel=clientModel;
	}

	public void startClient() throws RemoteException, NotBoundException, AlreadyBoundException, IOException,
			NullPointerException, ParseException, InterruptedException {
		clientModel = new ClientModel();

		Scanner stdIn = new Scanner(System.in);

		// System.setProperty("java.rmi.server.hostname", "192.168.1.2");

		// Get the remote registry
		Registry registry = LocateRegistry.getRegistry(HOST, RMI_PORT);

		// get the stub (local object) of the remote view
		ServerRMIConnectionViewRemote serverStub = (ServerRMIConnectionViewRemote) registry.lookup(NAME);

		// register the client view in the server side (to receive messages from
		// the server)

		// System.out.println("inizio");
		ClientRMIConnectionView rmiView = new ClientRMIConnectionView(clientModel);

		System.out.println("Tell me your name");
		String name = stdIn.nextLine();
		clientModel.setName(name);
		// serverStub.initializeGame(rmiView);
		// register the client view in the server side (to receive messages from
		// the server)
		serverStub.registerClient(rmiView, name);
		/*if (clientModel.getStartPlay() == true) {
			serverStub.initializeGame(rmiView);
			System.out.println("Ho inizializzato il game");*/
			// CommandLineInterface commandLineInterface = new
			// CommandLineInterface(clientModel.getPlayer(), clientModel);
		
		//System.out.println("LO START DI " + clientModel.getPlayer().getName() + "è" + clientModel.getStartPlay());
		//System.out.println(clientModel);
		//System.out.println("!!!!!!!!!!!" +clientModel.getPlayer().getName());
		
		
		while (true) {
			
			
			//
			
			// if(clientModel.getCurrentPlayer()!= null){
			// System.out.println("Il currentPlayer è" +
			// clientModel.getCurrentPlayer().getName());}
			
			/*while ((clientModel.getStartPlay() == true)) {*/
				//System.out.println("SONO NEL PRIMO WHILE DI STARTPLAY");
			
			if(clientModel.getCurrentPlayer()!=null){
				
				while (clientModel.getCurrentPlayer().getName().equals(clientModel.getPlayer().getName())) {
					System.out.println(clientModel.getCurrentPlayer().getName());
					System.out.println(clientModel.getPlayer());
					// Capture input from user
					CommandLineInterface commandLineInterface = new CommandLineInterface(clientModel);
					System.out.println("Press a key to start the action");
		
					String inputLine = stdIn.nextLine();

					// commandLineInterface.printTheBoard();

					PutRelative putRelative = commandLineInterface.chooseTheAction();
					serverStub.notifyObserver(putRelative);
					System.out.println("Il nuovo stato è: " + clientModel.getPlayer());
					ShiftPlayer shiftPlayer = new ShiftPlayer();
					serverStub.notifyObserver(shiftPlayer);
					System.out.println("Il nuovo stato è: " + clientModel.getPlayer());
			}}
		}

	}


}
