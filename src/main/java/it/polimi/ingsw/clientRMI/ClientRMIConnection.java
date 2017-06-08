package it.polimi.ingsw.clientRMI;

import java.io.IOException;
import java.nio.channels.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.GC_40.Observer;
import it.polimi.ingsw.actions.PutRelative;
import it.polimi.ingsw.changes.Change;
import it.polimi.ingsw.client.ClientModel;
import it.polimi.ingsw.client.CommandLineInterface;
import it.polimi.ingsw.serverRMI.ServerRMIConnectionViewRemote;


public class ClientRMIConnection{
		//TODO METTERE QUESTI DATI NEL COSTRUTTORE E CHIAMARE IN CLIENT IL COSTRUTTORE
		private final static int RMI_PORT = 52365;

		private final static String HOST = "127.0.0.1";

		private final static int PORT = 52365;
	
		private static final String NAME = "Lorenzo Il Magnifico";
		
		private CommandLineInterface commandLineInterface;
		private ClientModel client;

		public  void startClient() throws RemoteException, NotBoundException, AlreadyBoundException, IOException, NullPointerException, ParseException {
			client= new ClientModel();
			commandLineInterface=new CommandLineInterface();
			//System.setProperty("java.rmi.server.hostname", "192.168.1.2");
			//Get the remote registry
			Registry registry = LocateRegistry.getRegistry(HOST, PORT);
			
			//get the stub (local object) of the remote view
			ServerRMIConnectionViewRemote serverStub = (ServerRMIConnectionViewRemote) registry.lookup(NAME);
			serverStub.initializeGame();
			ClientRMIConnectionView rmiView=new ClientRMIConnectionView(client);
			
			
			// register the client view in the server side (to receive messages from the server)
			serverStub.registerClient(rmiView);
			
			
			Scanner stdIn = new Scanner(System.in);

			while (true) {
				//Capture input from user
				String inputLine = stdIn.nextLine();
				System.out.println("SENDING "+inputLine);
				PutRelative putRelative= commandLineInterface.chooseTheAction();
				serverStub.notifyObserver(putRelative);
			}
		}

	
}
