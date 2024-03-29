package it.polimi.ingsw.client;

import java.util.ArrayList;
import java.util.Scanner;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.GC_40.Player;
import it.polimi.ingsw.actions.PutRelative;
import it.polimi.ingsw.actions.ShiftPlayer;
import it.polimi.ingsw.clientRMI.ClientRMIConnection;
import it.polimi.ingsw.clientRMI.ClientRMIConnectionView;
import it.polimi.ingsw.clientSocket.ClientSocketConnection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.nio.channels.AlreadyBoundException;
import java.rmi.NotBoundException;

/**
 * @author Sara
 * It is the class that starts the client with the command line.
 * It contains the method main that ask for the connection and start the chosen one.
 */
public class Client implements Serializable {
	private Player player;
	// private static ClientModel clientModel;

	public static void main(String args[]) throws IOException, AlreadyBoundException, NotBoundException,
			NullPointerException, ParseException, InterruptedException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String host = "127.0.0.1";
		int rmi_port = 52365;
		
		System.out.println("Welcome to Lorenzo il Magnifico \n");
			System.out.println("Choose your connection:\n");
			System.out.println("1) Socket");
			System.out.println("2) Remote Method Invocation");
			
			int input = Integer.parseInt(in.readLine());
			if (input != 1 && input != 2) {
				System.out.println("Not valid value inserted");
			} else {
				if (input == 1) {
					ClientSocketConnection client = new ClientSocketConnection();
					client.startClient(true);
				} else {
					ClientRMIConnection client = new ClientRMIConnection(rmi_port, host);
					client.startClient(true);
				}
		}
		
		
	}
}
