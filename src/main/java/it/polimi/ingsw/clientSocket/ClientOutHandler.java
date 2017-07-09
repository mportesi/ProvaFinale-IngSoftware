package it.polimi.ingsw.clientSocket;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.GC_40.Player;
import it.polimi.ingsw.actions.InitializeGame;
import it.polimi.ingsw.actions.PutRelative;
import it.polimi.ingsw.actions.Quit;
import it.polimi.ingsw.actions.RegisterClient;
import it.polimi.ingsw.actions.RegisterClientSocket;
import it.polimi.ingsw.actions.SetServant;
import it.polimi.ingsw.actions.ShiftPlayer;
import it.polimi.ingsw.client.ClientModel;
import it.polimi.ingsw.client.CommandLineInterface;
import it.polimi.ingsw.components.Relative;

public class ClientOutHandler implements Runnable {

	private ObjectOutputStream socketOut;
	private ClientModel clientModel;
	private CommandLineInterface cli;
	private Player player;//= new Player();
	private boolean commandLine;
	public ClientOutHandler(ObjectOutputStream socketOut, ClientModel clientModel, boolean commandLine) {
		this.socketOut = socketOut;
		this.clientModel=clientModel;
		this.commandLine=commandLine;
		//this.player= clientModel.getPlayer();
		//cli = new CommandLineInterface(this.clientModel.getPlayer(), clientModel);
	}

	@Override
	public void run() {
		// Handles output messages, from the client to the server
		if(commandLine){
			clientModel.setCli(true);
			clientModel.setGui(false);
			System.out.println("RUNNING");
			System.out.println("choose your name: ");
			Scanner stdIn = new Scanner(System.in);
			String name= stdIn.nextLine();
			clientModel.setName(name);
			RegisterClientSocket register=new RegisterClientSocket(name);
			//RegisterClient register = new RegisterClient(name);
			//this.player= clientModel.getPlayer();
			//cli = new CommandLineInterface(player, clientModel);
			try {
				socketOut.writeObject(register);
				socketOut.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		

	}
}

