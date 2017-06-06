package it.polimi.ingsw.clientRMI;

import java.io.IOException;
import java.nio.channels.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

import it.polimi.ingsw.actions.PutRelative;
import it.polimi.ingsw.client.CommandLineInterface;
import it.polimi.ingsw.serverRMI.ServerRMIConnectionViewRemote;


public class ClientRMIConnection {
		private final static int RMI_PORT = 52365;

		private final static String HOST = "127.0.0.1";

		private final static int PORT = 52365;
	
		private static final String NAME = "Lorenzo Il Magnifico";
		
		private CommandLineInterface commandLineInterface;

		public  void RMIConnection() throws RemoteException, NotBoundException, AlreadyBoundException {
			commandLineInterface=new CommandLineInterface();
			//Get the remote registry
			Registry registry = LocateRegistry.getRegistry(HOST, PORT);

			//get the stub (local object) of the remote view
			ServerRMIConnectionViewRemote serverStub = (ServerRMIConnectionViewRemote) registry.lookup(NAME);

			ClientRMIConnectionView rmiView=new ClientRMIConnectionView();

			// register the client view in the server side (to receive messages from the server)
			serverStub.registerClient(rmiView);
			
			
			
			Scanner stdIn = new Scanner(System.in);

			while (true) {
				//Capture input from user
				String inputLine = stdIn.nextLine();
				System.out.println("SENDING "+inputLine);
				try {
					PutRelative putRelative= commandLineInterface.chooseTheAction();
					serverStub.notifyObserver(putRelative);
					}
				 catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		}

	
}
