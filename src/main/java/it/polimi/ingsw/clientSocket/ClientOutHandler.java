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
		try
        {Thread.sleep((long)5*1000);}
    catch (Exception e)
        {e.printStackTrace();
	}
		
		while(clientModel.getPlayer()==null){
		}
		player = clientModel.getPlayer();
		System.out.println(player.getName());
		cli = new CommandLineInterface(clientModel);
		while (!clientModel.getEndGame()) {
			try
	        {Thread.sleep(0);}
	    catch (Exception e)
	        {e.printStackTrace();
		}
			if(clientModel.getCurrentPlayer() != null){
				while (clientModel.getCurrentPlayer().getName().equals(clientModel.getPlayer().getName())){
					System.out.println("test the action");
					//String input = stdIn.nextLine();
					Object action= new Object();
					Timer timer=new Timer();
					timer.schedule(new TimerTask() {
						@Override
						public void run() {
							System.out.println("It ran out of time!");
							ShiftPlayer shiftPlayer = new ShiftPlayer(clientModel.getPlayer().getMatch());
							try{
								socketOut.writeObject(shiftPlayer);
							} catch (IOException e1) {
								e1.printStackTrace();
							}
						}
					}, (long) 200 * 1000); //TODO IMPORT FROM JSON
					System.out.println("\nChoose: 1)Do an action 2)Print the board 3)Quit");
					//String inputLine = stdIn.nextLine();
					int input=stdIn.nextInt();
					switch(input){
					case 1:{
					Relative relative = null;
					try {
						relative = cli.chooseTheRelative();
					} catch (NullPointerException | IOException | ParseException | InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					int servant = cli.chooseServants(relative);
					try{
						socketOut.writeObject(new SetServant(servant, clientModel.getPlayer(), relative,clientModel.getPlayer().getMatch()));
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					PutRelative putRelative = null;
					try {
						putRelative = cli.chooseTheAction(relative);
					} catch (NullPointerException | IOException | ParseException | InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					try{
						socketOut.writeObject(putRelative);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					break;}
					case 2:{
						cli.printTheBoard();
						break;
					}
					case 3:{
						try{
							socketOut.writeObject(new Quit(clientModel.getPlayer(),clientModel.getPlayer().getMatch()));
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}
					}
					try
			        {Thread.sleep(5*1000);}
			    catch (Exception e)
			        {e.printStackTrace();
				}
					System.out.println("\nNow your personal board is: \n" + clientModel.getPlayer());
					timer.cancel();
					
					
					/*try {
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
					}*/
				}
			}
			// otherwise it is slow
			try {
				Thread.sleep((long)10 * 100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			

	}
}

