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
	private Player player;
	private static ClientModel clientModel;

	public static void main(String[] args) throws IOException, AlreadyBoundException, NotBoundException, NullPointerException, ParseException {

		Scanner in = new Scanner(System.in);
		String host = "127.0.0.1";
		int rmi=52365;
		//int socket = 29999;
		
		System.out.println("Welcome to Lorenzo il Magnifico \n");
		System.out.println("Select how you want to play:\n");
		System.out.println("1) Command Line Interface (CLI)");
		System.out.println("2) Graphical User Interface (GUI)");

		int input = in.nextInt();
		if (input == 1) {
			System.out.println("Select your connection:\n");
			System.out.println("1) Socket");
			System.out.println("2) Remote Method Invocation (RMI)");
			input = in.nextInt();

			if (input != 1 && input != 2) {
				System.out.println("Not valid value inserted");
			} else {
				if (input == 1) {
					ClientSocketConnection client = new ClientSocketConnection();

					client.startClient();
				} else {

					ClientRMIConnection client = new ClientRMIConnection();
					ClientRMIConnectionView clientView = new ClientRMIConnectionView(clientModel);
					client.startClient();
				}

			}
		}
	}

	public void setPlayer(Player player) {
		// TODO Auto-generated method stub
		this.player = player;

	}
}
