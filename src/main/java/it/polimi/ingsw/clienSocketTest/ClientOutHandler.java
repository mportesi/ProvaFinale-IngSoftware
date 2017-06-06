package it.polimi.ingsw.clienSocketTest;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

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
			
			// TODO ask player the action he want to do
			switch (input) {
			case "PutRelativeOnTower":
				

			default:
				break;
			}

		}
	}
}
