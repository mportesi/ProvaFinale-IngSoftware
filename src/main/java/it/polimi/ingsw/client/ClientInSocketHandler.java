package it.polimi.ingsw.client;

import java.util.Scanner;

public class ClientInSocketHandler implements Runnable{

	private Scanner socketIn;

	public ClientInSocketHandler(Scanner scanner) {
		this.socketIn = scanner;
	}

	public void run() {
		while (true) {
			//da cambiare perchè line verrà presa da CLI
			// reads a new Line from the Scanner
			String line = socketIn.nextLine();
			
		}
	}
}
