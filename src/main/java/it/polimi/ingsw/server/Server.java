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
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.GC_40.Controller;
import it.polimi.ingsw.GC_40.Play;
import it.polimi.ingsw.actions.Action;
import it.polimi.ingsw.clientRMI.ClientRMIConnectionViewRemote;
import it.polimi.ingsw.serverRMI.ServerRMIConnectionView;
import it.polimi.ingsw.serverRMI.ServerRMIConnectionViewRemote;

import it.polimi.ingsw.serverSocket.ServerSocketView;

@SuppressWarnings("unused")
public class Server {

	//Main class from the server side
	private final static int PORT = 29999;
	private final static int RMI_PORT = 52365;

	private ArrayList<Play> play;
	private int numberOfPlayers;
	private ArrayList<Controller> controller;
	private ArrayList<ServerRMIConnectionView> serverRMIConnectionView;
	
	
	private final String NAME="Lorenzo Il Magnifico";

	public Server() throws FileNotFoundException, NullPointerException, IOException, ParseException {
		play=new ArrayList<>();
		this.play.add( new Play(0));
		this.controller = new ArrayList<>();
		this.controller.add(new Controller(play.get(0)));

	}
	
	public void setNumberOfPlayers(int n){
		numberOfPlayers=n;
	}
	/*private void startSocket() throws IOException {

		// creates the thread pool to handle clients
		ExecutorService executor = Executors.newCachedThreadPool();

		//creats the socket
		ServerSocket serverSocket = new ServerSocket(PORT);

		System.out.println("SERVER SOCKET READY ON PORT" + PORT);

		while (true) {
			//Waits for a new client to connect
			Socket socket = serverSocket.accept();

			// creates the view (server side) associated with the new client
			ServerSocketView view = new ServerSocketView(socket, play);

			// the view observes the model
			this.gioco.registerObserver(view);

			// the controller observes the view
			view.registerObserver(this.controller);

			// a new thread handle the connection with the view
			executor.submit(view);
		}
	}*/
	
	public void startRMI() throws AlreadyBoundException, FileNotFoundException, NullPointerException, IOException, ParseException{
		Registry registry =LocateRegistry.createRegistry(RMI_PORT);
		System.out.println("constructing the rmi registry");
		serverRMIConnectionView=new ArrayList<>();
		serverRMIConnectionView.add(new ServerRMIConnectionView(this, 0));
		serverRMIConnectionView.get(0).registerObserver(this.controller.get(0));
		this.play.get(0).registerObserver(serverRMIConnectionView.get(0));
		ServerRMIConnectionViewRemote serverRMIConnectionViewRemote=(ServerRMIConnectionViewRemote) UnicastRemoteObject.exportObject(serverRMIConnectionView.get(0), 0);
		System.out.println("binding the server implementation to the registry");
		registry.bind(NAME, serverRMIConnectionView.get(0));
		
		while(true){
			if(numberOfPlayers>4){
				int i=1;
				this.play.add(new Play(i));
				this.controller.add(new Controller(play.get(i)));
				serverRMIConnectionView.add(new ServerRMIConnectionView(this, i));
				serverRMIConnectionView.get(i).registerObserver(this.controller.get(i));
				this.play.get(i).registerObserver(serverRMIConnectionView.get(i));
				serverRMIConnectionViewRemote=(ServerRMIConnectionViewRemote) UnicastRemoteObject.exportObject(serverRMIConnectionView.get(i), 0);
				System.out.println("binding the server implementation to the registry");
				registry.bind(NAME, serverRMIConnectionView.get(i));
				i++;
			}
			
		}
	}

	public static void main(String[] args) throws IOException, AlreadyBoundException, NullPointerException, ParseException {
		Server server = new Server();
		/*System.out.println("START SOCKET");
		server.startSocket();*/
		System.out.println("START RMI");
		server.startRMI();
	}
}
