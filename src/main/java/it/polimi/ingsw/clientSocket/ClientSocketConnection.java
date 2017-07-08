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
	private ObjectOutputStream out;
	private ObjectInputStream in;
	private Socket socket;

	public void startClient(boolean commandLine) throws UnknownHostException, IOException {
		socket = new Socket(IP, PORT);

		System.out.println("Connection created");
		
		 out=new ObjectOutputStream(socket.getOutputStream());
		in=new ObjectInputStream(socket.getInputStream());
		
		clientModel = new ClientModel(true,out);
		
		
		if(commandLine){
		ExecutorService executor = Executors.newFixedThreadPool(2);

		//Creates one thread to send messages to the server
		executor.submit(new ClientOutHandler(out, clientModel, commandLine));

		//Creates one thread to receive messages from the server
		executor.submit(new ClientInHandler(in, clientModel));}
	}
	
	public ClientModel getClientModel(){
		return clientModel;
	}
	
	public ObjectOutputStream getObjectOutput(){
		return out;
	}
	
	public ObjectInputStream getObjectInput(){
		return in;
	}
	
	public Socket getSocket(){
		return socket;
	}
	

}

