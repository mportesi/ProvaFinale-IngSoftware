package it.polimi.ingsw.clientRMI;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.nio.channels.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.GC_40.Observer;
import it.polimi.ingsw.GC_40.TimerAction;
import it.polimi.ingsw.GC_40.TimerActionTry;
import it.polimi.ingsw.actions.PutRelative;
import it.polimi.ingsw.actions.SetServant;
import it.polimi.ingsw.actions.ShiftPlayer;
import it.polimi.ingsw.changes.Change;
import it.polimi.ingsw.client.ClientModel;
import it.polimi.ingsw.client.CommandLineInterface;
import it.polimi.ingsw.components.Relative;
import it.polimi.ingsw.json.JsonTimeOut;
import it.polimi.ingsw.serverRMI.ServerRMIConnectionViewRemote;

public class ClientRMIConnection implements Serializable {
	private int RMI_PORT;
	private String HOST;
	private String NAME = "Lorenzo Il Magnifico";
	private CommandLineInterface commandLineInterface;
	private ClientModel clientModel;
	private ServerRMIConnectionViewRemote serverStub;
	private ClientRMIConnectionView rmiView;

	public ClientRMIConnection(int rmi_port, String host) {
		RMI_PORT = rmi_port;
		HOST = host;
	}
	

	public void startClient(boolean commandLine) throws RemoteException, NotBoundException, AlreadyBoundException, IOException,
			NullPointerException, ParseException, InterruptedException {
		

		Scanner stdIn = new Scanner(System.in);

		// System.setProperty("java.rmi.server.hostname", "192.168.1.2");

		// Get the remote registry
		Registry registry = LocateRegistry.getRegistry(HOST, RMI_PORT);

		// get the stub (local object) of the remote view
		serverStub = (ServerRMIConnectionViewRemote) registry.lookup(NAME);
		clientModel = new ClientModel(serverStub);
		// register the client view in the server side (to receive messages from
		// the server)

		rmiView = new ClientRMIConnectionView(clientModel);
		
		if(commandLine){
		clientModel.setCli(true);
		clientModel.setGui(false);
		System.out.println("\nTell me your name\n");
		String name = stdIn.nextLine();
		clientModel.setName(name);
		serverStub.registerClient(rmiView, name);}
		
		
		
		
		/*while (!clientModel.getEndGame()) {
			if (clientModel.getCurrentPlayer() != null) {

				while (clientModel.getCurrentPlayer().getName().equals(clientModel.getPlayer().getName())) {
					
					
					//System.out.println("\nIt's the " + clientModel.getCurrentPlayer().getName() + "'s turn.");
					
					/*JsonTimeOut jsonTimeOut = new JsonTimeOut();
					int timeOutAction = jsonTimeOut.getTimeOutAction();
					Timer timer = new Timer();
					timer.schedule(new TimerAction(serverStub) { public void run() {
						System.out.println("It ran out of time!");
						ShiftPlayer shiftPlayer = new ShiftPlayer(clientModel.getPlayer().getMatch());
						try {
							serverStub.notifyObserver(shiftPlayer);
						} catch (NullPointerException | IOException | ParseException | InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}}, (long) (timeOutAction-150)*1000);
					CommandLineInterface commandLineInterface = new CommandLineInterface(clientModel, serverStub, timer);
					Thread action = new Thread(() -> {
						try{
							System.out.println("\nChoose: 1)Do an action 2)Print the board 3)Quit");
							commandLineInterface.input();
						}
						catch(Exception e){
							e.printStackTrace();
						}

					});
					action.start();*/
					/*JsonTimeOut jsonTimeOut = new JsonTimeOut();
					int timeOutAction = jsonTimeOut.getTimeOutAction();
					TimerActionTry timerAction=new TimerActionTry(serverStub, clientModel, action);
					try {
						action.start();
						timerAction.call();
					} catch (Exception e) {
						e.printStackTrace();
					}
					*/
					/*
					 * ExecutorService executor =
					 * Executors.newSingleThreadExecutor(); TimerActionTry
					 * timerAction=new TimerActionTry(); Future<String> future =
					 * executor.submit(timerAction);
					 */
					// Capture input from user
					

	//}

				/*
				 * try{ timerAction.call(); if(timerAction.getTimeout()){
				 * 
				 * JsonTimeOut jsonTimeOut = new JsonTimeOut(); int
				 * timeOutAction = jsonTimeOut.getTimeOutAction(); else{ throw
				 * TimeOutException; } } catch(Exception e){
				 * future.cancel(true);
				 * System.out.println("It's run out of time!"); ShiftPlayer
				 * shiftPlayer = new
				 * ShiftPlayer(clientModel.getPlayer().getMatch());
				 * serverStub.notifyObserver(shiftPlayer);
				 * 
				 * } executor.shutdownNow();
				 */
				//System.out.println("\nNow your personal board is: \n" + clientModel.getPlayer());
		/*	}

		}
		// otherwise it is slow
		try {
			Thread.sleep((long) 10 * 100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}*/
	
		
		}


	public ClientModel getClientModel() {
		return clientModel;
	}


	public ServerRMIConnectionViewRemote getServerStub() {
		return serverStub;
	}
	
	public ClientRMIConnectionView getRmiView() {
		return rmiView;
	}
	
}
