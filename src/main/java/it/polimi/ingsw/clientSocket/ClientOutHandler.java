package it.polimi.ingsw.clientSocket;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.GC_40.Player;
import it.polimi.ingsw.actions.InitializeGame;
import it.polimi.ingsw.actions.RegisterClient;
import it.polimi.ingsw.client.ClientModel;
import it.polimi.ingsw.client.CommandLineInterface;
import it.polimi.ingsw.components.Relative;

public class ClientOutHandler implements Runnable {

	private ObjectOutputStream socketOut;
	private ClientModel clientModel;
	private CommandLineInterface cli;
	private Player player;//= new Player();
	public ClientOutHandler(ObjectOutputStream socketOut, ClientModel clientModel) {
		this.socketOut = socketOut;
		this.clientModel=clientModel;
		//this.player= clientModel.getPlayer();
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
		//this.player= clientModel.getPlayer();
		//cli = new CommandLineInterface(player, clientModel);
		try {
			socketOut.writeObject(register);
			socketOut.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		InitializeGame init= new InitializeGame();
		try {
			socketOut.writeObject(init);
			socketOut.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try
        {Thread.sleep((long)5*1000);}
    catch (Exception e)
        {e.printStackTrace();
	}
		
		while(clientModel.getPlayer()==null){
		}
		player = clientModel.getPlayer();
		System.out.println(player.getName());
		cli = new CommandLineInterface(clientModel, null);
		while (true) {
			try
	        {Thread.sleep(0);}
	    catch (Exception e)
	        {e.printStackTrace();
		}
			
			System.out.println("test the action");
			//String input = stdIn.nextLine();
			Object action= new Object();
			
			try {
				Relative relative=cli.chooseTheRelative();
				action=cli.chooseTheAction(relative);
			} catch (NullPointerException | IOException | ParseException | InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("test the action");

			try {
				// Implements the communication protocol
			//action=cli.chooseTheAction();
			
			socketOut.writeObject(action);
			socketOut.flush();
			}catch (IOException e1) {
				e1.printStackTrace();
			}
		}

	}
}

