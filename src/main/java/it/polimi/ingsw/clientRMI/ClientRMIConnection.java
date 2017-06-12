package it.polimi.ingsw.clientRMI;

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

		//System.out.println("inizio");
		ClientRMIConnectionView rmiView = new ClientRMIConnectionView(clientModel);

		System.out.println("Tell me your name");
		String name = stdIn.nextLine();
		
		// serverStub.initializeGame(rmiView);
		// register the client view in the server side (to receive messages from
		// the server)
		serverStub.registerClient(rmiView, name);
		if (clientModel.getStartPlay() == true) {
			serverStub.initializeGame(rmiView);
			//CommandLineInterface commandLineInterface = new CommandLineInterface(clientModel.getPlayer(), clientModel);
		}

		while ((clientModel.getStartPlay() == true) && (clientModel.getCurrentPlayer().getName().equals(clientModel.getPlayer().getName()))) {
			// Capture input from user
			CommandLineInterface commandLineInterface = new CommandLineInterface(clientModel.getPlayer(), clientModel);
			System.out.println("Press a key to start the action");
			//commandLineInterface.printTheBoard();
			String inputLine = stdIn.nextLine();
			System.out.println("SENDING " + inputLine);
			PutRelative putRelative = commandLineInterface.chooseTheAction();
			serverStub.notifyObserver(putRelative);
			ShiftPlayer shiftPlayer= new ShiftPlayer();
			serverStub.notifyObserver(shiftPlayer);
		}
	}

}
