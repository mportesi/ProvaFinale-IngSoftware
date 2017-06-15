package it.polimi.ingsw.clientSocket;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import it.polimi.ingsw.GC_40.Player;
import it.polimi.ingsw.client.ClientModel;

public class ClientSocketConnection {

	private final static int PORT = 29999;
	private final static String IP = "127.0.0.1";
	private ClientModel clientModel;

	public void startClient() throws UnknownHostException, IOException {
		clientModel = new ClientModel();
		Socket socket = new Socket(IP, PORT);

		System.out.println("Connection created");
		
		

		ExecutorService executor = Executors.newFixedThreadPool(2);

		//Creates one thread to send messages to the server
		executor.submit(new ClientOutHandler(
				new ObjectOutputStream(socket.getOutputStream()), clientModel));

		//Creates one thread to receive messages from the server
		executor.submit(new ClientInHandler(
				new ObjectInputStream(socket.getInputStream()), clientModel));
	}
	

}

