package it.polimi.ingsw.clientSocket;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import it.polimi.ingsw.client.CommandLineInterface;

public class ClientOutHandler implements Runnable {

	private ObjectOutputStream socketOut;

	public ClientOutHandler(ObjectOutputStream socketOut) {
		this.socketOut = socketOut;
	}

	@Override
	public void run() {

		// Handles output messages, from the client to the server
		System.out.println("RUNNING");
		Scanner stdIn = new Scanner(System.in);

		while (true) {
			
			String input = stdIn.nextLine();
			Object action;
			try {
				// Implements the communication protocol
			action=CommandLineInterface.chooseTheAction();
			
			socketOut.writeObject(action);
			socketOut.flush();
			}catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}
}

