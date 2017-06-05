package it.polimi.ingsw.client;

import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class ClientSocketConnection implements ClientInterface {
	
	private final int port;
	private final String ip;
	private int ID;
	private ClientView clientView;
	private ConnectionHandler handler;
		
	public ClientSocketConnection(String ip, int port, ClientView view) {
		super();
		this.ip = ip;
		this.port = port;
		this.clientView=view;
		
	}
	
	//@return the iD
	public int getID() {
		return ID;
	}

	//@param iD the iD to set
	public void setID(int iD) {
		ID = iD;
	}

	/**
	 * @throws IOException
	 */
	@Override
	public void runClient(String name) throws IOException {
		Socket socket = new Socket(ip, port);
		System.out.println("Connection Established");
		
		ExecutorService executor = Executors.newFixedThreadPool(2);
		this.handler = new SocketConnectionHandler(socket);
		
		try {
			handler.sendToServer(name);
		} catch (IOException e1) {
			throw new IOException("You didn't insert your name in time. You are disconnected");
		}
		
		/*try{
			int id=(Integer)handler.receiveFromServer();
			this.ID=id;
		}
		settare cose del model nella view*/

		executor.submit(new ClientOutSocketHandler(handler, clientView));
		executor.submit(new ClientInSocketHandler(handler, clientView));
		
	}

	@Override
	public ConnectionHandler getConnectionHandler() {
		return handler;
	}
}