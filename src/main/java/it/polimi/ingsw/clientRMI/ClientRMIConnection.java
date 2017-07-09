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
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.GC_40.Observer;
import it.polimi.ingsw.GC_40.TimerAction;
import it.polimi.ingsw.GC_40.TimerActionTry;
import it.polimi.ingsw.actions.PutRelative;
import it.polimi.ingsw.actions.SetServant;
import it.polimi.ingsw.actions.ShiftPlayer;
import it.polimi.ingsw.changes.Change;
import it.polimi.ingsw.client.ClientModel;
import it.polimi.ingsw.client.CommandLineInterface;
import it.polimi.ingsw.components.Relative;
import it.polimi.ingsw.json.JsonTimeOut;
import it.polimi.ingsw.serverRMI.ServerRMIConnectionViewRemote;
/**
 * @author Sara
 * It is the connection for RMI
 * It starts the connection from client to server
 */
public class ClientRMIConnection implements Serializable {
	private int RMI_PORT;
	private String HOST;
	private String NAME = "Lorenzo Il Magnifico";
	private CommandLineInterface commandLineInterface;
	private ClientModel clientModel;
	private ServerRMIConnectionViewRemote serverStub;
	private ClientRMIConnectionView rmiView;

	public ClientRMIConnection(int rmi_port, String host) {
		RMI_PORT = rmi_port;
		HOST = host;
	}
	
	/**
	 * @author Sara
	 * When the client decide to use rmi this method is invoked
	 */
	public void startClient(boolean commandLine) throws RemoteException, NotBoundException, AlreadyBoundException, IOException,
			NullPointerException, ParseException, InterruptedException {
		

		Scanner stdIn = new Scanner(System.in);

		// System.setProperty("java.rmi.server.hostname", "192.168.1.2");

		// Get the remote registry
		Registry registry = LocateRegistry.getRegistry(HOST, RMI_PORT);

		// get the stub (local object) of the remote view
		serverStub = (ServerRMIConnectionViewRemote) registry.lookup(NAME);
		clientModel = new ClientModel(serverStub);
		// register the client view in the server side (to receive messages from
		// the server)

		rmiView = new ClientRMIConnectionView(clientModel);
		String name;
		if(commandLine){
		
		clientModel.setCli(true);
		clientModel.setGui(false);
		System.out.println("\nTell me your name\n");
		name = stdIn.nextLine();
		clientModel.setName(name);
		serverStub.registerClient(rmiView, name);}
		
		}


	public ClientModel getClientModel() {
		return clientModel;
	}


	public ServerRMIConnectionViewRemote getServerStub() {
		return serverStub;
	}
	
	public ClientRMIConnectionView getRmiView() {
		return rmiView;
	}
	
}
