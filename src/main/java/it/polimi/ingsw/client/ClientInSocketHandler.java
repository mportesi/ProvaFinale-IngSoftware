package it.polimi.ingsw.client;

import java.io.IOException;
import java.util.Scanner;

public class ClientInSocketHandler implements Runnable{

	private ConnectionHandler handler;
	private ClientView clientView;
	

	public ClientInSocketHandler(ConnectionHandler handler, ClientView clientView) {
		//this.socketIn = scanner;
		this.handler=handler;
		this.clientView=clientView;
	}

	public void run() {
		while (true) {
			Object x = new Object();
			try {
				 x = handler.receiveFromServer();
			} catch (ClassNotFoundException | IOException e) {
				System.out.println("THE GAME IS FINISHED - BYE BYE");
				break;
			}
			
			// TODO insert if for change, like if(x.getClass().equals(SomeChange.class)) --> modify the client model
		}
	}
	
	
}
