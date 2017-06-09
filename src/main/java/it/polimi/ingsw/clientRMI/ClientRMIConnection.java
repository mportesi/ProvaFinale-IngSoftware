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
		private int RMI_PORT;
		private String HOST;
		private String NAME = "Lorenzo Il Magnifico";
		private CommandLineInterface commandLineInterface;
		private ClientModel client;
		
		public ClientRMIConnection(int rmi_port, String host){
			RMI_PORT=rmi_port;
			HOST=host;
		}

		public  void startClient() throws RemoteException, NotBoundException, AlreadyBoundException, IOException, NullPointerException, ParseException {
			client= new ClientModel();
			commandLineInterface=new CommandLineInterface();
			Scanner stdIn = new Scanner(System.in);
			//System.setProperty("java.rmi.server.hostname", "192.168.1.2");
			
			//Get the remote registry
			Registry registry = LocateRegistry.getRegistry(HOST, RMI_PORT);
			
			//get the stub (local object) of the remote view
			ServerRMIConnectionViewRemote serverStub = (ServerRMIConnectionViewRemote) registry.lookup(NAME);
			
			System.out.println("Tell me your name");
			String name= stdIn.nextLine();
			// register the client view in the server side (to receive messages from the server)


			ClientRMIConnectionView rmiView=new ClientRMIConnectionView(client);
			
		//	serverStub.initializeGame(rmiView);
			// register the client view in the server side (to receive messages from the server)
			serverStub.registerClient(rmiView, name);
			serverStub.initializeGame(rmiView);
			
			

			
			
			while (true) {
				//Capture input from user
				String inputLine = stdIn.nextLine();
				System.out.println("SENDING "+inputLine);
				PutRelative putRelative= commandLineInterface.chooseTheAction();
				serverStub.notifyObserver(putRelative);
			}
		}

	
}
