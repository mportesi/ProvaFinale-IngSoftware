package it.polimi.ingsw.client;

import java.util.Scanner;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.GC_40.Player;
import it.polimi.ingsw.clientRMI.ClientRMIConnection;
import it.polimi.ingsw.clientRMI.ClientRMIConnectionView;
import it.polimi.ingsw.clientSocket.ClientSocketConnection;

import java.io.IOException;
import java.nio.channels.AlreadyBoundException;
import java.rmi.NotBoundException;

public class Client {

	public static void main(String[] args)
			throws IOException, AlreadyBoundException, NotBoundException, NullPointerException, ParseException {

		Scanner in = new Scanner(System.in);
		String host = "127.0.0.1";
		int rmi_port = 52365;
		// int socket = 29999;

		while (true) {
			System.out.println("WELCOME");
			System.out.println("This is Lorenzo il Magnifico \n");
			System.out.println("Choose what you prefer:\n");
			System.out.println("1) Command Line Interface");
			System.out.println("2) Graphical User Interface");

			int input = in.nextInt();
			if (input == 1) {
				System.out.println("Select your connection:\n");
				System.out.println("1) Socket");
				System.out.println("2) Remote Method Invocation");
				input = in.nextInt();

				if (input != 1 && input != 2) {
					System.out.println("Not valid value inserted");
				} else {
					if (input == 1) {
						ClientSocketConnection client = new ClientSocketConnection();
						client.startClient();
					} else {
						ClientRMIConnection client = new ClientRMIConnection(rmi_port, host);
						client.startClient();
					}

				}
			}
		}
	}
}
