package it.polimi.ingsw.server;

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

import it.polimi.ingsw.GC_40.Controller;
import it.polimi.ingsw.GC_40.Play;
import it.polimi.ingsw.serverSocket.ServerSocketConnectionView;

public class Server {

	//Main class from the server side
	private final static int PORT = 29999;
	private final static int RMI_PORT = 52365;

	private Play gioco;

	private Controller controller;

	public Server() {
		this.gioco = new Play();
		//this.controller = new Controller(gioco);

	}
	
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
			ServerSocketConnectionView view = new ServerSocketConnectionView(socket);

			// the view observes the model
			this.gioco.registerObserver(view);

			// the controller observes the view
			view.registerObserver(this.controller);

			// a new thread handle the connection with the view
			executor.submit(view);
		}
	}

	public static void main(String[] args) throws IOException, AlreadyBoundException {
		Server server = new Server();
		System.out.println("START SOCKET");
		server.startSocket();
	}
}
