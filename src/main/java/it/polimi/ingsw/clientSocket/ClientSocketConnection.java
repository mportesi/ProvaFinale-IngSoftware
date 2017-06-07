package it.polimi.ingsw.clientSocket;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import it.polimi.ingsw.GC_40.Player;

public class ClientSocketConnection {

	private final static int PORT = 29999;
	private final static String IP = "127.0.0.1";

	public void startClient() throws UnknownHostException, IOException {

		Socket socket = new Socket(IP, PORT);

		System.out.println("Connection created");
		
		Player player= new Player();

		ExecutorService executor = Executors.newFixedThreadPool(2);

		//Creates one thread to send messages to the server
		executor.submit(new ClientOutHandler(
				new ObjectOutputStream(socket.getOutputStream())));

		//Creates one thread to receive messages from the server
		executor.submit(new ClientInHandler(
				new ObjectInputStream(socket.getInputStream())));
	}
	

}

