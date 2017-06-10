package it.polimi.ingsw.clientSocket;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import it.polimi.ingsw.GC_40.Player;
import it.polimi.ingsw.actions.RegisterClient;
import it.polimi.ingsw.client.ClientModel;
import it.polimi.ingsw.client.CommandLineInterface;

public class ClientOutHandler implements Runnable {

	private ObjectOutputStream socketOut;
	private ClientModel clientModel;
	private CommandLineInterface cli;
	private Player player;
	public ClientOutHandler(ObjectOutputStream socketOut, ClientModel clientModel) {
		this.socketOut = socketOut;
		this.clientModel=clientModel;
		this.player= this.clientModel.getPlayer();
		//cli = new CommandLineInterface(this.clientModel.getPlayer(), clientModel);
	}

	@Override
	public void run() {

		// Handles output messages, from the client to the server
		System.out.println("RUNNING");
		System.out.println("choose your name: ");
		Scanner stdIn = new Scanner(System.in);
		String name= stdIn.nextLine();
		RegisterClient register = new RegisterClient(name);
		cli = new CommandLineInterface(player, clientModel);
		try {
			socketOut.writeObject(register);
			socketOut.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while (true) {
			System.out.println("test the action");
			//String input = stdIn.nextLine();
			Object action;
			action=cli.chooseTheAction();
			System.out.println("test the action");

			try {
				// Implements the communication protocol
			//action=cli.chooseTheAction();
			
			socketOut.writeObject(action);
			socketOut.flush();
			}catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}
}

