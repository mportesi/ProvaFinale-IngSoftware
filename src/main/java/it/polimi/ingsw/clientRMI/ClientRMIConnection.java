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

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.GC_40.Observer;
import it.polimi.ingsw.actions.PutRelative;
import it.polimi.ingsw.actions.SetServant;
import it.polimi.ingsw.actions.ShiftPlayer;
import it.polimi.ingsw.changes.Change;
import it.polimi.ingsw.client.ClientModel;
import it.polimi.ingsw.client.CommandLineInterface;
import it.polimi.ingsw.components.Relative;
import it.polimi.ingsw.serverRMI.ServerRMIConnectionViewRemote;

public class ClientRMIConnection implements Serializable {
	private int RMI_PORT;
	private String HOST;
	private String NAME = "Lorenzo Il Magnifico";
	private CommandLineInterface commandLineInterface;
	private ClientModel clientModel;

	public ClientRMIConnection(int rmi_port, String host) {
		RMI_PORT = rmi_port;
		HOST = host;
	}

	public void startClient() throws RemoteException, NotBoundException, AlreadyBoundException, IOException,
			NullPointerException, ParseException, InterruptedException {
		clientModel = new ClientModel();

		Scanner stdIn = new Scanner(System.in);

		// System.setProperty("java.rmi.server.hostname", "192.168.1.2");

		// Get the remote registry
		Registry registry = LocateRegistry.getRegistry(HOST, RMI_PORT);

		// get the stub (local object) of the remote view
		ServerRMIConnectionViewRemote serverStub = (ServerRMIConnectionViewRemote) registry.lookup(NAME);

		// register the client view in the server side (to receive messages from
		// the server)

		ClientRMIConnectionView rmiView = new ClientRMIConnectionView(clientModel);

		System.out.println("\nTell me your name\n");
		String name = stdIn.nextLine();
		clientModel.setName(name);

		// register the client view in the server side (to receive messages from
		// the server)
		serverStub.registerClient(rmiView, name);

		while (true) {
			if (clientModel.getCurrentPlayer() != null) {
				float timeoutActions = (float) (System.currentTimeMillis() + 50 * 10000);
				while (clientModel.getCurrentPlayer().getName().equals(clientModel.getPlayer().getName())) {
					System.out.println("\nIt's the " + clientModel.getCurrentPlayer().getName() + "'s turn.");
					Timer timer = new Timer();
					timer.schedule(new TimerTask() {
						@Override
						public void run() {
							System.out.println("It ran out of time!");
							ShiftPlayer shiftPlayer = new ShiftPlayer();
							try {
								serverStub.notifyObserver(shiftPlayer);
							} catch (NullPointerException | IOException | ParseException | InterruptedException e) {
								e.printStackTrace();
							}
						}
					}, 20 * 10000); // TODO IMPORTARE DA JSON }}
					// Capture input from user
					CommandLineInterface commandLineInterface = new CommandLineInterface(clientModel);
					System.out.println("\nPress a key to start the action");
					String inputLine = stdIn.nextLine();
					Relative relative = commandLineInterface.chooseTheRelative();
					int servant = commandLineInterface.chooseServants(relative);
					serverStub.notifyObserver(new SetServant(servant, clientModel.getPlayer(), relative));
					PutRelative putRelative = commandLineInterface.chooseTheAction(relative);
					serverStub.notifyObserver(putRelative);
					System.out.println("\nNow your personal board is: \n" + clientModel.getPlayer());
				}

	

			}
			// otherwise it is slow
			Thread.sleep(10 * 100);

		}
	}
}
