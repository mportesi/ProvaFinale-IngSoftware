package it.polimi.ingsw.client;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.Scanner;


//forse cambiare nome in client
public class ClientSocketConnection{
	//create the port for the connection
	private final static int PORT = 29999; 
	private final static String IP = "127.0.0.1";

	public void startClientSocketConnection() throws IOException {
		//create a new socket 
		Socket socket = new Socket(IP, PORT);
		System.out.println("Connection Established");
		//create the thread pool
		ExecutorService executor = Executors.newFixedThreadPool(2);
		//use the clientInSocketHandler to connect to get the message from the server
		executor.submit(new ClientInSocketHandler(new Scanner(socket.getInputStream())));
		//use the clientOutSocketHandler to connect to send the message to the server
		executor.submit(new ClientOutSocketHandler(new PrintWriter(socket.getOutputStream())));
	}

	/*public static void main(String[] args) {

		ClientSocketConnection client = new ClientSocketConnection();
		try {
			// runs the Client
			client.startClientSocketConnection();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}*/

}
