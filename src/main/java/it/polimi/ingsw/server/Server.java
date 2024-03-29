package it.polimi.ingsw.server;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.GC_40.Controller;
import it.polimi.ingsw.GC_40.MasterController;
import it.polimi.ingsw.GC_40.Play;
import it.polimi.ingsw.actions.Action;
import it.polimi.ingsw.clientRMI.ClientRMIConnectionViewRemote;
import it.polimi.ingsw.serverRMI.ServerRMIConnectionView;
import it.polimi.ingsw.serverRMI.ServerRMIConnectionViewRemote;

import it.polimi.ingsw.serverSocket.ServerSocketView;
/**
 * @author Sara
 * This is the main server.
 * It contains the main method that allows to play to the game and to connect to it.
 * It initialize the master controller that is necessary to handle more matches.
 * It starts both the server socket and the server rmi.
 */
@SuppressWarnings("unused")
public class Server {

	//Main class from the server side
	private final static int PORT = 29999;
	private final static int RMI_PORT = 52365;

	//private Play play;

	private MasterController masterController;
	
	
	private final String NAME="Lorenzo Il Magnifico";

	public Server() throws FileNotFoundException, NullPointerException, IOException, ParseException {
	//	this.play = new Play();
		this.masterController = new MasterController();
	}
	/**
	 * @author Sara
	 * This is the method that starts the socket connection. It registers the observer of the view
	 */
	private void startSocket() throws IOException {

		// creates the thread pool to handle clients
		ExecutorService executor = Executors.newCachedThreadPool();

		//creats the socket
		ServerSocket serverSocket = new ServerSocket(PORT);

		System.out.println("SERVER SOCKET READY ON PORT" + PORT);
		
		while (true) {
			//Waits for a new client to connect
			Socket socket = serverSocket.accept();

			// creates the view (server side) associated with the new client
			ServerSocketView view = new ServerSocketView(socket,this);

			// the controller observes the view
			view.registerObserver(this.masterController);

			// a new thread handle the connection with the view
			executor.submit(view);
		}
	} 
	/**
	 * @author Sara
	 * This is the method that starts the rmi connection. It registers the observer of the view, 
	 * it binds the registry to the server connection view remote.
	 */
	public void startRMI() throws RemoteException, AlreadyBoundException{
		Registry registry =LocateRegistry.createRegistry(RMI_PORT);
		System.out.println("constructing the rmi registry");
		ServerRMIConnectionView serverRMIConnectionView= new ServerRMIConnectionView(this);
		serverRMIConnectionView.registerObserver(this.masterController);
		ServerRMIConnectionViewRemote serverRMIConnectionViewRemote=(ServerRMIConnectionViewRemote) UnicastRemoteObject.exportObject(serverRMIConnectionView, 0);
		System.out.println("binding the server implementation to the registry");
		registry.bind(NAME, serverRMIConnectionView);
		
		
	}

	public static void main(String[] args) throws IOException, AlreadyBoundException, NullPointerException, ParseException {
		Server server = new Server();
		System.out.println("START RMI");
		server.startRMI();
		System.out.println("START SOCKET");
		server.startSocket();
		
	}

	public MasterController getMasterController() {
		return masterController;
	}
}
